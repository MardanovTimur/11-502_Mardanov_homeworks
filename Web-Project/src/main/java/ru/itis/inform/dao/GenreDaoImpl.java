package ru.itis.inform.dao;

import jdk.nashorn.internal.scripts.JD;
import ru.itis.inform.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public class GenreDaoImpl implements GenreDao {
    public Genre getGenre(String name) {
        if (JDBConnection.getInstance().getConnection()!=null && !name.equals("")) {
            String request = "SELECT * FROM genres(id, genre_name) WHERE genre_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Genre(rs.getInt("id"),rs.getString("genre_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public List<Genre> getGenres() {
        return null;
    }
}
