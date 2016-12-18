package ru.itis.inform.dao;

import ru.itis.inform.models.FilmExistance;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Тимур on 08.11.2016.
 */
public class FilmExistanceDaoImpl implements FilmExistanceDao {
    public void addExistance(int id, int quantity, int price) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "INSERT INTO film_existance (id,quantity,price) VALUES (?,?,?);";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,id);
                JDBConnection.statement.setInt(2,quantity);
                JDBConnection.statement.setInt(3, price);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }

    public boolean ifExist(int id) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "SELECT (id,quantity, price) FROM film_existance WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,id);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                while (resultSet.next()) {
                    return true;
                }
                return false;
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return false;
    }

    public FilmExistance getFilmExistance(int id) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "SELECT * FROM film_existance WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,id);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                while (resultSet.next()) {
                    return new FilmExistance(resultSet.getInt("id"),resultSet.getInt("quantity"),resultSet.getInt("price"));
                }
                return null;
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public void deleteExistance(int id) {

    }

    public boolean updateExistance(int id, int quantity) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "UPDATE film_existance SET (quantity)=(?) " +
                    "WHERE id = ?;";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,quantity);
                JDBConnection.statement.setInt(2,id);
                JDBConnection.getInstance().getStatement().executeUpdate();
                return true;
            } catch (SQLException sql) {
                sql.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
