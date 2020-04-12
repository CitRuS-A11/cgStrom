package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tutorial.learnblender3d.Models.CustomLessonModel;
import com.tutorial.learnblender3d.Models.CustomModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LearnActivity extends AppCompatActivity {

    private static final String KEY_1 = "1";
    ImageView modelingImageView;
    ImageView videosImageView;
    ImageView nodesImageView;

    private static final int NUMBER_OF_ANSWERS = 2;

    ArrayList<Integer> pagesThatHaveQuiz = new ArrayList<Integer>();

    public static final String numberOfQuestionsKey = "Key1";
    public static final String lessonText = "Key3";
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

        modelingImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnActivity.this, LessonActivity.class);
                startActivity(intent);
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
                lessonTextArray[4] = "Know have you installed Blender and how was your first lesson in cgStorm";

                imageSequence[0] = R.drawable.transparent_empty;
                imageSequence[1] = R.drawable.lesson0x0;
                imageSequence[2] = R.drawable.transparent_empty;
                imageSequence[3] = R.drawable.lesson0x3;
                imageSequence[4] = R.drawable.transparent_empty;

                questionTextArray[0][0] = "Because it's free and easy to use";
                questionTextArray[0][1] = "Because it's expensive and hard to use";
                questionTextArray[1][0] = "Great!! I love it";
                questionTextArray[1][1] = "Could be better";

                correctQuestionsArray[0] = 0;
                correctQuestionsArray[1] = 1;

                ArrayList<CustomLessonModel> list = new ArrayList<>();
                for (int i = 0; i < numberOfPages; i++) {
                    CustomLessonModel customLessonModel = new CustomLessonModel(
                            imageSequence[i],
                            /*hasQuestions[i]*/false,
                            lessonTextArray[i]
                    );
                    list.add(customLessonModel);
                    if (list.get(i).isHasQuestion()) {
                        if (list.get(i).isHasQuestion()) {
                            for (int j = 0; j < correctQuestionsArray.length; j++) {
                                list.get(i).setQuestionTextArray(questionTextArray[j]);
                                list.get(j).setCorrectQuestions(correctQuestionsArray[j]);
                            }
                        }
                        String j = String.valueOf(i);
                        intent.putExtra(j, list.get(i));
                    }
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
