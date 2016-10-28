package ru.itis.inform.models;

/**
 * Created by Тимур on 26.10.2016.
 */
public class Genre {
    private String name;
    private int id;

    public Genre( int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
