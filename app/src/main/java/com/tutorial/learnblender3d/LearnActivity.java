package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LearnActivity extends AppCompatActivity {

    ImageView modelingImageView;
    ImageView videosImageView;
    ImageView nodesImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        modelingImageView = findViewById(R.id.modelingImageView);
        videosImageView = findViewById(R.id.videosImageView);
        nodesImageView = findViewById(R.id.nodesImageView);

        modelingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, LessonActivity.class);
                startActivity(intent);
            }
        });

        videosImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VideosActivity.class));
            }
        });
    }
}
