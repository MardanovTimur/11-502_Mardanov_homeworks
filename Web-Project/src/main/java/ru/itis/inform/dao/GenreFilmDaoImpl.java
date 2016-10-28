package ru.itis.inform.dao;

import java.sql.SQLException;

/**
 * Created by Тимур on 27.10.2016.
 */
public class GenreFilmDaoImpl implements GenreFilmDao {
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

