package ru.itis.inform.model.ServerModel;

import java.sql.Timestamp;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */

public class Seance {

    private Integer id;

    private Film film;

    private int price;

    private Timestamp timebegin;

    private boolean places[][];


    public Seance() {
    }


    public Seance(Film film, int price, Timestamp timebegin, boolean[][] places) {
        this.film = film;
        this.price = price;
        this.timebegin = timebegin;
        this.places = places;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(Timestamp timebegin) {
        this.timebegin = timebegin;
    }

    public boolean[][] getPlaces() {
        return places;
    }

    public void setPlaces(boolean[][] places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return getFilm().getName() + ". Time: " + this.timebegin.toString();
    }
}

