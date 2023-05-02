package com.example.firstaidmobileapp;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    LayoutInflater layoutInflater;

    private OnItemClickListener listener;

    public MyAdapter(Context context, List<Item> items, OnItemClickListener listener){
        this.context = context;
        this.items = items;
        this.listener = listener;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.contacts_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameView.setText(items.get(position).getName());
        holder.emailView.setText(items.get(position).getEmail());
        holder.numberView.setText(items.get(position).getNumber());
        holder.imageView.setImageResource(items.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(items.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
