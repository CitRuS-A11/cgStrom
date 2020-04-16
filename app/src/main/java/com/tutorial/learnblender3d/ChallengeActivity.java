package com.tutorial.learnblender3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tutorial.learnblender3d.Adapters.CustomChallengeAdapter;
import com.tutorial.learnblender3d.Models.CustomChallengeModel;

import java.util.ArrayList;
import java.util.List;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;
import okhttp3.Challenge;

public class ChallengeActivity extends AppCompatActivity implements ChallengeClickListnerInterface {

    private static final String TAG = ChallengeActivity.class.getSimpleName();
    ArrayList<CustomChallengeModel> list;
    CustomChallengeAdapter challengeAdapter;
    ViewPager2 challengesViewPager;

    public static final String DESC_KEY = "stringArray";
    public static final String IMAGES_KEY = "intArray";
    public static final String COMING_SOON_KEY = "comingSoon";
    public static final String CHALLENGE_MODEL_KEY = "ChallengeModel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        SmoothBottomBar bottomNavigationBar = findViewById(R.id.bottomNavigationBar);

        challengesViewPager = findViewById(R.id.challengesViewPager);

        List<CustomChallengeModel> list = new ArrayList<>();

        CustomChallengeModel challenge1 = new CustomChallengeModel();
        challenge1.title = "Pen";
        challenge1.description = "Challenge One";
        challenge1.stepsCount = 6;
        challenge1.imageResource = R.drawable.challenge_one;
        list.add(challenge1);

        CustomChallengeModel comingSoon = new CustomChallengeModel();
        comingSoon.title = "???";
        comingSoon.description = "new Coming Soon";
        comingSoon.stepsCount = 0;
        comingSoon.imageResource = R.drawable.question_mark_3d;
        list.add(comingSoon);

        challengeAdapter = new CustomChallengeAdapter(list, getApplicationContext(), this);
        challengesViewPager.setAdapter(challengeAdapter);

        challengesViewPager.setClipToPadding(false);
        challengesViewPager.setClipChildren(false);
        challengesViewPager.setOffscreenPageLimit(3);
        challengesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        challengesViewPager.setPageTransformer(compositePageTransformer);

        bottomNavigationBar.setActiveItem(2);
        bottomNavigationBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(ChallengeActivity.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ChallengeActivity.this, LearnActivity.class));
                        break;
                    case 2:
                        break;
                    case 3:
                        startActivity(new Intent(ChallengeActivity.this, CommunityActivity.class));
                        break;
                }
            }
        });

    }
    public void onClickNonStatic() {
        switch (challengesViewPager.getCurrentItem()) {
            case 0:
                Intent intent = new Intent(getApplicationContext(), AcChallengeActivity.class);
                intent.putExtra(IMAGES_KEY, new int[]{
                        R.drawable.challlenge1x1, R.drawable.challlenge1x2, R.drawable.challlenge1x3,
                        R.drawable.challlenge1x4, R.drawable.challlenge1x5, R.drawable.challlenge1x6,
                        R.drawable.challenge1x7
                });

                intent.putExtra(DESC_KEY, getResources().getStringArray(R.array.challenge1Descriptions));
                startActivity(intent);
                break;
            case 1:
                Intent comingSoonIntent = new Intent(getApplicationContext(), CommunityActivity.class);
                comingSoonIntent.putExtra(COMING_SOON_KEY, true);
                startActivity(comingSoonIntent);
                break;
            default:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }
    }
    @Override
    public void onItemClick() {
        onClickNonStatic();
    }
}
