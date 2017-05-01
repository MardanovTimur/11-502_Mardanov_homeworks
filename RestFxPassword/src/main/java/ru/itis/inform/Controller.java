package ru.itis.inform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.itis.inform.reg.RegisterFrame;


public class Controller {

    private RegisterFrame registerFrame;
    private Main main;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;


    public void signUpFrame(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        registerFrame = new RegisterFrame();
        registerFrame.start(stage);
        //((javafx.scene.control.Button) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void logIn(ActionEvent actionEvent) {

    }

    public void setLoginPassword(String username, String password) {
        login.setText(username);
        this.password.setText(password);
    }

}
