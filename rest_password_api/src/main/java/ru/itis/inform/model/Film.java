package ru.itis.inform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Entity
@Table(name = "films")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    /*@JsonIgnore
    @com.fasterxml.jackson.annotation.JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "film", cascade = CascadeType.ALL)
    private List<Seance> seanceList;*/

   /* public Film(String name, List<Seance> seanceList) {
        this.name = name;
        this.seanceList = seanceList;
    }*/

    public Film(String name) {
        this.name = name;
    }

    public Film() {
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
/*
    public List<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(List<Seance> seanceList) {
        this.seanceList = seanceList;
    }*/
}
