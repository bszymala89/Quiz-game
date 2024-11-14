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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuizSelectionController {
    @FXML
    private TableView<Quiz> quizTableView;
    @FXML
    private TableColumn<Quiz, String> quizNameColumn;
    @FXML
    private Button playBtn;
    private Stage stage;

    private List<Quiz> quizList = new ArrayList<>();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        quizNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        loadQuizzes();
        quizTableView.setItems(FXCollections.observableArrayList(quizList));

    }

    private void loadQuizzes() {
        String quizDirectoryPath = "src/main/resources/com/example/quiz_game/quizes";
        File quizDirectory = new File(quizDirectoryPath);

        if (quizDirectory.exists() && quizDirectory.isDirectory()) {
            File[] files = quizDirectory.listFiles((dir, name) -> name.endsWith(".json"));

            if (files != null) {
                for (File file : files) {
                    String quizName = file.getName().replace(".json", "");
                    try {
                        List<Question> questions = JsonUtils.readQuestionsFromJson(file.getPath());
                        Quiz quiz = new Quiz(questions, quizName);
                        quizList.add(quiz);
                    } catch (IOException e) {
                        System.err.println("Error reading quiz file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @FXML
    protected void onPlayBtnClick() throws IOException {
        Quiz selectedQuiz = quizTableView.getSelectionModel().getSelectedItem();
        if (selectedQuiz != null) {
            startQuiz(selectedQuiz);
        }
    }

    public void startQuiz(Quiz quiz) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 670);
        GameController gameController = fxmlLoader.getController();
        gameController.setQuiz(quiz);
        Stage quizStage = new Stage();
        gameController.setStage(quizStage);
        quizStage.setTitle("Game");
        quizStage.setScene(scene);
        quizStage.show();
        stage.close();
    }
}
