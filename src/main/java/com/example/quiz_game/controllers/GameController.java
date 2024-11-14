package com.example.quiz_game.controllers;

import com.example.quiz_game.Question;
import com.example.quiz_game.Quiz;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameController {
    @FXML
    private Label questionLabel;
    @FXML
    private Label correctQuestionCountLabel;
    @FXML
    private Button backToMainMenuBtn;
    @FXML
    private VBox answerButtonContainer;

    private Stage stage;

    private Quiz quiz;

    private int questionCount = 0;

    private int correctQuestionCount = 0;


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
        showQuestion();
    }

    public void showQuestion() {
        if (questionCount >= quiz.getQuestionsList().size()) {
            questionLabel.setText("Quiz Ended");
            correctQuestionCountLabel.setText("Correct Questions: " + correctQuestionCount + "/" + quiz.getQuestionsList().size());
            backToMainMenuBtn.setVisible(true);
            answerButtonContainer.getChildren().clear();
            return;
        }
        Question question = quiz.getQuestionsList().get(questionCount);

        questionLabel.setText(question.getQuestion());
        backToMainMenuBtn.setVisible(false);
        answerButtonContainer.getChildren().clear();

        HBox row1 = new HBox(20);
        HBox row2 = new HBox(20);

        addAnswerButton(row1, question.getOptionA(), question.getAnswer());
        addAnswerButton(row1, question.getOptionB(), question.getAnswer());
        addAnswerButton(row2, question.getOptionC(), question.getAnswer());
        addAnswerButton(row2, question.getOptionD(), question.getAnswer());

        answerButtonContainer.getChildren().addAll(row1, row2);
    }

    private void addAnswerButton(HBox row, String option, String correctAnswer) {
        Button button = new Button(option);
        button.setPrefSize(200, 100);
        button.setOnAction(event -> handleAnswerClick(button, option, correctAnswer));
        row.getChildren().add(button);
    }

    private void handleAnswerClick(Button button, String option, String correctAnswer) {
        if (option.equals(correctAnswer)) {
            button.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            correctQuestionCount += 1;
        }
        else {
            button.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            showCorrectAnswer(correctAnswer);
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            questionCount += 1;
            showQuestion();
        });
        pause.play();
    }

    private void showCorrectAnswer(String correctAnswer) {
        for (var node:answerButtonContainer.getChildren()) {
            if (node instanceof HBox) {
                for (var buttonNode:((HBox) node).getChildren()) {
                    Button answerButton = (Button) buttonNode;
                    if (answerButton.getText().equals(correctAnswer)) {
                        answerButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                    }
                }
            }
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onBackToMainMenuBtnClick() {
        stage.close();
    }
}
