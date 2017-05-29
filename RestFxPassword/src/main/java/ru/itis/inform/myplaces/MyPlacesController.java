package ru.itis.inform.myplaces;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.inform.instances.UserInstance;
import ru.itis.inform.model.ServerModel.Booking;
import ru.itis.inform.model.ServerModel.Seance;
import ru.itis.inform.model.ServerModel.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Timur Mardanov on 27.05.2017.
 * ITIS
 */
public class MyPlacesController implements Initializable {

    @FXML
    public ListView<Seance> seances;
    private ObservableList<Seance> seanceSet;
    @FXML
    private ListView<Booking> bookings;
    private ObservableList<Booking> bookingSet;

    private List<Booking> selftickets;

    public void initialize(URL location, ResourceBundle resources) {
        HttpHeaders httpHeaders = new HttpHeaders();
        User user = UserInstance.userInstance.getUser();
        httpHeaders.add("Auth-Token", user.getToken());
        HttpEntity<String> httpEntity = new HttpEntity<String>(user.getToken(), httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://" + "127.0.0.1" + ":8080/seances/my";
        ResponseEntity<List<Booking>> listFilms = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<Booking>>() {
        });
        selftickets = listFilms.getBody();
        Iterator<Booking> bookingIterator = listFilms.getBody().iterator();
        List<Seance> seances = new ArrayList<Seance>();
        while (bookingIterator.hasNext()) {
            Booking booking = bookingIterator.next();
            boolean f = false;
            for (int i = 0; i < seances.size(); i++) {
                if (seances.get(i).getId().equals(booking.getSeance().getId())) {
                    f = true;
                }
            }
            if (!f) {
                seances.add(booking.getSeance());
            }
        }
        seanceSet = FXCollections.observableList(seances);

        this.seances.setItems(seanceSet);
    }

    public void showSeance(MouseEvent mouseEvent) {
        List<Booking> bookings = new ArrayList<Booking>();
        Iterator<Booking> iterator = selftickets.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (booking.getSeance().getId().equals(seances.getSelectionModel().getSelectedItem().getId())) {
                bookings.add(booking);
            }
        }
        bookingSet = FXCollections.observableList(bookings);
        this.bookings.setItems(bookingSet);
    }
}
