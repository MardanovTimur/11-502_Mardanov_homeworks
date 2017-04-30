package ru.itis.inform.reg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.web.client.RestTemplate;
import ru.itis.inform.model.ServerModel.User;
import ru.itis.inform.model.ServerModel.UserForRegister;


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

    public void submit(ActionEvent actionEvent) throws JsonProcessingException {
        UserForRegister user = new UserForRegister(name.getText(), username.getText(), password.getText(), password_again.getText());
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(user);

        RestTemplate rt = new RestTemplate();
        String uri = "http://" + "127.0.0.1" + ":8080/users";
        User returns = rt.postForObject(uri, jsonUser, User.class);
        System.out.println(returns);
    }
}
