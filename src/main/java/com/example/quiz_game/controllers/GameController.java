package com.example.quiz_game.controllers;

import com.example.quiz_game.Quiz;
import com.example.quiz_game.utils.JsonUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private Label questionLabel;
    @FXML
    private Button optionABtn;
    @FXML
    private Button optionBBtn;
    @FXML
    private Button optionCBtn;
    @FXML
    private Button optionDBtn;

    private String quizName;

    private int questionCount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(quizName);
        System.out.println("a");
        try {
            Quiz quiz = getQuizFromName("src/main/resources/com/example/quiz_game/quizes/" , quizName);
            questionCount = quiz.getQuestionsList().size();

            questionLabel.setText(quiz.getQuestionsList().get(0).getQuestion());
            optionABtn.setText(quiz.getQuestionsList().get(0).getOptionA());
            optionBBtn.setText(quiz.getQuestionsList().get(0).getOptionB());
            optionCBtn.setText(quiz.getQuestionsList().get(0).getOptionC());
            optionDBtn.setText(quiz.getQuestionsList().get(0).getOptionD());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onOptionABtnClick()  {


    }

    @FXML
    protected void onOptionBBtnClick() {

    }

    @FXML
    protected void onOptionCBtnClick() {

    }

    @FXML
    protected void onOptionDBtnClick() {

    }

    public Quiz getQuizFromName(String path, String quizName) throws IOException {
        Quiz quiz = JsonUtils.readQuizFromJson(path + quizName + ".json");
        return quiz;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizName() {
        return quizName;
    }
}
