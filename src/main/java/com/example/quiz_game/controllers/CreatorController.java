package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreatorController {
    @FXML
    protected void onCreateQuizBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-quiz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 670);
        Stage createQuizStage = new Stage();
        createQuizStage.setTitle("Create Quiz");
        createQuizStage.setScene(scene);
        createQuizStage.show();
        //CreateQuizController.loadTableColumns();
    }
}
