package ru.itis.inform.dao;

import java.sql.*;

public class JDBConnection {

    private static JDBConnection instance = new JDBConnection();

    private Connection connection;
    private Statement statement;
    private String url = "jdbc:postgresql://localhost:5432/videodata";
    private String name = "postgres";
    private String password = "alisa654789";

    private JDBConnection() {
        connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.print("Driver is ready");
            this.connection = DriverManager.getConnection(url, name, password);
            System.out.println("Connection installed");
            this.statement =  connection.createStatement();
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

    public Statement getStatement() {
        return statement;
    }

}
