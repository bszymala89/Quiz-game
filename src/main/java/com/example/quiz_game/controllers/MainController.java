package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label welcomeText;

    private Stage mainStage;

    @FXML
    protected void onExitBtnClick() {
        Platform.exit();
    }


    @FXML
    protected void onSettingsBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 335);
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");
        settingsStage.setScene(scene);
        settingsStage.show();

        SettingsController settingsController = fxmlLoader.getController();
        settingsController.setStage(mainStage);


    }

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }
}