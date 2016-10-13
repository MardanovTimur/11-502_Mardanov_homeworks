package ru.itis.inform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Тимур on 13.10.2016.
 */
public class TokenDaoImpl implements TokenDao {
    public void addToken(String id, String token) {
        if (JDBConnection.getInstance().getConnection() != null && !id.equals("") && !token.equals("")) {
            String request = "INSERT INTO cookies (id,token) VALUES (" + "'" + id + "'," + "'" + token + "');";
            try {
                JDBConnection.getInstance().getStatement().executeUpdate(request);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public void updateToken(String id, String token) {
        if (JDBConnection.getInstance().getConnection() != null && !id.equals("") && !token.equals("")) {
            String request = "UPDATE cookies SET (token) = (" + "'" + token + "') " +
                    "WHERE id = '" + id + "';";
            try {
                JDBConnection.getInstance().getStatement().executeUpdate(request);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public void deleteToken(String token) {
        if (JDBConnection.getInstance().getConnection() != null && !token.equals("")) {
            String request = "DELETE FROM cookies " +
                    "WHERE token = '" + token + "';";
            try {
                JDBConnection.getInstance().getStatement().executeUpdate(request);
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public String findToken(String token) {
        if (JDBConnection.getInstance().getConnection() != null && !token.equals("")) {
            String request = "SELECT * FROM cookies " +
                    "WHERE token='" + token + "';";
            try {
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery(request);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("id"));
                    return resultSet.getString("id");
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

}