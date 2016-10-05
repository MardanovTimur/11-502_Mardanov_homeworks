package ru.itis.inform.models;

import java.util.List;

/**
 * Created by Тимур on 03.10.2016.
 */
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private boolean is_admin;

    public User(String name, String login, String password, boolean is_admin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.is_admin = is_admin;
        this.id = (name+login+password).hashCode();
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIs_admin() {
        return is_admin;
    }

    public String getLogin() {
        return login;
    }


    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
