package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws SQLException;
    User findUser(String id);
  //User findUser(String login);
    List<User> findUsers(String id);
    void deleteUser(String id);
    void changeRulesInUser(String id);
    Connection getConnection();
    PreparedStatement getStatement();
}
