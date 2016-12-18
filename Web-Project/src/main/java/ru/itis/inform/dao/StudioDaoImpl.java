package ru.itis.inform.dao;

import ru.itis.inform.models.Producer;
import ru.itis.inform.models.Studio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public class StudioDaoImpl implements StudioDao {
    public boolean addStudio(Studio role) {
        if (JDBConnection.getInstance().getConnection()!=null && role!=null) {
            String request = "INSERT INTO studios (studio_name) VALUES ( ? )";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,role.getName());
                JDBConnection.getInstance().getStatement().executeUpdate();
                return true;
            } catch (SQLException s) {
                s.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Studio getStudioByFilmId(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM studios WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, id);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Studio(rs.getInt("id"), rs.getString("studio_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public Studio getStudio(String name) {
        if (JDBConnection.getInstance().getConnection() != null && !name.equals("")) {
            String request = "SELECT * FROM studios WHERE studio_name = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, name);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Studio(rs.getInt("id"), rs.getString("studio_name"));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        return null;
    }

    public LinkedList<Studio> getStudios() {
        LinkedList<Studio> producerLinkedList = new LinkedList<Studio>();
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM studios";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    producerLinkedList.add(new Studio(rs.getInt("id"),rs.getString("studio_name")));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return null;
            }
        }
        return producerLinkedList;
    }

    public void deleteStudio(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "DELETE FROM studios WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, id);
                JDBConnection.getInstance().getStatement().execute();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
    }
}
