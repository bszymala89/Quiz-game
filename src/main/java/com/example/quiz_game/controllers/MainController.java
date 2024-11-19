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

    private Stage mainStage;

    @FXML
    protected void onExitBtnClick() {
        Platform.exit();
    }


    @FXML
    protected void onSettingsBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("settings-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 355);
        Stage settingsStage = new Stage();
        settingsStage.setTitle("Settings");
        settingsStage.setScene(scene);
        settingsStage.show();

        SettingsController settingsController = fxmlLoader.getController();
        settingsController.setStage(mainStage);
    }

    @FXML
    protected void onCreatorBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("creator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 670);
        Stage creatorStage = new Stage();
        creatorStage.setTitle("Creator");
        creatorStage.setScene(scene);
        creatorStage.show();
    }

    @FXML
    protected void onStartGameBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("quiz-selection-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 350);
        Stage quizSelectionStage = new Stage();
        quizSelectionStage.setTitle("Quiz selection");
        quizSelectionStage.setScene(scene);
        QuizSelectionController quizSelectionController = fxmlLoader.getController();
        quizSelectionController.setStage(quizSelectionStage);
        quizSelectionStage.show();
    }



    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }
}