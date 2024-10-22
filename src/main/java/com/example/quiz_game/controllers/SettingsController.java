package com.example.quiz_game.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsController {

    private Stage stage;

    @FXML
    private ComboBox<String> resolutionComboBox;

    @FXML
    public void initialize() {
        resolutionComboBox.getItems().addAll("640×480", "960×540", "1280×720", "1920×1080", "2048×1080", "2560×1440", "3840×2160" );
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
        String res = resolutionComboBox.getValue();
        String[] restab;

        restab = res.split("×");

        int res1 = Integer.parseInt(restab[0]);
        int res2 = Integer.parseInt(restab[1]);



        stage.setWidth(res1);
        stage.setHeight(res2);
    }

    @FXML
    protected void onResolutionComboBoxClick() {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
