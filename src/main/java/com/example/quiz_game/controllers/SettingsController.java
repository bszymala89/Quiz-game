package com.example.quiz_game.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SettingsController {

    private Stage stage;

    @FXML
    private ComboBox<String> resolutionComboBox;

    @FXML
    public void initialize() {
        resolutionComboBox.getItems().addAll("640x480", "960×540", "1280×720", "1920x1080", "2048×1080", "2560×1440", "3840×2160" );
    }

    @FXML
    protected void onExitBtnClick() {
        stage.close();
    }

    @FXML
    protected void onMaximizescreenCheckboxClick() {
        stage.setMaximized(true);
    }

    @FXML
    protected void onApplyBtnClick() {
        //to do add split to string and string to values for resolution
        resolutionComboBox.getValue();
    }

    /*@FXML
    protected void onResolutionComboBoxClick() {

    }*/

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
