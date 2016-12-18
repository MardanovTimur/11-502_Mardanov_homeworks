package ru.itis.inform.models;

/**
 * Created by Тимур on 03.10.2016.
 */
//Модель роль
public class Role {
    private int id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
