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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CreatorController implements Initializable {
    @FXML
    private TableView<String> quizTableView;
    @FXML
    private TableColumn<String, String> nameColumn;

    private ObservableList<String> observableList;

    @FXML
    protected void onCreateQuizBtnClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("create-quiz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 670);
        Stage createQuizStage = new Stage();
        createQuizStage.setTitle("Create Quiz");
        createQuizStage.setScene(scene);
        createQuizStage.show();
        //CreateQuizController.loadTableColumns();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quizTableView.setItems(loadQuizes(readQuizes("src/main/resources/com/example/quiz_game/quizes")));
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
    }

    public String[] readQuizes(String path) {
        File f = new File(path);
        String[] quizesFullNames = f.list();
        int length = quizesFullNames.length;
        String[] quizesNames = new String[length];
        for (int i = 0; i < quizesFullNames.length; i++) {
            quizesNames[i] = quizesFullNames[i].substring(0, quizesFullNames[i].length() - 5);
        }
        return quizesNames;
    }

    public ObservableList<String> loadQuizes(String[] quizesNames) {
        return FXCollections.observableArrayList(quizesNames);
    }
}
