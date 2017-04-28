package Register;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public void submit(ActionEvent actionEvent) {

        name.getText();
    }
}
