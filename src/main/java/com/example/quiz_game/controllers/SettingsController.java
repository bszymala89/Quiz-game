package com.example.quiz_game.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SettingsController {
    @FXML
    protected void onExitBtnClick() {
        Platform.exit();
    }
    @FXML
    protected void onCheckboxClick() {

    }
}
