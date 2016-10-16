package ru.itis.inform.dao;

import ru.itis.inform.models.Film;

import java.sql.SQLException;

/**
 * Created by Тимур on 16.10.2016.
 */
public class VideoStoreDaoImpl implements VideoStoreDao {
    public void add(Film film) {
        if (JDBConnection.getInstance().getConnection()!=null && film!=null) {
            String request = "INSERT INTO films (film_name, film_producer, film_studio,film_year,description,remark) VALUES (?,?,?,?,?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                //JDBConnection.statement.setInt(1,film.getId());
                JDBConnection.statement.setString(1,film.getName());
                JDBConnection.statement.setInt(2,film.getProducer());
                JDBConnection.statement.setInt(3,film.getStudio());
                JDBConnection.statement.setString(4,film.getDate());
                JDBConnection.statement.setString(5,film.getDescription());
                JDBConnection.statement.setInt(6,film.getRemark());
                JDBConnection.getInstance().getStatement().execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String id) {
        if (JDBConnection.getInstance().getConnection()!=null && id.equals("")) {
            String request = "DELETE FROM films WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,id);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
