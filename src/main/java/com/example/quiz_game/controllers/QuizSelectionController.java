package com.example.quiz_game.controllers;

import com.example.quiz_game.MainApplication;
import com.example.quiz_game.Quiz;
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

public class QuizSelectionController implements Initializable {
    private Stage stage;
    @FXML
    private TableView<String> quizTableView;
    @FXML
    private TableColumn<String, String> nameColumn;
    @FXML
    private Button playBtn;

    private List<String> quizNamesList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        loadQuizes("src/main/resources/com/example/quiz_game/quizes");
        quizTableView.setItems(FXCollections.observableArrayList(quizNamesList));

    }

    public void loadQuizes(String path) {
        File f = new File(path);
        String[] quizesFullNames = f.list();
        for (int i = 0; i < quizesFullNames.length; i++) {
            quizNamesList.add(quizesFullNames[i].substring(0, quizesFullNames[i].length() - 5));
        }
    }

    @FXML
    protected void onPlayBtnClick() throws IOException {
        String quizName = quizTableView.getSelectionModel().getSelectedItem();
        if (quizName != null) {
            startQuiz(quizName);
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
