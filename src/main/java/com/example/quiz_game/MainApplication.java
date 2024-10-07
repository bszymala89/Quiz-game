package com.example.quiz_game;

import com.example.quiz_game.controllers.MainController;
import com.example.quiz_game.controllers.SettingsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    int res1 = 640;
    int res2 = 480;

    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), res1, res2);
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();

        MainController mainController = fxmlLoader.getController();
        mainController.setMainStage(mainStage);

    }

    public static void main(String[] args) {
        launch();
    }
}