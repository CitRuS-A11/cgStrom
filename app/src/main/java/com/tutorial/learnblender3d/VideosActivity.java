package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tutorial.learnblender3d.Adapters.VideoAdapter;
import com.tutorial.learnblender3d.Models.VideoModel;

import java.util.Vector;

public class VideosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<VideoModel> videos = new Vector<>();
    ImageView cancelImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        cancelImageView = findViewById(R.id.cancelImageView);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        videos.add(new VideoModel(
                "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/MF1qEhBSfq4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                getString(R.string.blenderoffical_description)
        ));

        videos.add(new VideoModel(
                "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/aX6HAn7zieg\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                getString(R.string.borncg_description)
        ));

        videos.add(new VideoModel(
                "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/TPrnSACiTJ4\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                getString(R.string.blender_guru_description)
        ));

        videos.add(new VideoModel(
                "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/KyjSnak3Yjo\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>",
                getString(R.string.cgfasttrack_description)
        ));

        VideoAdapter videoAdapter = new VideoAdapter(videos);
        recyclerView.setAdapter(videoAdapter);


        cancelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LearnActivity.class));
            }
        });

    }
}
