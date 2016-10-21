package ru.itis.inform.dao;

import java.sql.SQLException;

/**
 * Created by Тимур on 19.10.2016.
 */
public class RoleFilmDaoImpl implements RoleFilmDao {

    public boolean addRolesOnFilm(int roleId, int filmId) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "INSERT INTO roles_films (role_id, film_id) VALUES (?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, roleId);
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
