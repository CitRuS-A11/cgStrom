package com.tutorial.learnblender3d.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorial.learnblender3d.Models.CustomModel;
import com.tutorial.learnblender3d.R;

import java.util.List;

public class CustomPagerAdapter extends RecyclerView.Adapter<CustomPagerAdapter.OnBoardingViewHolder> {

    private List<CustomModel> onBoardingItems;

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    public CustomPagerAdapter(List<CustomModel> onBoardingItem) {
        this.onBoardingItems = onBoardingItem;
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        private TextView descriptionTextView;
        private ImageView imageView;

        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void setOnBoardingData(CustomModel onBoardingItem) {
            titleTextView.setText(onBoardingItem.getTitle());
            descriptionTextView.setText(onBoardingItem.getDescription());
            imageView.setImageResource(onBoardingItem.getImageResource());
        }
    }

}
