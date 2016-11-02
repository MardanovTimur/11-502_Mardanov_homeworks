package ru.itis.inform.factories;

/**
 * Created by Тимур on 02.11.2016.
 */
public class ConnectionFactory {
    private static ConnectionFactory instance;


    private ConnectionFactory() {

    }

    static {
        instance = new ConnectionFactory();
    }
}
