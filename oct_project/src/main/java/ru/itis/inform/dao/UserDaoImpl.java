package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JDBConnection jdbConnection;

    public void addUser(User user) {
        if (jdbConnection.getConnection() != null && user != null) {
            String request = "INSERT INTO users (id,name,login,password,is_admin) VALUES ";
            String parameters = "(" + user.getId() + ",'" + user.getName() + "','" + user.getLogin() + "','" + user.getPassword() + "'," + user.getIs_admin() + ");";
            try {
               jdbConnection.getStatement().executeUpdate(request+parameters);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser(String login) {
        if (jdbConnection.getConnection()!= null && !login.equals("")) {
            String reguest = "SELECT * FROM users WHERE login='" + login + "';";
            try {
                ResultSet resultSet = jdbConnection.getStatement().executeQuery(reguest);
                while (resultSet.next()) {
                    return new User(resultSet.getString("name"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getBoolean("is_admin"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public List<User> findUsers(String id) {
        return null;
    }

    public void deleteUser(String id) {

    }

    public void changeRulesInUser(String id) {

    }
}
