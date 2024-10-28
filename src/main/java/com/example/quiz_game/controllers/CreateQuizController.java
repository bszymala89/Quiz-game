package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import com.example.quiz_game.Question;
import com.example.quiz_game.utils.JsonUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CreateQuizController implements Initializable {
    @FXML
    private TableView<Question> questionsTableView;
    @FXML
    private TableColumn<Question, String> questionColumn;
    @FXML
    private TableColumn<Question, String> optionAColumn;
    @FXML
    private TableColumn<Question, String> optionBColumn;
    @FXML
    private TableColumn<Question, String> optionCColumn;
    @FXML
    private TableColumn<Question, String> optionDColumn;
    @FXML
    private TableColumn<Question, String> answerColumn;
    private ObservableList<Question> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshQuestions();
        questionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQuestion()));
        optionAColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOptionA()));
        optionBColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOptionB()));
        optionCColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOptionC()));
        optionDColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOptionD()));
        answerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAnswer()));
    }

    @FXML
    protected void onAddQuestionBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-question-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 335);
        Stage createQuestionStage = new Stage();
        createQuestionStage.setTitle("Create Question");
        createQuestionStage.setScene(scene);
        CreateQuestionController createQuestionController = fxmlLoader.getController();
        createQuestionController.setCreateQuizController(this);
        createQuestionStage.show();
    }

    public void refreshQuestions() {
        try {
            List<Question> questionList = JsonUtils.readFromJson("src/main/resources/com/example/quiz_game/test.json");
            observableList = FXCollections.observableArrayList(questionList);
            questionsTableView.setItems(observableList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
