package ru.itis.inform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Table(name = "bron")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seance")
    private Seance seance;

    @Column(name = "about")
    private String about;

    @Column(name="row")
    private int row;

    @Column(name = "col")
    private int col;

    @Column(name = "key")
    private int key;


    public Booking(User user, Seance seance, String about, int row, int col, int key) {
        this.user = user;
        this.seance = seance;
        this.about = about;
        this.row = row;
        this.col = col;
        this.key = key;
    }



    public Booking() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
