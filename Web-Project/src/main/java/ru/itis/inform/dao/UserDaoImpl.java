package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public void addUser(User user) {
        if (JDBConnection.getInstance().getConnection() != null && user != null) {
            String request = "INSERT INTO users (id,user_name,login,user_password,is_admin) VALUES (?,?,?,?,?) ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,""+user.getId());
                JDBConnection.statement.setString(2,user.getName());
                JDBConnection.statement.setString(3,user.getLogin());
                JDBConnection.statement.setString(4,user.getPassword());
                JDBConnection.statement.setBoolean(5,user.getIs_admin());
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User findUser(String login) {
        if (JDBConnection.getInstance().getConnection()!= null && !login.equals("")) {
            String reguest = "SELECT * FROM users WHERE login= ? ";
            return selectRequest(reguest, login);
        }
        return null;
    }
    public User findUserId(String id) {
        if (JDBConnection.getInstance().getConnection()!= null && !id.equals("")) {
            String reguest = "SELECT * FROM users WHERE id= ? ";
            return selectRequest(reguest,id);
        }
        return null;
    }

    public User selectRequest(String request, String param) {
        try {
            JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
            JDBConnection.statement.setString(1,param);
            ResultSet resultSet = JDBConnection.statement.executeQuery();
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

    public void addImage(byte[] image, String id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "INSERT INTO users image VALUES ? WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setBytes(1,image);
                JDBConnection.statement.setString(2,id);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
