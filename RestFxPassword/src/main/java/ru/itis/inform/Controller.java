package ru.itis.inform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.inform.instances.UserInstance;
import ru.itis.inform.model.ServerModel.User;
import ru.itis.inform.place.PlaceFrame;
import ru.itis.inform.reg.RegisterFrame;

import java.io.File;
import java.io.PrintWriter;


public class Controller {

    private RegisterFrame registerFrame;
    private Main main;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private TextArea message;


    public void signUpFrame(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        registerFrame = new RegisterFrame();
        registerFrame.start(stage);
        //((javafx.scene.control.Button) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void logIn(ActionEvent actionEvent) throws Exception {
        message.setVisible(false);
        message.setText("");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("login", login.getText());
        httpHeaders.set("password", password.getText());
        HttpEntity<String> httpEntity = new HttpEntity<String>("", httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://" + "127.0.0.1" + ":8080/users/login";
        ResponseEntity<String> string = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        if (string.getBody().equals("{\"login\":\"success\"}")) {
            File file = new File("token.txt");
            if (!file.exists())
                file.createNewFile();
            //Printing AUTH TOKEN
            PrintWriter pw = new PrintWriter(file);
            String token = String.valueOf(string.getHeaders().get("Auth-Token")).substring(1,String.valueOf(string.getHeaders().get("Auth-Token")).length()-1);
            pw.print(token);
            pw.close();


            // Getting user model and make it instance
            HttpHeaders header = new HttpHeaders();
            header.add("Auth-Token", token);
            HttpEntity<String> entity =  new HttpEntity<String>("", header);
            RestTemplate rest = new RestTemplate();
            String url = "http://127.0.0.1:8080/users/"+login.getText()+"?parameter=username";
            ResponseEntity<User> user = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);

            UserInstance userInstance = new UserInstance(user.getBody());
            userInstance.getUser().setToken(token);
            //Close login
            Stage stage = (Stage)message.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();

            //Start seances list
            PlaceFrame placeFrame = new PlaceFrame();
            placeFrame.start(stage1);
        }
        message.setVisible(true);
        message.setStyle("-fx-border-color: red");
        message.setText(string.getBody());
    }

    public void setLoginPassword(String username, String password) {
        login.setText(username);
        this.password.setText(password);
    }

}
