package ru.itis.inform.films;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ru.itis.inform.model.ServerModel.Film;

import java.util.Set;

/**
 * Created by Timur Mardanov on 17.05.2017.
 * ITIS
 */
public class FilmsController {

    @FXML
    private ListView listFilms;

    private ObservableList<Film> oList = FXCollections.observableArrayList();

    private Set<Film> stringSet;

    public void setListView()
    {
        stringSet.add(new Film());
        stringSet.add(new Film());
        stringSet.add(new Film());
        stringSet.add(new Film());
    }
}
