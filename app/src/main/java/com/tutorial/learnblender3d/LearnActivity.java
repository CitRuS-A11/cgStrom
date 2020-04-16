package com.tutorial.learnblender3d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tutorial.learnblender3d.Models.CustomLessonModel;
import com.tutorial.learnblender3d.Models.CustomModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class LearnActivity extends AppCompatActivity {

    private static final String KEY_1 = "1";
    ImageView modelingImageView;
    ImageView videosImageView;
    ImageView nodesImageView;

    private static final int NUMBER_OF_ANSWERS = 2;

    ArrayList<Integer> pagesThatHaveQuiz = new ArrayList<Integer>();

    public static final String numberOfQuestionsKey = "Key1";
    public static final String LIST_KEY = "Key3";
    public static final String questionText = "Key4";
    public static final String correctQuestions = "Key5";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        modelingImageView = findViewById(R.id.modelingImageView);
        videosImageView = findViewById(R.id.videosImageView);
        nodesImageView = findViewById(R.id.nodesImageView);
        ImageView navigateBack = findViewById(R.id.navigateBack);

        navigateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        SmoothBottomBar bottomNavigationBar = findViewById(R.id.bottomNavigationBar);
        bottomNavigationBar.setActiveItem(1);
        bottomNavigationBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelect(int i) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(LearnActivity.this, MainActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(LearnActivity.this, ChallengeActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(LearnActivity.this, CommunityActivity.class));
                        break;
                }
            }
        });



        modelingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, LessonActivity.class);
                int numberOfPages;
                numberOfPages = 5;
                final int PAGES_THAT_HAVE_QUESTIONS = 2;

                intent.putExtra(numberOfQuestionsKey, numberOfPages);

                String[] lessonTextArray = new String[numberOfPages];
                int[] imageSequence = new int[numberOfPages];
                String[][] questionTextArray = new String[PAGES_THAT_HAVE_QUESTIONS][NUMBER_OF_ANSWERS];
                int[] correctQuestionsArray = new int[PAGES_THAT_HAVE_QUESTIONS];
                String[] answersText = new String[numberOfPages];
                boolean[] hasQuestions = new boolean[numberOfPages];


                hasQuestions[0] = false;
                hasQuestions[1] = false;
                hasQuestions[2] = true;
                hasQuestions[3] = false;
                hasQuestions[4] = true;

                lessonTextArray[0] = "In this small lesson we will talk about blender and how to install it";
                lessonTextArray[1] = "Blender is a free easy to use 3d software that enables us to many things other than just 3d";
                lessonTextArray[2] = "Why choose Blender";
                lessonTextArray[3] = "Now that you know why you should use blender let's install it!!   First open your pc and go to www.blender.org    This will be the place where you will install blender and embark on your journey";
                lessonTextArray[4] = "Have you installed Blender yet, and how was your first lesson in cgStorm";

                imageSequence[0] = R.drawable.blender_logo;
                imageSequence[1] = R.drawable.lesson0x0;
                imageSequence[2] = R.drawable.transparent_empty;
                imageSequence[3] = R.drawable.lesson0x3;
                imageSequence[4] = R.drawable.transparent_empty;

                questionTextArray[0][0] = "Because it's free";
                questionTextArray[0][1] = "Because it's exp";
                questionTextArray[1][0] = "Great!! I love it";
                questionTextArray[1][1] = "Could be better";

                correctQuestionsArray[0] = 0;
                correctQuestionsArray[1] = 0;

                int temp = 0;

                ArrayList<CustomLessonModel> list = new ArrayList<>();
                for (int i = 0; i < numberOfPages; i++) {
                    CustomLessonModel customLessonModel = new CustomLessonModel(
                            imageSequence[i],
                            hasQuestions[i],
                            lessonTextArray[i]
                    );
                    list.add(customLessonModel);

                    if (list.get(i).isHasQuestion()) {
                        list.get(i).setQuestionTextArray(questionTextArray[temp]);
                        list.get(i).setCorrectQuestions(correctQuestionsArray[temp]);
                        temp++;
                    }
                String j = String.valueOf(i);
                SimpleLesson simpleLesson = new SimpleLesson();
                simpleLesson.setList(list);
                intent.putExtra(LIST_KEY, simpleLesson);
            }
                startActivity(intent);
            }
        });

        nodesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, LessonActivity.class);
                int numberOfPages;
                numberOfPages = 9;
                final int PAGES_THAT_HAVE_QUESTIONS = 3;

                intent.putExtra(numberOfQuestionsKey, numberOfPages);

                String[] lessonTextArray = new String[numberOfPages];
                int[] imageSequence = new int[numberOfPages];
                String[][] questionTextArray = new String[PAGES_THAT_HAVE_QUESTIONS][NUMBER_OF_ANSWERS];
                int[] correctQuestionsArray = new int[PAGES_THAT_HAVE_QUESTIONS];
                String[] answersText = new String[numberOfPages];
                boolean[] hasQuestions = new boolean[numberOfPages];


                hasQuestions[0] = false;
                hasQuestions[1] = false;
                hasQuestions[2] = false;
                hasQuestions[3] = true;
                hasQuestions[4] = false;
                hasQuestions[5] = true;
                hasQuestions[6] = false;
                hasQuestions[7] = false;
                hasQuestions[8] = true;

                lessonTextArray[0] = "Lesson1";
                lessonTextArray[1] = "Lesson2";
                lessonTextArray[2] = "Lesson3";
                lessonTextArray[3] = "Lesson4";
                lessonTextArray[4] = "Lesson5";
                lessonTextArray[5] = "Lesson6";
                lessonTextArray[6] = "Lesson7";
                lessonTextArray[7] = "Lesson8";
                lessonTextArray[8] = "Lesson9";

                imageSequence[0] = R.drawable.transparent_empty;
                imageSequence[1] = R.drawable.transparent_empty;
                imageSequence[2] = R.drawable.transparent_empty;
                imageSequence[3] = R.drawable.transparent_empty;
                imageSequence[4] = R.drawable.transparent_empty;
                imageSequence[5] = R.drawable.transparent_empty;
                imageSequence[6] = R.drawable.transparent_empty;
                imageSequence[7] = R.drawable.transparent_empty;
                imageSequence[8] = R.drawable.transparent_empty;

                questionTextArray[0][0] = "";
                questionTextArray[0][1] = "";
                questionTextArray[1][0] = "";
                questionTextArray[1][1] = "";

                correctQuestionsArray[0] = 0;
                correctQuestionsArray[1] = 0;

                int temp = 0;

                ArrayList<CustomLessonModel> list = new ArrayList<>();
                for (int i = 0; i < numberOfPages; i++) {
                    CustomLessonModel customLessonModel = new CustomLessonModel(
                            imageSequence[i],
                            hasQuestions[i],
                            lessonTextArray[i]
                    );
                    list.add(customLessonModel);

                    if (list.get(i).isHasQuestion()) {
                        list.get(i).setQuestionTextArray(questionTextArray[temp]);
                        list.get(i).setCorrectQuestions(correctQuestionsArray[temp]);
                        temp++;
                    }
                String j = String.valueOf(i);
                SimpleLesson simpleLesson = new SimpleLesson();
                simpleLesson.setList(list);
                intent.putExtra(LIST_KEY, simpleLesson);
            }
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
