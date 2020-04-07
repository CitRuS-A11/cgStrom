package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.media.AudioFocusRequest;
import android.os.Bundle;

import com.tutorial.learnblender3d.Adapters.CustomPagerAdapter;
import com.tutorial.learnblender3d.Models.CustomModel;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private CustomPagerAdapter onBoardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setupOnBoardingItems();

        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(onBoardingAdapter);
    }

    private void setupOnBoardingItems (){

        List<CustomModel> onBoardingItems = new ArrayList<>();

        CustomModel itemPayOnline = new CustomModel(
                "Learn 3d modeling with Best practices",
                "This will be an amazing learning experience",
                R.drawable.ic_3d);
        CustomModel itemLearningPaths = new CustomModel(
                "Start Learning in Learning Paths",
                "Learning Paths are paths for different sets of cgi, You can learn 3d modeling, Sculpting, Texture Painting and more",
                R.drawable.ic_hologram);
        CustomModel itemChallenge= new CustomModel(
                "Daily Challenges and Tournaments",
                "Complete Daily challenges to solidify your knowledge and compete in tournaments",
                R.drawable.ic_swords);

        onBoardingItems.add(itemPayOnline );
        onBoardingItems.add(itemLearningPaths);
        onBoardingItems.add(itemChallenge);

        onBoardingAdapter = new CustomPagerAdapter(onBoardingItems);
    }
}
