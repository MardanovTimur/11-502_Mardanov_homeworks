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
    public boolean addProducer(Producer producer) {
        if (JDBConnection.getInstance().getConnection()!=null && producer!=null) {
            String request = "INSERT INTO producers (producer_name) VALUES ( ? )";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1,producer.getName());
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public Producer getProducer(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT producer_name, id FROM producers WHERE id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,id);
                ResultSet rs = JDBConnection.getInstance().getStatement().executeQuery();
                while (rs.next()) {
                    return new Producer(rs.getString("producer_name"), rs.getInt("id"));
                }
            } catch (SQLException s) {
                s.printStackTrace();
            } catch (NullPointerException n) {
                return null;
            }
        }
        return null;
    }
    public void deleteProducer(int id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "DELETE FROM producers WHERE id = ? ";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, id);
                JDBConnection.getInstance().getStatement().execute();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
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