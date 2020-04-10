package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class LessonActivity extends AppCompatActivity {

    LinearLayout topbarLinearLayout;
    ImageView cancelImageView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        topbarLinearLayout = findViewById(R.id.topBarLinearLayout);
        cancelImageView = findViewById(R.id.cancelImageView);
        progressBar = findViewById(R.id.progressbarHorizontal);

        Float temp = 4f / 8f;
        int temp2 = (int) ((temp) * 100);

        progressBar.setProgress(temp2);
        progressBar.setScaleY(2.4f);

        cancelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LearnActivity.class));
            }
        });

    }
}
