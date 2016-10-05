package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private PreparedStatement statement;
    private String url = "jdbc:postgresql://localhost:5432/videosystem";
    private String name = "postgres";
    private String password = "alisa654789";

    public UserDaoImpl() {
        connection = null;
        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");
            System.out.print("Driver is ready/");
            //Создаём соединение
            this.connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection installed");
            this.statement = (PreparedStatement) connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public void addUser(User user) throws SQLException {
        if (user != null) {
            String request = "INSERT INTO users (id,name,login,password,is_admin) VALUES ";
            String parameters = "(" + user.getId() + ",'" + user.getName() + "','" + user.getLogin() + "','" + user.getPassword() + "','" + user.getIs_admin() + "');";
            statement.executeUpdate(request);
        }
    }

    public User findUser(String id) {
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
