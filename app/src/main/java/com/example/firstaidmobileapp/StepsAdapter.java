package com.example.firstaidmobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsViewHolder> {

    Context context;
    List<Steps> step;

    private onClickListener listener1;
    public StepsAdapter(Context context, List<Steps> step, onClickListener listener1){
        this.context = context;
        this.step = step;
        this.listener1 = listener1;
    }

    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StepsViewHolder(LayoutInflater.from(context).inflate(R.layout.steps_view,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder holder, int position) {
        holder.procedureView.setText(step.get(position).getProcedure());
        holder.imageView.setImageResource(step.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener1.onStepsClicked(step.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return step.size();
    }
}
