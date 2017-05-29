package ru.itis.inform.model;


import ru.itis.inform.model.ServerModel.Booking;
import java.util.List;

/**
 * Created by alisa on 23.04.2017.
 */
public class User {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private List<Data> data;
    private List<Booking>  bookingList;

    public User(Integer id, String name, String username, String password, List<Data> data, List<Booking> bookingList) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.data = data;
        this.bookingList = bookingList;
    }

    public User() {
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
