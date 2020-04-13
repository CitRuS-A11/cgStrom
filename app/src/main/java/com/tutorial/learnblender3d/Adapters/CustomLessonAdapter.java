package com.tutorial.learnblender3d.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.learnblender3d.Models.CustomLessonModel;
import com.tutorial.learnblender3d.R;

import java.util.List;

public class CustomLessonAdapter extends RecyclerView.Adapter<CustomLessonAdapter.LessonViewHolder>{

    private List<CustomLessonModel> list;

    public CustomLessonAdapter(List<CustomLessonModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LessonViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.lesson_view, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        holder.setUpData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.lessonTextView);
        }
        void setUpData (CustomLessonModel lessonModel) {
            textView.setText("Hello World");
        }

    }
}
