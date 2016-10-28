package ru.itis.inform.models;

/**
 * Created by Тимур on 03.10.2016.
 */
public class Producer {
    private String name;
    private int id;

    public Producer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Producer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public int getId() {
        return id;
    }
}
