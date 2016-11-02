package ru.itis.inform.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 19.10.2016.
 */
public class RoleFilmDaoImpl implements RoleFilmDao {

    public LinkedList getRoleIdByFilmId(int filmId) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT role_id FROM roles_films WHERE film_id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, filmId);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                LinkedList linkedList = new LinkedList();
                while (resultSet.next()) {
                    linkedList.add(resultSet.getInt("role_id"));
                }
                return linkedList;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

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
