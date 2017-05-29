package ru.itis.inform.model.ServerModel;

import java.util.List;

/**
 * Created by Timur Mardanov on 17.05.2017.
 * ITIS
 */
public class Film {
    private Integer id;

    private String name;

    private List<Seance> seanceList;

    public Film(String name, List<Seance> seanceList) {
        this.name = name;
        this.seanceList = seanceList;
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

    public List<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(List<Seance> seanceList) {
        this.seanceList = seanceList;
    }

    @Override
    public String toString(){
        return name;
    }

}
