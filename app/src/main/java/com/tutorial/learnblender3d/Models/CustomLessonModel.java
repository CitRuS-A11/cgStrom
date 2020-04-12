package com.tutorial.learnblender3d.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomLessonModel implements Serializable {
    private boolean hasQuestion;
    private String lessonText ;
    private String[] questionTextArray;
    private int imageResource;
    private int correctQuestions;


    public CustomLessonModel(int imageResource, boolean hasQuestion, String lessonText) {
        this.hasQuestion = hasQuestion;
        this.lessonText = lessonText;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }


    public String getLessonText() {
        return lessonText;
    }

    public void setLessonText(String lessonText) {
        this.lessonText = lessonText;
    }

    public String[] getQuestionTextArray() {
        return questionTextArray;
    }

    public void setQuestionTextArray(String[] questionTextArray) {
        this.questionTextArray = questionTextArray;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public boolean isHasQuestion() {
        return hasQuestion;
    }

    public void setHasQuestion(boolean hasQuestion) {
        this.hasQuestion = hasQuestion;
    }
}
