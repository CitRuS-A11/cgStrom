package com.tutorial.learnblender3d.Models;

public class VideoModel {

    private String videoUrl;
    private String description;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VideoModel(String videoUrl, String description) {
        this.videoUrl = videoUrl;
        this.description = description;
    }
}
