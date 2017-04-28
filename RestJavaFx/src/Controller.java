import Register.RegisterFrame;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

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
