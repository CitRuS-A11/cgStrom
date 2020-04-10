package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout learnLayout;
    RelativeLayout challengeLayout;
    RelativeLayout communityLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        learnLayout = findViewById(R.id.learnLayout);
        challengeLayout = findViewById(R.id.challengeLayout);
        communityLayout = findViewById(R.id.communityLayout);


        learnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LearnActivity.class));
            }
        });
    }
}
