package com.tutorial.learnblender3d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.tutorial.learnblender3d.Adapters.LessonAdapter;
import com.tutorial.learnblender3d.Models.CustomLessonModel;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {

    private static final String TAG = LessonActivity.class.getSimpleName();
    LinearLayout topbarLinearLayout;
    ImageView cancelImageView;
    ProgressBar progressBar;
    ImageView renderImageView;

    ArrayList<CustomLessonModel> list = new ArrayList<>();
    LessonAdapter lessonAdapter;
    ViewPager2 viewPager2;

    // lesson text and answers
    TextView lessonTextView;
    LinearLayout answer1, answer2, answer3;
    TextView answerTextView1, answerTextView2, answerTextView3;
    ImageView chackboxAnswer1, chackboxAnswer2, chackboxAnswer3;

    int numberOfPages;

    ArFragment arFragment;
    private ModelRenderable cubeRenderable;

    View arrayView[];
    ViewRenderable name_asset;

    int selected = 1;

    int currentPage = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        topbarLinearLayout = findViewById(R.id.topBarLinearLayout);
        cancelImageView = findViewById(R.id.cancelImageView);
        progressBar = findViewById(R.id.progressbarHorizontal);
        renderImageView = findViewById(R.id.cubeImageView);

        lessonTextView = findViewById(R.id.lessonTextView);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);

        answerTextView1 = findViewById(R.id.answerTextView);
        answerTextView2 = findViewById(R.id.answerTextView2);
        answerTextView3 = findViewById(R.id.answerTextView3);

        chackboxAnswer1 = findViewById(R.id.correctAnswerCheckMarkImageView);
        chackboxAnswer2 = findViewById(R.id.correctAnswerCheckMarkImageView2);
        chackboxAnswer3 = findViewById(R.id.correctAnswerCheckMarkImageView3);




        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        numberOfPages = bundle.getInt(LearnActivity.numberOfQuestionsKey);

        for (int i = 0; i < numberOfPages; i++) {
            try {
                CustomLessonModel customLessonModel = (CustomLessonModel) bundle.getSerializable(String.valueOf(i));
                list.add(customLessonModel);
            } catch (Exception e) {
                break;
            }

        }

        lessonAdapter = new LessonAdapter(this, list);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(lessonAdapter);

        float firstCalc = (float) 1 / numberOfPages;
        int finalCalculation = (int) ((firstCalc) * 100);

        progressBar.setProgress(calculateProgress(numberOfPages));
        progressBar.setScaleY(2.4f);


        cancelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LearnActivity.class));
            }
        });
//

    }

    private int calculateProgress(int currentPagePosition) {
        float firstCalc = (float) currentPagePosition / numberOfPages;
        int finalCalculation = (int) ((firstCalc) * 100);

        return (int) ((firstCalc) * 100);
    }
}
//
//    private void setClickListner() {
//
//    }
//
//    private void setupModel() {
//        ModelRenderable.builder()
//                .setSource(this, R.raw.asset)
//                .build().thenAccept(rendrable -> cubeRenderable = rendrable)
//                .exceptionally(throwable ->
//                {
//                    Toast.makeText(this, "Unnable to load Cube Model", Toast.LENGTH_SHORT).show();
//                    return null;
//                });
//
//
//    }
//
//    private void createModel (AnchorNode anchorNode){
//        TransformableNode cube = new TransformableNode(arFragment.getTransformationSystem());
//        cube.setParent(anchorNode);
//        cube.setRenderable(cubeRenderable);
//        cube.select();
//    }



