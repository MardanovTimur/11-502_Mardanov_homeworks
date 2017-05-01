package ru.itis.inform.reg;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;
import ru.itis.inform.Controller;
import ru.itis.inform.Main;
import ru.itis.inform.model.ServerModel.User;
import ru.itis.inform.model.ServerModel.UserForRegister;

import java.io.IOException;


/**
 * Created by alisa on 26.04.2017.
 */
public class RegisterController {

    @FXML
    private TextField name;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField password_again;
    @FXML
    private TextArea message;
    @FXML
    private Button submit;

    public void submit(ActionEvent actionEvent) throws IOException {
        message.setVisible(false);
        UserForRegister user = new UserForRegister(name.getText(), username.getText(), password.getText(), password_again.getText());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(user);

        RestTemplate rt = new RestTemplate();
        String uri = "http://" + "127.0.0.1" + ":8080/users";
        User returns = rt.postForObject(uri, jsonUser, User.class);
        if (returns.getUsername() != null) {
            //Insert data in login frame
            Main main = Main.getMain();
            Controller controller = main.getController();
            controller.setLoginPassword(username.getText(), password.getText());
            //Close register window
            Stage stage = (Stage) message.getScene().getWindow();
            stage.close();
        } else {
            message.setVisible(true);
        }
    }
}
