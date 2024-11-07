package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import com.example.quiz_game.Question;
import com.example.quiz_game.Quiz;
import com.example.quiz_game.utils.JsonUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
    @FXML
    private TextField nameField;
    private ObservableList<Question> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionsTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
        CreateQuestionController createQuestionController = fxmlLoader.getController();
        createQuestionStage.setTitle("Create Question");
        createQuestionStage.setScene(scene);
        createQuestionController.setCreateQuizController(this);
        createQuestionStage.show();
        System.out.println(questionsTableView.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    protected void onEditQuestionBtnClick() throws IOException {
        System.out.println(questionsTableView.getSelectionModel().getSelectedItem().toString());
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("edit-question-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 335);
        Stage editQuestionStage = new Stage();
        EditQuestionController editQuestionController = fxmlLoader.getController();

        editQuestionStage.setTitle("Edit Question");
        editQuestionStage.setScene(scene);
        editQuestionController.setCreateQuizController(this);
        //editQuestionController.setQuestion(questionsTableView.getSelectionModel().getSelectedItem());
        editQuestionController.setQuestion(new Question("testt question", "a", "b", "c", "d", "answer"));
        System.out.println(editQuestionController.getQuestion().toString());
        editQuestionStage.show();
    }

    @FXML
    protected void onCreateBtnClick() {
        ObservableList<Question> selectedQuestionsList = questionsTableView.getSelectionModel().getSelectedItems();
        if (selectedQuestionsList.isEmpty()) {
            System.out.println("Quiz needs to have at least 1 question");
            return;
        }
        if (nameField.getText().isEmpty()) {
            System.out.println("Quiz needs to have a name");
            return;
        }
        String path = "src/main/resources/com/example/quiz_game/" + nameField.getText() + ".json";
        Quiz quiz = new Quiz(selectedQuestionsList, nameField.getText());
        try {
           JsonUtils.saveQuizToJson(path, quiz);
           System.out.println("Saved to json");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
