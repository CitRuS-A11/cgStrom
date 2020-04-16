package com.tutorial.learnblender3d;

import androidx.annotation.NonNull;
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

    LinearLayout bottomCheckAnswerLayout;
    ImageView nextImageView;

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

        bottomCheckAnswerLayout = findViewById(R.id.bottomBarLinearLayout);
        nextImageView = findViewById(R.id.nextImageView);


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        numberOfPages = bundle.getInt(LearnActivity.numberOfQuestionsKey);


//        for (int i = 0; i < numberOfPages; i++) {
//            try {
//                CustomLessonModel customLessonModel = (CustomLessonModel) bundle.getSerializable(String.valueOf(i));
//                list.add(customLessonModel);
//            } catch (Exception e) {
//                break;
//            }
//
//        }

        SimpleLesson simpleLesson = (SimpleLesson) bundle.getSerializable(LearnActivity.LIST_KEY);

        assert simpleLesson != null;
        list = simpleLesson.getList();
    lessonAdapter = new LessonAdapter(this, list);
        viewPager2 = findViewById(R.id.lessonViewPager);

        viewPager2.setAdapter(lessonAdapter);

        float firstCalc = (float) 1 / numberOfPages;
        int finalCalculation = (int) ((firstCalc) * 100);


        progressBar.setScaleY(2.4f);


        cancelImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonActivity.this, LearnActivity.class));
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                calculateProgress(position);
            }
        });


        enableButtonClick(false);


    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(viewPager2.getCurrentItem() + 1 < lessonAdapter.getItemCount())
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            else {
                Intent intent = new Intent(
                        getApplicationContext(), FinishedLessonActivity.class
                );
                intent.putExtra("Key1", getString(R.string.finished_first_lesson));
                startActivity(intent);
                finish();
            }
        }
    };

    private void calculateProgress(int currentPagePosition) {
        float firstCalc = (float) currentPagePosition / numberOfPages;
        int finalCalculation = (int) ((firstCalc) * 100);

        progressBar.setProgress(finalCalculation);
    }

    public void disableButtonClick() {
        nextImageView.setImageDrawable(getDrawable(R.drawable.ic_play_inactive));

        nextImageView.setOnClickListener(null);
    }

    public void enableButtonClick(boolean hasQuestion) {
        nextImageView.setImageDrawable(getDrawable(R.drawable.ic_play));

        nextImageView.setOnClickListener(buttonClickListener);

    }

    public void buttonClickOnCorrectAnswer(String winningSentence) {

    }
    public void buttonClickOnWrongAnswer(String winningSentence) {
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



