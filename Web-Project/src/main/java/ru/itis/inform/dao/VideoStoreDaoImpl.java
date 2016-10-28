package ru.itis.inform.dao;

import ru.itis.inform.models.Film;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 16.10.2016.
 */
public class VideoStoreDaoImpl implements VideoStoreDao {
    public void add(Film film) {
        if (JDBConnection.getInstance().getConnection() != null && film != null) {
            String request = "INSERT INTO films (film_name, film_producer, film_studio,film_year,description,remark) VALUES (?,?,?,?,?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, film.getName());
                JDBConnection.statement.setInt(2, film.getProducer());
                JDBConnection.statement.setInt(3, film.getStudio());
                JDBConnection.statement.setDate(4, film.getDate());
                JDBConnection.statement.setString(5, film.getDescription());
                JDBConnection.statement.setInt(6, film.getRemark());
                JDBConnection.getInstance().getStatement().execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getId(String name) {
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT id FROM films WHERE film_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return rs.getInt("id");
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return 0;
    }

    public void delete(String id) {
        if (JDBConnection.getInstance().getConnection() != null && !id.equals("")) {
            String request = "DELETE FROM films WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, id);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException es) {
                es.printStackTrace();
            }
        }
    }

    public LinkedList<Film> getAllFilms() {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM films ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                LinkedList<Film> linkedList = new LinkedList<Film>();
                Film film = null;
                while (rs.next()) {
                    try {
                        film = new Film(rs.getInt("id"),rs.getString("film_name"),rs.getInt("film_producer"),rs.getInt("film_studio"),rs.getString("description"),rs.getInt("remark"),rs.getDate("film_year"));
                    } catch (Exception e) {
                        film = null;
                        e.printStackTrace();
                    }
                    linkedList.addFirst(film);
                }
                return linkedList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Film getFilm(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM films WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,id);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                Film film = null;
                while (rs.next()) {
                    try {
                        film = new Film(rs.getInt("id"),rs.getString("film_name"),rs.getInt("film_producer"),rs.getInt("film_studio"),rs.getString("description"),rs.getInt("remark"),rs.getDate("film_year"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                    return film;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
