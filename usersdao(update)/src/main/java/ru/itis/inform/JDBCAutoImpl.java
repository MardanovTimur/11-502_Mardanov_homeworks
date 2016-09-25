package ru.itis.inform;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCAutoImpl implements AutoDao {

    private Connection connection = null;
    private Statement statement = null;
    private String url = "jdbc:postgresql://localhost:5432/studentsauto";
    private String name = "postgres";
    private String password = "alisa654789";

    public JDBCAutoImpl() {
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
        request = "SELECT * FROM auto;";
        ResultSet resultSet = statement.executeQuery(request);
        List autoList = new LinkedList();
        Auto auto = null;
        while (resultSet.next()) {
            auto = new Auto(resultSet.getString("name"), resultSet.getString("year"));
            autoList.add(auto);
        }
        return autoList;
    }

    public void save(Auto auto) throws FileNotFoundException {

    }

    public Auto find(String string) throws FileNotFoundException {
        return null;
    }

    public void closePW() {

    }

    public void closeSC() {

    }
}
