package com.example.quiz_game;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questionsList;
    private String name;

    public Quiz(List<Question> questionsList, String name) {
        this.questionsList = questionsList;
        this.name = name;
    }


    public void addQuestion(Question question) {
        questionsList.add(question);
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }
}
