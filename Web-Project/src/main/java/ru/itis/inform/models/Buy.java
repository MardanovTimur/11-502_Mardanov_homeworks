package ru.itis.inform.models;


import java.sql.Date;

/**
 * Created by Тимур on 03.10.2016.
 */
//Модель покупки
public class Buy {
    private int buy_id;
    private int id;
    private Date date;
    private Date date2;
    private int quantity;

    public Buy(int buy_id, int id, Date date, Date date2, int quantity) {
        this.buy_id = buy_id;
        this.id = id;
        this.date = date;
        this.date2 = date2;
        this.quantity = quantity;
    }

    public int getBuy_id() {
        return buy_id;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Date getDate2() {
        return date2;
    }

    public int getQuantity() {
        return quantity;
    }
}
