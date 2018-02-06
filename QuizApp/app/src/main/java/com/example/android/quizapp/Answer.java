package com.example.android.quizapp;

public class Answer {
    private String name;
    private boolean correct;
    private boolean selected;

    public Answer(String name, boolean correct) {
        this.name = name;
        this.correct = correct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
