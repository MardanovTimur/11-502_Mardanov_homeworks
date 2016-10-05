package ru.itis.inform.JDBC;

import ru.itis.inform.User;
import ru.itis.inform.UsersDao;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCUsersImpl implements UsersDao {
    private Connection connection = null;
    private Statement statement = null;
    private String url = "jdbc:postgresql://localhost:5432/studentsauto";
    private String name = "postgres";
    private String password = "alisa654789";

    public JDBCUsersImpl() {

        this.connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver connected");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection is ok!");
            this.statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("FAIL!!!!!!!!!!!!!!!!!!!!!");
            Logger.getLogger(JDBCUsersImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (connection != null) {
                System.out.print("Not null connection!");
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCUsersImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List findAll() throws FileNotFoundException, SQLException {
        this.connection = DriverManager.getConnection(url,name, password);
        statement = connection.createStatement();
        String request;
        request = "SELECT * FROM students;";
        ResultSet resultSet = statement.executeQuery(request);
        List students = new LinkedList();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getString("name"), resultSet.getString("id"), resultSet.getString("password"), resultSet.getInt("year"), resultSet.getString("city"));
            students.add(user);
        }
        return students;
    }

    public void save(User user) throws FileNotFoundException, SQLException {
        this.connection = DriverManager.getConnection(url,name, password);
        statement = connection.createStatement();
        String request;
        String pole = "INSERT INTO students (name, id, password, year, city) VALUES ";
        request = "( '" + user.getName() + "', '" + user.getId() + "', '" + user.getPassword() + "', " + user.getYear() + ", '" + user.getCity() + "');";
        pole += request;
        request = pole;
        statement.executeUpdate(request);
    }

    public User find(String string, int definition) throws FileNotFoundException, SQLException {
        this.connection = DriverManager.getConnection(url,name, password);
        statement = connection.createStatement();
        String reguest;
        String parameter = null;
        switch (definition) {
            case 0: {
                parameter = "name";
                break;
            }
            case 1: {
                parameter = "id";
                break;
            }
            case 2: {
                parameter = "year";
                break;
            }
            case 3: {
                parameter = "city";
                break;
            }
        }
        reguest = "SELECT * FROM students s" +
                " WHERE s." + parameter + "= '" + string + "';";
        ResultSet resultSet = statement.executeQuery(reguest);

        while (resultSet.next()) {
            return new User(resultSet.getString("name"), resultSet.getString("id"), resultSet.getString("password"), resultSet.getInt("year"), resultSet.getString("city"));
        }
        return null;
    }

    public void closePW() {
    }

    public void closeSC() {
    }
}
