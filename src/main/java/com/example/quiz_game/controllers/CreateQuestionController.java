package com.example.quiz_game.controllers;

import com.example.quiz_game.Question;
import com.example.quiz_game.utils.JsonUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class CreateQuestionController {
    @FXML
    private TextField question;
    @FXML
    private TextField optionA;
    @FXML
    private TextField optionB;
    @FXML
    private TextField optionC;
    @FXML
    private TextField optionD;
    @FXML
    private TextField answer;

    @FXML
    protected void onCreateBtnClick() throws IOException {
        File file1 = new File("src/main/java/test.json");
        Question question1 = new Question(question.getText(), optionA.getText(), optionB.getText(), optionC.getText(), optionD.getText(), answer.getText());
        System.out.println(JsonUtils.readFromJson("src/main/java/test.json"));
        JsonUtils.saveToJson("src/main/java/test.json", question1);
    }
}
