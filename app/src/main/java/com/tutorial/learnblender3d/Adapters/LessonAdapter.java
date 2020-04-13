package com.tutorial.learnblender3d.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.tutorial.learnblender3d.LessonActivity;
import com.tutorial.learnblender3d.Models.CustomLessonModel;
import com.tutorial.learnblender3d.Models.CustomModel;
import com.tutorial.learnblender3d.R;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.lessonViewHolder> {

    private ArrayList<CustomLessonModel> onBoardingItems;
    private Context context;
    private static final int CHECKMARK_IN_LAYOUT = 1;

    public LessonAdapter(Context context, ArrayList<CustomLessonModel> onBoardingItems) {
        this.context = context;
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public LessonAdapter.lessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LessonAdapter.lessonViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_view, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.lessonViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class lessonViewHolder extends RecyclerView.ViewHolder {

        TextView lessonTextView;
        ImageView lessonImageView;
        LinearLayout answer1, answer2, answer3;
        TextView answer1TextView, answer2TextView, answer3TextView;
        ImageView answer1checkMark, answer2checkMark, answer3checkMark;
        ImageView nextImageView;
        LinearLayout answersLayout;

        public lessonViewHolder(@NonNull View itemView) {
            super(itemView);

            lessonTextView = itemView.findViewById(R.id.lessonTextView);
            lessonImageView = itemView.findViewById(R.id.lessonImageView);
            answer1 = itemView.findViewById(R.id.answer1);
            answer2 = itemView.findViewById(R.id.answer2);
            answer3 = itemView.findViewById(R.id.answer3);

            answer1TextView = itemView.findViewById(R.id.answerTextView);
            answer2TextView = itemView.findViewById(R.id.answerTextView2);
            answer3TextView = itemView.findViewById(R.id.answerTextView3);

            answer1checkMark = itemView.findViewById(R.id.correctAnswerCheckMarkImageView);
            answer2checkMark = itemView.findViewById(R.id.correctAnswerCheckMarkImageView2);
            answer3checkMark = itemView.findViewById(R.id.correctAnswerCheckMarkImageView3);

            nextImageView = itemView.findViewById(R.id.nextImageView);

            answersLayout = itemView.findViewById(R.id.answersLayout);

            answer1checkMark.setVisibility(View.INVISIBLE);
            answer2checkMark.setVisibility(View.INVISIBLE);
            answer3checkMark.setVisibility(View.INVISIBLE);
        }

        void setOnBoardingData(CustomLessonModel lessonItem) {
            lessonTextView.setText(lessonItem.getLessonText());
            lessonImageView.setImageDrawable(context.getResources().getDrawable(lessonItem.getImageResource()));
            if (lessonItem.isHasQuestion()) {
                answer1.setVisibility(View.INVISIBLE);
                answer2.setVisibility(View.INVISIBLE);
                answer3.setVisibility(View.INVISIBLE);
            } else {
                answer1TextView.setText(lessonItem.getQuestionTextArray()[0]);
                answer2TextView.setText(lessonItem.getQuestionTextArray()[1]);

                Context context;
                LinearLayout correctAnswer = (LinearLayout) answersLayout.getChildAt(lessonItem.getCorrectQuestions());

                answer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(answer1 == correctAnswer) {
                            answer1checkMark.setVisibility(View.VISIBLE);
                        } else {
                            Snackbar.make(v, "Wrong Answer", BaseTransientBottomBar.LENGTH_SHORT).show();
                        }
                    }
                });
                answer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(answer2 == correctAnswer) {
                            answer2checkMark.setVisibility(View.VISIBLE);
                        } else {
                            Snackbar.make(v, "Wrong Answer", BaseTransientBottomBar.LENGTH_SHORT);

                        }
                    }
                });
            }
        }

    }
}
