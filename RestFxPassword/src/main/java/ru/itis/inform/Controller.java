package ru.itis.inform;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import ru.itis.inform.reg.RegisterFrame;


public class Controller {

    private RegisterFrame registerFrame;
    private Main main;


    public void signUpFrame(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        registerFrame = new RegisterFrame();
        registerFrame.start(stage);
        ((javafx.scene.control.Button) (actionEvent.getSource())).getScene().getWindow().hide();
    }

    public void logIn(ActionEvent actionEvent) {

    }
}
