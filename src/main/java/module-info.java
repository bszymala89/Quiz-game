module com.example.quiz_game {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.quiz_game to com.google.gson;
    exports com.example.quiz_game;
    exports com.example.quiz_game.controllers;
    opens com.example.quiz_game.controllers to javafx.fxml;
}