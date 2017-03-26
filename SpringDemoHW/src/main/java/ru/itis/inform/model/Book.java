package ru.itis.inform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Тимур on 18.02.2017.
 */

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnore
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
