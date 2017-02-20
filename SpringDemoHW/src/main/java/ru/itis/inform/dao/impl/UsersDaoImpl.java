package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Тимур on 15.02.2017.
 */

@Component
public class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate;
    private Map<Long, User> listOfUserBooks;

    //language=SQL
    private final String SQL_SELECT_BY_ID= "SELECT * FROM users WHERE id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM users";
    //language=SQL
    private final String SQL_SELECT_ALL_BY_AGE = "SELECT * FROM users WHERE age = ?";
    //language=SQL
    private final String SQL_SAVE_USER = "INSERT INTO users (age,name) VALUES (?,?)";
    //language=SQL
    private final String SQL_UPDATE_USER = "UPDATE users SET age=?, name=? WHERE id = ?";
    //language=SQL
    private final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    //language=SQL
    private final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM books";
    //language=SQL
    private final String SQL_SELECT_ALL_BOOKS_USER_ID = "SELECT * FROM books WHERE user_id = ?";

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(resultSet.getLong("id"),resultSet.getInt("age"),resultSet.getString("name"), new LinkedList<Book>());
            listOfUserBooks.put(user.getId(), user);
            return user;
        }
    };

    private RowMapper<Book> bookRowMapper = new RowMapper<Book>() {
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book(resultSet.getLong("id"),resultSet.getString("name"),null);
            book.setUser(listOfUserBooks.get(resultSet.getLong("user_id")));
            listOfUserBooks.get(resultSet.getLong("user_id")).setBook(book);
            return book;
        }
    };

    public List<User> findByAge(int age) {
        try {
            listOfUserBooks = new HashMap<Long, User>();
            jdbcTemplate.query(SQL_SELECT_ALL_BY_AGE,new Object[]{age},rowMapper);
            Iterator<User> iterator = listOfUserBooks.values().iterator();
            while (iterator.hasNext()) {
                jdbcTemplate.query(SQL_SELECT_ALL_BOOKS_USER_ID, new Object[]{iterator.next().getId()},bookRowMapper);
            }
            return new LinkedList<User>(listOfUserBooks.values());
        } catch (EmptyResultDataAccessException e) {
            return new LinkedList<User>();
        }
    }

    public Long save(final User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_SAVE_USER, new String[]{"id"});
                ps.setInt(1,user.getAge());
                ps.setString(2,user.getName());
                return ps;
            }
        }, keyHolder);
        return  keyHolder.getKey().longValue();
    }

    public void update(final User user) {
        final Long id = user.getId();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER);
                ps.setInt(1,user.getAge());
                ps.setString(2,user.getName());
                ps.setLong(3,user.getId());
                return ps;
            }
        });
    }

    public User find(Long id) {
        try {
            listOfUserBooks = new HashMap<Long, User>();
            jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, rowMapper);
            Iterator<User> iterator = listOfUserBooks.values().iterator();
            while (iterator.hasNext()) {
                jdbcTemplate.query(SQL_SELECT_ALL_BOOKS_USER_ID,new Object[]{iterator.next().getId()},bookRowMapper);
            }
            return listOfUserBooks.get(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void delete(Long id) throws DataIntegrityViolationException {
        jdbcTemplate.update(SQL_DELETE_USER_BY_ID, new Object[]{id});
    }

    public List<User> findAll() {
        listOfUserBooks = new HashMap<Long, User>();
        try {
            jdbcTemplate.query(SQL_SELECT_ALL, rowMapper);
            jdbcTemplate.query(SQL_SELECT_ALL_BOOKS, bookRowMapper);
            return new LinkedList<User>(listOfUserBooks.values());
        } catch (EmptyResultDataAccessException e) {
            return new LinkedList<User>();
        }
    }
}
