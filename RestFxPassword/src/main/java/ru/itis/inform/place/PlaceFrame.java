package ru.itis.inform.place;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by alisa on 01.05.2017.
 */
public class PlaceFrame extends Application {
    public static Stage primaryStage;
    private Pane rootLayout;
    private PlaceController placeController;

    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource  ("register.fxml"));
            rootLayout = (Pane) loader.load();
            placeController = (PlaceController) loader.getController();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Registration");
        initRootLayout();

    }
}
