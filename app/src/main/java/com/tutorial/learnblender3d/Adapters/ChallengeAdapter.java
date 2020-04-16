package com.tutorial.learnblender3d.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.learnblender3d.Models.CustomChallengeModel;
import com.tutorial.learnblender3d.R;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.AcChallengeViewHolder> {

    Context context;
    String[] descriptions;
    int[] stepsImageResources;
    CustomChallengeModel customChallengeModel;

    public ChallengeAdapter(Context context, String[] descriptions, int[] stepsImageResources) {
        this.context = context;
        this.descriptions = descriptions;
        this.stepsImageResources = stepsImageResources;
    }

    @NonNull
    @Override
    public AcChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AcChallengeViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.ac_challenge_item_layout,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AcChallengeViewHolder holder, int position) {
        holder.setUpData(stepsImageResources[position], descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return descriptions.length;
    }

    static class AcChallengeViewHolder extends RecyclerView.ViewHolder {

        ImageView stepImageView;
        TextView stepDescriptionTextView;

        public AcChallengeViewHolder(@NonNull View itemView) {
            super(itemView);

            stepImageView = itemView.findViewById(R.id.stepImageView);
            stepDescriptionTextView = itemView.findViewById(R.id.stepDescription);
        }

        void setUpData(int imageResource, String description) {
            stepImageView.setImageResource(imageResource);
            stepDescriptionTextView.setText(description);
        }
    }
}
