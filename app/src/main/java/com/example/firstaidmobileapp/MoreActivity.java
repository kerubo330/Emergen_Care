package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MoreActivity extends AppCompatActivity implements onClickListener {

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMore);
        btn = findViewById(R.id.buttonMore);

        List<Steps> step = new ArrayList<Steps>();
        step.add(new Steps("About", R.drawable.more));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StepsAdapter(getApplicationContext(), step,this));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(MoreActivity.this,loginActivity2.class));
            }
        });

    }

    @Override
    public void onStepsClicked(Steps step) {
        Intent intent= new Intent(MoreActivity.this,DescriptionActivity.class);
        intent.putExtra("procedure", step.getProcedure());
        intent.putExtra("image", step.getImage());

        startActivity(intent);
    }
}