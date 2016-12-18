package ru.itis.inform.models;

import java.util.List;

/**
 * Created by Тимур on 03.10.2016.
 */
// Модель юзера
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private boolean is_admin;
    //2Mb
    private byte[] imgBuf = new byte[2048];

    public User(String id, String name, String login, String password, boolean is_admin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.is_admin = is_admin;
        this.id = Integer.parseInt(id);
    }

    public User(String name, String login, String password, boolean is_admin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.is_admin = is_admin;
        this.id = (name+login+password).hashCode();
    }

    public byte[] getImgBuf() {
        return imgBuf;
    }

    public void setImgBuf(byte[] imgBuf) {
        this.imgBuf = imgBuf;
    }

    public boolean is_admin() {

        return is_admin;
    }

    public User(String name, String login, String password, boolean is_admin, byte[] imgBuf) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.is_admin = is_admin;
        this.id = (name+login+password).hashCode();
        this.imgBuf = imgBuf;

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
    @Override
    public String toString() {
        return getName();
    }
}
