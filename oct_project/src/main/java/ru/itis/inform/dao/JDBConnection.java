package ru.itis.inform.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBConnection {

    private static JDBConnection instance = new JDBConnection();

    private Connection connection;
    private PreparedStatement statement;
    private String url = "jdbc:postgresql://localhost:5432/videosystem";
    private String name = "postgres";
    private String password = "alisa654789";

    public JDBConnection() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.print("Driver is ready");
            this.connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection installed");
            this.statement = (PreparedStatement) connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    public JDBConnection getConnection() {
        return instance;
    }

    public static JDBConnection getInstance() {
        return instance;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

}
