package ru.itis.inform.reg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by alisa on 26.04.2017.
 */
public class RegisterFrame extends Application{

    public static Stage primaryStage;
    private Pane rootLayout;
    private RegisterController registerController;

    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource ("register.fxml"));
            rootLayout = (Pane) loader.load();
            registerController = (RegisterController) loader.getController();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RegisterController getRegisterController() {
        return registerController;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Registration");
        initRootLayout();

    }
}
