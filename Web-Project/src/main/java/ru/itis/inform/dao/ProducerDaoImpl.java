package ru.itis.inform.dao;

import ru.itis.inform.models.Producer;
import ru.itis.inform.models.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 27.10.2016.
 */
public class ProducerDaoImpl implements ProducerDao {
    public boolean addProducer(Producer role) {
        return false;
    }

    public Producer getProducer(String name) {
        return null;
    }

    public LinkedList<Producer> getProducers() {
        LinkedList<Producer> producerLinkedList = new LinkedList<Producer>();
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM producers";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    producerLinkedList.add(new Producer(rs.getString("producer_name"), rs.getInt("id")));
                }
            } catch (SQLException sql) {
                sql.printStackTrace();
                return null;
            }
        }
        return producerLinkedList;
    }
}