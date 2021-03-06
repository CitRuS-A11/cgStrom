package com.tutorial.learnblender3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmoothBottomBar bottomNavigationBar = findViewById(R.id.bottomNavigationBar);
        bottomNavigationBar.setActiveItem(0);
        bottomNavigationBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, LearnActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, ChallengeActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, CommunityActivity.class));
                        break;
                }
            }
        });



    }
}
