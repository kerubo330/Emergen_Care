package com.example.firstaidmobileapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class StepsViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView procedureView;
    CardView cardView;



    public StepsViewHolder(@NonNull View StepsView) {
        super(StepsView);
        imageView = StepsView.findViewById(R.id.imageView);
        procedureView = StepsView.findViewById(R.id.procedure);
        cardView = StepsView.findViewById(R.id.cardSteps);


    }



}
