package com.example.quiz_game.controllers;

import com.example.quiz_game.Question;
import com.example.quiz_game.utils.JsonUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    private CreateQuizController createQuizController;

    public void setCreateQuizController(CreateQuizController createQuizController) {
        this.createQuizController = createQuizController;
    }

    @FXML
    protected void onCreateBtnClick() throws IOException {
        //File file1 = new File("src/main/resources/com/example/quiz_game/test.json");
        Question question1 = new Question(question.getText(), optionA.getText(), optionB.getText(), optionC.getText(), optionD.getText(), answer.getText());
        JsonUtils.saveQuestionToJson("src/main/resources/com/example/quiz_game/test.json", question1);
        createQuizController.refreshQuestions();
    }
}
