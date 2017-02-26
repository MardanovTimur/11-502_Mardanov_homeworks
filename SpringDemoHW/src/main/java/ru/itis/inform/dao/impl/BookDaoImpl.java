package ru.itis.inform.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.BookDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Тимур on 22.02.2017.
 */

@Component("jdbc.book.dao")
public class BookDaoImpl implements BookDao {

    private User user;

    //language=SQL
    private String SQL_SELECT_ALL_BOOKS_USER_ID = "SELECT u.id AS user_id," +
            "u.name AS user_name, u.age, b.id AS book_id," +
            "b.name AS book_name FROM books AS b, users AS u WHERE u.id = :userId AND b.user_id = u.id";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private RowMapper<Book> rowMapper = new RowMapper<Book>() {
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            if (user==null)
                user = new User(resultSet.getLong("user_id"),resultSet.getInt("age"),resultSet.getString("user_name"),new LinkedList<Book>(), new LinkedList<>());
            Book book = new Book(resultSet.getLong("book_id"),resultSet.getString("book_name"),null);
            user.getBooks().add(book);
            book.setUser(user);
            return book;
        }
    };

    public List<Book> getAllBooksByUserId(Long id) {
        user = null;
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("userId", id);
        List<Book> books = jdbcTemplate.query(SQL_SELECT_ALL_BOOKS_USER_ID, parameterMap, rowMapper);
        return books;
    }

    public Long save(Book book) {
        return null;
    }

    public void update(Book book) {

    }

    public Book find(Long id) {
        return null;
    }

    public void delete(Long id) {

    }

    public List<Book> findAll() {
        return null;
    }
}
