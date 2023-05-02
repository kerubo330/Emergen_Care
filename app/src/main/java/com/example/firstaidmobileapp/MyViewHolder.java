package com.example.firstaidmobileapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.media.Image;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView,numberView,emailView;
    CardView cardView;


    public MyViewHolder(@NonNull View ItemView) {
        super(ItemView);
        imageView = ItemView.findViewById(R.id.imageView);
        nameView = ItemView.findViewById(R.id.name);
        numberView = ItemView.findViewById(R.id.number);
        emailView = ItemView.findViewById(R.id.email);
        cardView = ItemView.findViewById(R.id.cardContacts);

    }
}

