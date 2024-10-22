package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateQuizController {
    @FXML
    protected void onAddQuestionBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-question-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 335);
        Stage createQuestionStage = new Stage();
        createQuestionStage.setTitle("Create Question");
        createQuestionStage.setScene(scene);
        createQuestionStage.show();
    }
}
