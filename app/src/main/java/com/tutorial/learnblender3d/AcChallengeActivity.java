package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tutorial.learnblender3d.Adapters.ChallengeAdapter;

public class AcChallengeActivity extends AppCompatActivity {

    String stepsDescriptions[];
    int stepImages[];
    ChallengeAdapter challengeAdapter;
    RecyclerView challengeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_challenge);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        stepsDescriptions = bundle.getStringArray(ChallengeActivity.DESC_KEY);
        stepImages = bundle.getIntArray(ChallengeActivity.IMAGES_KEY);

        challengeAdapter = new ChallengeAdapter(this, stepsDescriptions, stepImages);
        challengeRecyclerView = findViewById(R.id.acChallengeRecyclerView);

        challengeRecyclerView.setAdapter(challengeAdapter);
        challengeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
