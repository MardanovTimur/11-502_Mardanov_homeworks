package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public void addUser(User user) {
        if (JDBConnection.getInstance().getConnection() != null && user != null) {
            String request = "INSERT INTO users (id,user_name,login,user_password,is_admin) VALUES ";
            String parameters = "('" + user.getId() + "','" + user.getName() + "','" + user.getLogin() + "','" + user.getPassword() + "'," + user.getIs_admin() + ");";
            try {
               JDBConnection.getInstance().getStatement().executeUpdate(request+parameters);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser(String login) {
        if (JDBConnection.getInstance().getConnection()!= null && !login.equals("")) {
            String reguest = "SELECT * FROM users WHERE login='" + login + "';";
            return selectRequest(reguest);
        }
        return null;
    }
    public User findUserId(String id) {
        if (JDBConnection.getInstance().getConnection()!= null && !id.equals("")) {
            String reguest = "SELECT * FROM users WHERE id='" + id + "';";
            return selectRequest(reguest);
        }
        return null;
    }

    public User selectRequest(String request) {
        try {
            ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery(request);
            while (resultSet.next()) {
                return new User(resultSet.getString("id"),resultSet.getString("user_name"), resultSet.getString("login"), resultSet.getString("user_password"), resultSet.getBoolean("is_admin"));
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
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
