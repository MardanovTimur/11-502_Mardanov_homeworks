package ru.itis.inform.dao;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBConnection {
//Класс для связи postgresql с ядром java
    private static JDBConnection instance = new JDBConnection();
    private Properties classDB;
    private static Connection connection;
    public static PreparedStatement statement;
    private String server;
    private String port;
    private String nameDB;
    private String name;
    private String password;

    private JDBConnection() {
        connection = null;
        try {
            //Подгрузка нужных нам драйверов для бд, настраивается в файле classDataBase
            classDB = new Properties();
            classDB.load(new FileInputStream("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\Web-Project\\src\\main\\resources\\classDataBase"));
            Class.forName(classDB.getProperty("driver"));
            System.out.print("Driver is ready");

            //Подгрузка нужных нам полей для бд(пользователь-пароль-бд-порт и тд), настраивается в файле settings.Properties
            if (getSettings()) {
                this.connection = DriverManager.getConnection(getServer()+ ":" + getPort()+ "/" + getNameDB(), getName(), getPassword());
                System.out.println("Connection installed");
            } else {
                System.out.println("Connection is'nt installed");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getServer() {
        return server;
    }

    public String getPort() {
        return port;
    }

    public String getNameDB() {
        return nameDB;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean getSettings(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\Web-Project\\src\\main\\resources\\settings.properties"));
            setServer(properties.getProperty("server"));
            setPort(properties.getProperty("port"));
            setNameDB(properties.getProperty("nameDB"));
            setName(properties.getProperty("name"));
            setPassword(properties.getProperty("password"));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static JDBConnection getInstance() {
        return instance;
    }

    public PreparedStatement  getStatement() {
        return statement;
    }

}
