package ru.itis.inform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static final Main main = new Main();

    private Stage primaryStage;
    private Pane rootLayout;
    private static Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Login");
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            rootLayout = (Pane) loader.load();
            controller = (Controller)loader.getController();
            setController((Controller) loader.getController());
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Main getMain() {
        return main;
    }

    public Controller getController() {
        return controller;
    }

    public static void setController(Controller controller) {
        Main.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
