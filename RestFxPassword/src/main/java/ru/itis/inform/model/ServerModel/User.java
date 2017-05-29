package ru.itis.inform.model.ServerModel;

import ru.itis.inform.model.Data;

import java.util.List;

/**
 * Created by timur on 30.03.17.
 */

public class User {

    private String name;

    private String username;

    private String password;

    private String token;

    private List<Data> dataList;

    private List<Booking> bookingList;


    public User(String name, String username, String password, String token, List<Data> dataList, List<Booking> bookingList) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.token = token;
        this.dataList = dataList;
        this.bookingList = bookingList;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    protected User() {
    }


    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
