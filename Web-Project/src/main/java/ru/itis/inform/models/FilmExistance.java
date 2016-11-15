package ru.itis.inform.models;

/**
 * Created by Тимур on 12.11.2016.
 */
public class FilmExistance {
    private int id;
    private int quantity;
    private double money;


    public FilmExistance(int id, int quantity, double money) {
        this.id = id;
        this.quantity = quantity;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getMoney() {
        return money;
    }
}
