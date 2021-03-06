package com.tutorial.learnblender3d.Models;

import android.graphics.drawable.Drawable;

import com.tutorial.learnblender3d.R;

import java.io.Serializable;

public class CustomModel implements Serializable {

    String title;
    String description;
    int imageResource = R.drawable.blender_logo;
    private int backgroundColor;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public CustomModel(String title, String description, int imageResource, int backgroundColor) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
