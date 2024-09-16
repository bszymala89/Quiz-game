module com.example.quiz_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quiz_game to javafx.fxml;
    exports com.example.quiz_game;
    exports com.example.quiz_game.controllers;
    opens com.example.quiz_game.controllers to javafx.fxml;
}