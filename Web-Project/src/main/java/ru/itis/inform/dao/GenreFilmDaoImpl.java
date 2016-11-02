package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 27.10.2016.
 */
public class GenreFilmDaoImpl implements GenreFilmDao {
    public LinkedList getGenreIdByFilmId(int filmId) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT genre_id FROM genres_films WHERE film_id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, filmId);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                LinkedList linkedList = new LinkedList();
                while (resultSet.next()) {
                     linkedList.add(resultSet.getInt("genre_id"));
                }
                return linkedList;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

    public boolean addGenresOnFilm(int genreId, int filmId) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "INSERT INTO genres_films (genre_id, film_id) VALUES (?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, genreId);
                JDBConnection.statement.setInt(2, filmId);
                JDBConnection.getInstance().getStatement().executeUpdate();
                return true;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return false;
    }
}

