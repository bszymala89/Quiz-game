package com.example.quiz_game.utils;

import com.example.quiz_game.Question;
import com.example.quiz_game.Quiz;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static List<Question> readQuestionsFromJson(String path) throws IOException {
        try(FileReader reader = new FileReader(path)) {
            Type questionListType = new TypeToken<List<Question>>() {}.getType();
            List<Question> questionList = gson.fromJson(reader, questionListType);
            reader.close();
            if (questionList == null) {
                return new ArrayList<>();
            }
            return questionList;
        }
    }

    public static Quiz readQuizFromJson(String path) throws IOException {
        try(FileReader reader = new FileReader(path)) {
            Type quizType = new TypeToken<Quiz>() {}.getType();
            Quiz quiz = gson.fromJson(reader, quizType);
            reader.close();
            return quiz;
        }
    }

    public static void saveQuestionToJson(String path, Question question) throws IOException {
        List<Question> questionList = readQuestionsFromJson(path);
        try(Writer writer = Files.newBufferedWriter(Paths.get(path));) {
            questionList.add(question);
            gson.toJson(questionList, writer);
            writer.flush();
        }
    }

    public static void saveQuizToJson(String path, Quiz quiz) throws IOException {
        try(Writer writer = Files.newBufferedWriter(Paths.get(path));) {
            gson.toJson(quiz.getQuestionsList(), writer);
            writer.flush();
        }
    }
}
