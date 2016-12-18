package ru.itis.inform.dao;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Тимур on 11.12.2016.
 */
public class Remarks {
    //Узнать количество всех голосов за фильм по айди
    public int getSize(int film_id) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "SELECT count(*) FROM remarks WHERE film_id = ?";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,film_id);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                while (resultSet.next()) {
                    return resultSet.getInt("count");
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return 0;
    }

    //Еще одна хранимка Выполняет подсчет всех голосов за фильм и высставляет среднее арифметическое
    public void update(int film_id, int user_id, int remark) {
        if (JDBConnection.getInstance().getConnection()!=null) {
            String request = "SELECT * FROM updateOrder(?,?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,film_id);
                JDBConnection.statement.setString(2,""+user_id);
                JDBConnection.statement.setInt(3,remark);
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }
}
