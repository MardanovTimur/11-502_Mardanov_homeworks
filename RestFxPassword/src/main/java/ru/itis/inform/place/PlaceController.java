package ru.itis.inform.place;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.inform.instances.UserInstance;
import ru.itis.inform.model.RowColumn;
import ru.itis.inform.model.ServerModel.Booking;
import ru.itis.inform.model.ServerModel.Seance;
import ru.itis.inform.model.ServerModel.User;
import ru.itis.inform.myplaces.MyPlacesFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * Created by alisa on 01.05.2017.
 */
public class PlaceController implements Initializable {

    Button[][] places = new Button[10][20];
    @FXML
    public ListView<Seance> seances;
    @FXML
    public Text film_name;

    private List<RowColumn> userPlace = new LinkedList<RowColumn>();

    private String authToken;

    private List<Booking> bookingPlaces;

    private Seance seance;

    @FXML
    private Button buy;

    @FXML
    private TextField price;

    @FXML
    private TextArea priceSeance;

    private ObservableList<Seance> seanceSet;

    public void initialize(URL location, ResourceBundle resources) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            Scanner sc = new Scanner(new File("token.txt"));
            authToken = sc.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!authToken.equals("")) {
            httpHeaders.add("Auth-Token", authToken);
            HttpEntity<String> httpEntity = new HttpEntity<String>("", httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://" + "127.0.0.1" + ":8080/seances";
            ResponseEntity<List<Seance>> listFilms = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Seance>>() {
            });
            seanceSet = FXCollections.observableList(listFilms.getBody());

            seances.setItems(seanceSet);
        } else {
            Stage stage = (Stage) seances.getScene().getWindow();
            stage.close();
        }
    }

    public void getFilm(MouseEvent mouseEvent) {
        seance = seances.getSelectionModel().getSelectedItem();
        if (seance != null) {
            price.setText("Price :0");
            priceSeance.setText("Price :".concat(String.valueOf(seance.getPrice())));
            film_name.setText(seance.getFilm().getName());
            User user = UserInstance.userInstance.getUser();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Auth-Token", user.getToken());
            HttpEntity<String> httpEntity = new HttpEntity<String>("", httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://" + "127.0.0.1" + ":8080/booking/" + seance.getId()+"?for=our";
            ResponseEntity<List<Booking>> bookingList = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Booking>>() {
            });
            int lx = 220;
            int ly = 100;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    places[i][j] = new Button("x");
                    for (Booking b : bookingList.getBody()) {
                        if (b.getRow() == i && b.getCol() == j) {
                            places[b.getRow()][b.getCol()].setStyle("-fx-background-color: red");
                            places[b.getRow()][b.getCol()].setDisable(true);
                        }
                    }

                    places[i][j].setId(String.valueOf(i * 20 + j));
                    if (!places[i][j].getStyle().contains("-fx-background-color: red"))
                        places[i][j].setStyle("-fx-background-color: lightyellow");
                    places[i][j].setLayoutX(lx + j * 23);
                    places[i][j].setLayoutY(ly + i * 23);
                    places[i][j].setMaxSize(5, 4);
                    final int finalI = i;
                    final int finalJ = j;
                    places[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent arg0) {
                            if (places[finalI][finalJ].getStyle().contains("-fx-background-color: red")) {
                                places[finalI][finalJ].setDisable(true);
                            } else {
                                if (places[finalI][finalJ].getStyle().contains("-fx-background-color: lawngreen")) {
                                    places[finalI][finalJ].setStyle("-fx-background-color: lightyellow");
                                    places[finalI][finalJ].setText("x");
                                    RowColumn deleted = null;
                                    for (RowColumn r : userPlace) {
                                        if (r.getRow() == finalI && r.getColumn() == finalJ) {
                                            deleted = r;
                                        }
                                    }
                                    userPlace.remove(deleted);
                                    price.setText("Price :".concat(String.valueOf(Integer.valueOf(price.getText().split(" :")[1])-Integer.valueOf(priceSeance.getText().split(" :")[1]))));
                                } else {
                                    places[finalI][finalJ].setStyle("-fx-background-color: lawngreen");
                                    places[finalI][finalJ].setText("v");
                                    userPlace.add(new RowColumn(finalI, finalJ));
                                    price.setText("Price :".concat(String.valueOf(Integer.valueOf(price.getText().split(" :")[1])+Integer.valueOf(priceSeance.getText().split(" :")[1]))));
                                }
                            }
                            System.out.println(finalI + " " + finalJ);
                        }
                    });

                    PlaceFrame.getPlaceFrame().getRootLayout().getChildren().add(places[i][j]);
                }
            }
        } else {
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);

            VBox vbox = new VBox(new Text("Please choose existing seance!"));
            vbox.setAlignment(Pos.CENTER);
            vbox.setPadding(new Insets(15));

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        }

    }

    public void buyit(MouseEvent mouseEvent) {
        bookingPlaces = new ArrayList<Booking>();
        int price = Integer.valueOf(this.price.getText().split(" :")[1]);
        seance = seances.getSelectionModel().getSelectedItem();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (places[i][j].getStyle().contains("-fx-background-color: lawngreen")) {
                    places[i][j].setDisable(true);
                    places[i][j].setStyle("-fx-background-color: red");
                    bookingPlaces.add(new Booking(UserInstance.userInstance.getUser(), seance, "", i,j,0));
                }
            }
        }
        if (bookingPlaces.size()>0) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Auth-Token", UserInstance.userInstance.getUser().getToken());
            HttpEntity<List<Booking>> httpEntity = new HttpEntity<List<Booking>>(bookingPlaces, httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://" + "127.0.0.1" + ":8080/booking/" + seance.getId();
            ResponseEntity<String> key = restTemplate.exchange(uri,HttpMethod.POST, httpEntity, String.class);
            System.out.println(key.getBody());
        }
    }

    public void open_tickets(ActionEvent actionEvent) throws Exception {
        MyPlacesFrame myPlacesFrame = new MyPlacesFrame();
        myPlacesFrame.start(new Stage());

    }
}
