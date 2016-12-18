package ru.itis.inform.dao;

import ru.itis.inform.models.Buy;
import ru.itis.inform.models.BuyMod;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 28.11.2016.
 */
public class BuyDaoImpl implements BuyDao {

    //Покупка фильма с интернет магазина = хранимая процедура.
    public boolean buy(int filmId, int userId, int quantity, Date date1, Date date2) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM addorder(?,?,?,?,?);";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, filmId);
                JDBConnection.statement.setInt(2, userId);
                JDBConnection.statement.setInt(3, quantity);
                JDBConnection.statement.setDate(4, date1);
                JDBConnection.statement.setDate(5, date2);
                ResultSet rs = JDBConnection.statement.executeQuery();
                while (rs.next()) {
                    return rs.getBoolean("addorder");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Показ только своих покупок по возрастанию времени
    public LinkedList<Buy> getBuys(int buy_id) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM buy WHERE buy_id = ? ORDER BY start ASC;";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1, buy_id);
                ResultSet rs = JDBConnection.statement.executeQuery();
                LinkedList<Buy> linkedList = new LinkedList<Buy>();
                while (rs.next()) {
                    linkedList.addFirst(new Buy(rs.getInt("buy_id"), rs.getInt("id"), rs.getDate("start"), rs.getDate("final"), rs.getInt("quantity")));
                }
                return linkedList;
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }

    @Override
    //Показ всех покупок только для админа, с использованием вьюхи, которая позволяет показывать все, кроме покупок админа
    public LinkedList<BuyMod> getBuysExceptAdmin() {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM getAllBuys;";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                ResultSet rs = JDBConnection.statement.executeQuery();
                LinkedList<BuyMod> linkedList = new LinkedList<BuyMod>();
                while (rs.next()) {
                    linkedList.addFirst(new BuyMod(rs.getString("user_name"), rs.getString("film_name"), rs.getDate("start"), rs.getDate("final"), rs.getInt("quantity"), Integer.parseInt(rs.getString("user_id")), rs.getInt("film_id")));
                }
                return linkedList;
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
        return null;
    }

    @Override
    // Еще одна хранимка, которая позволяет админу(продавцу) принимать купленный заказ обратно в магазин
    public boolean giveUp(int user_id, int film_id, int quantity) {
        if (JDBConnection.getInstance().getConnection() != null) {
            String request = "SELECT * FROM acceptOrder(?,?,?);";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setString(1, ""+user_id);
                JDBConnection.statement.setInt(2, film_id);
                JDBConnection.statement.setInt(3, quantity);
                ResultSet rs = JDBConnection.statement.executeQuery();
                while (rs.next()) {
                    return rs.getBoolean("acceptorder");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}