package ru.itis.inform.models;

/**
 * Created by Тимур on 03.10.2016.
 */
public class Studio {
    private int id;
    private String name;

    public Studio(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Studio(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
