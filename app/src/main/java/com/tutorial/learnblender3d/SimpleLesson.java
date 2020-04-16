package com.tutorial.learnblender3d;

import com.tutorial.learnblender3d.Models.CustomLessonModel;

import java.io.Serializable;
import java.util.ArrayList;

public class SimpleLesson implements Serializable {
    private ArrayList<CustomLessonModel> list;
    private boolean isCorrectAnswer;

    public ArrayList<CustomLessonModel> getList() {
        return list;
    }

    public void setList(ArrayList<CustomLessonModel> list) {
        this.list = list;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }
}
