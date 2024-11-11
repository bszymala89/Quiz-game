package com.example.quiz_game.controllers;

import com.example.quiz_game.Quiz;
import com.example.quiz_game.utils.JsonUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;

public class GameController {
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

    String quizName;


    @FXML
    protected void onOptionABtnClick() {

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
}
