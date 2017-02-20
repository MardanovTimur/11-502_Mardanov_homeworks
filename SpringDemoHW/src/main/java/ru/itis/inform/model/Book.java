package ru.itis.inform.model;

/**
 * Created by Тимур on 18.02.2017.
 */
public class Book {
    private long id;
    private String name;
    private User user;

    public Book(long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Book() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }
}
