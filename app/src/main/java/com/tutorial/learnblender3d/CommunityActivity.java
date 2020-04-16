package com.tutorial.learnblender3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        SmoothBottomBar bottomNavigationBar = findViewById(R.id.bottomNavigationBar);

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            boolean isComingSoon = bundle.getBoolean(ChallengeActivity.COMING_SOON_KEY);

            if (isComingSoon)
                bottomNavigationBar.setActiveItem(2);
            else
                bottomNavigationBar.setActiveItem(1);
        } else
            bottomNavigationBar.setActiveItem(3);


        bottomNavigationBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(CommunityActivity.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(CommunityActivity.this, LearnActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(CommunityActivity.this, ChallengeActivity.class));
                        break;
                    case 3:
                        break;
                }
            }
        });


    }
}
