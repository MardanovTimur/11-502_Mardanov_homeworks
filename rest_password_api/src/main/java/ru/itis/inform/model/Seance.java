package ru.itis.inform.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */

@Entity
@Table(name = "seance")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="film")
    private Film film;

    @Column(name="price")
    private int price;

    @Column(name="timebegin")
    private Timestamp timebegin;

    @Column(name="places")
    private boolean places[][];


    public Seance() {
    }

    public Seance(Film film, int price, Timestamp timebegin, boolean[][] places) {
        this.film = film;
        this.price = price;
        this.timebegin = timebegin;
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(Timestamp timebegin) {
        this.timebegin = timebegin;
    }

    public boolean[][] getPlaces() {
        return places;
    }

    public void setPlaces(boolean[][] places) {
        this.places = places;
    }
}
