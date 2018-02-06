package com.example.android.quizapp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String name;
    private int order;
    private List<Answer> answers;

    public Question(String name) {
        this.name = name;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public String getName() {
        return name;
    }


    /**
     *
     * @return @NotNull list otayek
     */
    public List<Answer> getAnswers() {
        return answers;
    }


    // constructors


    // methods



}
