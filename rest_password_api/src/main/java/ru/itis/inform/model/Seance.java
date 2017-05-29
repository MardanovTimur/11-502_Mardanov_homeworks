package ru.itis.inform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */

@Entity
@Table(name = "seance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return this.film.getName();
    }
}
