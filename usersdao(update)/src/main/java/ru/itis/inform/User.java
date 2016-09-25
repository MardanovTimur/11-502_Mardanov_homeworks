package ru.itis.inform;

/**
 * Created by Тимур on 05.09.2016.
 */
public class User {
    private String name;
    private String id;
    private String password;
    private String city;
    private int year;


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYear(int year) {
        this.year = year;
    }

public void setCity(String city) {
        this.city = city;
    }


    public User() {
    }

    public User(String name, String id, String password, int year, String city) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.year = year;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }
    public int getYear() {
        return year;
    }
}
