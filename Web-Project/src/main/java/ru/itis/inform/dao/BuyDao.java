package ru.itis.inform.dao;

import ru.itis.inform.models.Buy;
import ru.itis.inform.models.BuyMod;

import java.sql.Date;
import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface BuyDao {
    //Покупка фильма с интернет магазина = хранимая процедура.
    boolean buy(int filmId, int userId, int quantity , Date date1, Date date2);

    //Показ только своих покупок по возрастанию времени
    LinkedList<Buy> getBuys(int buy_id);

    //Показ всех покупок только для админа, с использованием вьюхи, которая позволяет показывать все, кроме покупок админа
    LinkedList<BuyMod> getBuysExceptAdmin();

    // Еще одна хранимка, которая позволяет админу(продавцу) принимать купленный заказ обратно в магазин
    boolean giveUp(int user_id, int film_id, int quantity);
}
