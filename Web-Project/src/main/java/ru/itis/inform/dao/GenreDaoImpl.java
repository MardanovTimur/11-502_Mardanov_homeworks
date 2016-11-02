package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public class GenreDaoImpl implements GenreDao {
    public boolean addGenre(Genre genre) {
        if (JDBConnection.getInstance().getConnection()!=null && genre!=null) {
            String request = "INSERT INTO genres (genre_name) VALUES ( ? )";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,genre.getName());
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Genre getGenre(String name) {
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT * FROM genres WHERE genre_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Genre(rs.getInt("id"), rs.getString("genre_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public Genre getGenreById(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM genres WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, id);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Genre(rs.getInt("id"), rs.getString("genre_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public LinkedList<Genre> getGenres() {
        LinkedList<Genre> genreLinkedList = new LinkedList<Genre>();
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM genres";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    genreLinkedList.addFirst(new Genre(rs.getInt("id"), rs.getString("genre_name")));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return  null;
            }
        }
        return genreLinkedList;
    }
}
