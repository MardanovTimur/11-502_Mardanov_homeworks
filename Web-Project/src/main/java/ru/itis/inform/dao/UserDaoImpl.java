package ru.itis.inform.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template;

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO users (id,user_name,login,user_password,is_admin) VALUES (?,?,?,?,?) ";
    //language=SQL
    private final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ? ";
    //language=SQL
    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ? ";
    //language=SQL
    private final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    //language=SQL
    private final String SQL_CHANGE_RULES_ON_USER = "UPDATE users SET is_admin = ? WHERE id = ?";


    private RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getString("id"), resultSet.getString("user_name"), resultSet.getString("login"), resultSet.getString("user_password"), resultSet.getBoolean("is_admin"));
        }
    };

    public UserDaoImpl() {

    }


    public void addUser(User user) {
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER);
                ps.setString(1, "" + user.getId());
                ps.setString(2, user.getName());
                ps.setString(3, user.getLogin());
                ps.setString(4, user.getPassword());
                ps.setBoolean(5, user.getIs_admin());
                return ps;
            }
        });

    }

    public User findUser(String login) {
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_LOGIN, new Object[]{login}, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findUserId(String id) {
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_ID, new Object[]{id}, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<User> findUsers(String login) {
        return template.query(SQL_SELECT_USER_BY_LOGIN, new Object[]{login}, rowMapper);
    }

    public void deleteUser(String id) {
        template.update(SQL_DELETE_USER_BY_ID, new Object[]{id});
    }

    public void changeRulesInUser(String id) {
        template.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHANGE_RULES_ON_USER);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, id);
            return preparedStatement;
        });
    }

    public void addImage(byte[] image, String id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "INSERT INTO users image VALUES ? WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setBytes(1, image);
                JDBConnection.statement.setString(2, id);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
