package com.example.quiz_game.utils;

import com.example.quiz_game.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static List<Question> readFromJson(String path) throws IOException {
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
    public static void saveToJson(String path, Question question) throws IOException {
        List<Question> questionList = readFromJson(path);
        try(Writer writer = Files.newBufferedWriter(Paths.get(path));) {
            questionList.add(question);
            gson.toJson(questionList, writer);
            writer.flush();
            writer.close();
        }
    }
}
