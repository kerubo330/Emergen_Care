package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class EmergencyActivity extends AppCompatActivity implements onClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);


        RecyclerView recyclerView = findViewById(R.id.recyclerViewStep);

        List<Steps> step = new ArrayList<Steps>();
        step.add(new Steps("Emergency Kit", R.drawable.two));
        step.add(new Steps("Drought", R.drawable.drought));
        step.add(new Steps("Earthquake", R.drawable.earthquake));
        step.add(new Steps("Everyday Emergencies", R.drawable.hand_burn));
        step.add(new Steps("Fire", R.drawable.firebuilding));
        step.add(new Steps("Flooding", R.drawable.flooding));
        step.add(new Steps("Food Safety", R.drawable.food_poison));
        step.add(new Steps("Heatwave", R.drawable.heatwave));
        step.add(new Steps("Power Outage", R.drawable.poweroutage));
        step.add(new Steps("Pet Preparedness", R.drawable.pet));
        step.add(new Steps("Water Safety", R.drawable.drown));
        step.add(new Steps("Landslide", R.drawable.landslide));
        step.add(new Steps("Tsunami", R.drawable.tsunami));
        step.add(new Steps("Wild Fires", R.drawable.wildfire));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StepsAdapter(getApplicationContext(), step,this));
    }

    @Override
    public void onStepsClicked(Steps step) {
        Intent intent= new Intent(EmergencyActivity.this,DescriptionActivity.class);
        intent.putExtra("procedure", step.getProcedure());
        intent.putExtra("image", step.getImage());

        startActivity(intent);
    }
}