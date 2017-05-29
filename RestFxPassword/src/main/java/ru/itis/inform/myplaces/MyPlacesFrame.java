package ru.itis.inform.myplaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Timur Mardanov on 27.05.2017.
 * ITIS
 */
public class MyPlacesFrame extends Application {

    private MyPlacesFrame myPlacesFrame;
    private SplitPane rootLayout;
    private MyPlacesController placeController;
    private Stage primaryStage;

    public MyPlacesFrame() {
        this.myPlacesFrame = this;
    }

    public void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("myplaces.fxml"));
            rootLayout = (SplitPane) loader.load();
            placeController = (MyPlacesController) loader.getController();
            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyPlacesFrame getMyPlacesFrame() {
        return myPlacesFrame;
    }

    public void setMyPlacesFrame(MyPlacesFrame myPlacesFrame) {
        this.myPlacesFrame = myPlacesFrame;
    }

    public SplitPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(SplitPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    public MyPlacesController getPlaceController() {
        return placeController;
    }

    public void setPlaceController(MyPlacesController placeController) {
        this.placeController = placeController;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My tickets");
        initRootLayout();
    }
}
