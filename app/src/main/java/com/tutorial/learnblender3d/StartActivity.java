package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.tutorial.learnblender3d.Adapters.CustomPagerAdapter;
import com.tutorial.learnblender3d.Models.CustomModel;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private CustomPagerAdapter onBoardingAdapter;
    LinearLayout layoutOnboardingIndicators;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setupOnBoardingItems();

        final ViewPager2 viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(onBoardingAdapter);
        layoutOnboardingIndicators = findViewById(R.id.layoutIndicator);
        materialButton = findViewById(R.id.materialButton);

        setupOnboardingIndicators();

        setCurrentOnboardingIndicator(0);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager2.getCurrentItem() + 1 < onBoardingAdapter.getItemCount()) {
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplication(), MainActivity.class));
                    finish();
                }
            }
        });

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

    private void setupOnboardingIndicators() {
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(5, 0, 5, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.on_boarding_inactive
            ));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index) {
        int childCount = layoutOnboardingIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicators.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.on_boarding_indicator_active
                        ));
            } else {
              imageView.setImageDrawable(
                      ContextCompat.getDrawable(getApplicationContext(), R.drawable.on_boarding_inactive)
              );
            }
        }

        if (index == onBoardingAdapter.getItemCount() - 1) {
            materialButton.setText(getApplicationContext().getText(R.string.start));
        } else {
            materialButton.setText(getApplicationContext().getText(R.string.next));
        }
    }
}
