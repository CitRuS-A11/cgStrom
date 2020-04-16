package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FinishedLessonActivity extends AppCompatActivity {

    TextView topTextView;
    TextView secondTextView;
    TextView continueTextView;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_lesson);

        topTextView = findViewById(R.id.topTextView);
        secondTextView = findViewById(R.id.secondTextView);
        continueTextView = findViewById(R.id.continueTextView);
        relativeLayout = findViewById(R.id.relativeLayout);

        Bundle bundle = getIntent().getExtras();

        secondTextView.setText(bundle.getString("Key1"));
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        getApplicationContext(), LearnActivity.class
                ));
                finish();
            }
        });
    }
}
