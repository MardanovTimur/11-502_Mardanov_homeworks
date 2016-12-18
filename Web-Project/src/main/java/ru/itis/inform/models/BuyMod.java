package ru.itis.inform.models;

import java.sql.Date;

/**
 * Created by Тимур on 10.12.2016.
 */
//Обновленная модель покупки(юзернэйм + фильмнэйм)
public class BuyMod {
    private String user_name;
    private String film_name;
    private Date start;
    private Date fin;
    private int quantity;
    private int user_id;
    private int film_id;

    public int getUser_id() {
        return user_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public BuyMod(String user_name, String film_name, Date start, Date fin, int quantity, int user_id, int film_id) {
        this.user_name = user_name;
        this.film_name = film_name;
        this.start = start;
        this.fin = fin;
        this.quantity = quantity;
        this.user_id = user_id;
        this.film_id = film_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getFilm_name() {
        return film_name;
    }

    public Date getStart() {
        return start;
    }

    public Date getFin() {
        return fin;
    }

    public int getQuantity() {
        return quantity;
    }
}
