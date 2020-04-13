package com.tutorial.learnblender3d;

import com.tutorial.learnblender3d.Models.CustomLessonModel;

import java.io.Serializable;
import java.util.ArrayList;

public class SimpleLesson implements Serializable {
    private ArrayList<CustomLessonModel> list;

    public ArrayList<CustomLessonModel> getList() {
        return list;
    }

    public void setList(ArrayList<CustomLessonModel> list) {
        this.list = list;
    }
}
