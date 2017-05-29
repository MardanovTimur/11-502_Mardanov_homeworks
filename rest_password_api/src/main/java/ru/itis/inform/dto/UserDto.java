package ru.itis.inform.dto;

import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Data;

import java.util.List;

/**
 * Created by timur on 10.04.17.
 */
public class UserDto {
    private int id;
    private String name;
    private String username;
    private List<Data> dataList;
    private List<Booking> bookingList;

    public UserDto(int id, String name, String username, List<Data> dataList, List<Booking> bookingList) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.dataList = dataList;
        this.bookingList = bookingList;
    }

    public UserDto(int id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public UserDto() {
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
