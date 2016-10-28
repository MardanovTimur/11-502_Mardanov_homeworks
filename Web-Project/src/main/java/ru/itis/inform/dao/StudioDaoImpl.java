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
        return false;
    }

    public Studio getStudio(String name) {
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
}
