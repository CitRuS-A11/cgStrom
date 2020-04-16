package com.tutorial.learnblender3d.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.tutorial.learnblender3d.ChallengeActivity;
import com.tutorial.learnblender3d.ChallengeClickListnerInterface;
import com.tutorial.learnblender3d.Models.CustomChallengeModel;
import com.tutorial.learnblender3d.R;

import java.util.List;

import okhttp3.Challenge;

public class CustomChallengeAdapter extends RecyclerView.Adapter<CustomChallengeAdapter.ChallengesViewHolder>{

    List<CustomChallengeModel> list;
    private Context context;
    private static Context contextStatic;
    private ChallengeClickListnerInterface listnerInterface;
    private static ChallengeClickListnerInterface listnerInterfaceStatic;

    public CustomChallengeAdapter(List<CustomChallengeModel> list, Context context, ChallengeClickListnerInterface listnerInterface) {
        this.list = list;
        this.context = context;
        contextStatic = context;
        this.listnerInterface = listnerInterface;
        listnerInterfaceStatic = listnerInterface;
    }

    @NonNull
    @Override
    public ChallengesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChallengesViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.challenge_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengesViewHolder holder, int position) {
        holder.setChallengeData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ChallengesViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kdvChallenges;
        private TextView titleTextView, textChallenge, stepsTextView;
        private CardView cardView;

        private ChallengesViewHolder(@NonNull View itemView) {
            super(itemView);


            kdvChallenges = itemView.findViewById(R.id.kdvChallenge);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            textChallenge = itemView.findViewById(R.id.textChallenge);
            stepsTextView = itemView.findViewById(R.id.stepsTextView);
            cardView = itemView.findViewById(R.id.challengeItemCardView);
        }

        void setChallengeData(CustomChallengeModel challenge) {
//            Picasso.get().load(challenge.Url).into(kdvChallenges);
            kdvChallenges.setImageResource(challenge.imageResource);
            textChallenge.setText(challenge.description);
            titleTextView.setText(challenge.title);

            stepsTextView.setText(String.valueOf(challenge.stepsCount));
            kdvChallenges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (contextStatic instanceof ChallengeActivity) {
                        ((ChallengeActivity)contextStatic).onClickNonStatic();
                    } else {
                        listnerInterfaceStatic.onItemClick();
                    }
                }
            });
        }

    }
}
