package com.example.quiz_game.controllers;

import com.example.quiz_game.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditQuestionController {
    @FXML
    private TextField questionField;
    @FXML
    private TextField optionAField;
    @FXML
    private TextField optionBField;
    @FXML
    private TextField optionCField;
    @FXML
    private TextField optionDField;
    @FXML
    private TextField answerField;
    private CreateQuizController createQuizController;
    private Question question;

    public void setQuestion(Question question) {
        if (question == null) {
            System.out.println("null");
        }
        else {
            System.out.println("not null");
        }
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    /*questionField.setText(question.getQuestion());
        optionAField.setText(question.getOptionA());
        optionBField.setText(question.getOptionB());
        optionCField.setText(question.getOptionC());
        optionDField.setText(question.getOptionD());
        answerField.setText(question.getAnswer());*/

    public void onEditBtnClick() {

    }

    public void setCreateQuizController(CreateQuizController createQuizController) {
        this.createQuizController = createQuizController;
    }
}
