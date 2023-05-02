package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearnFAActivity extends AppCompatActivity  implements onClickListener{

    public static List<Steps> step = new ArrayList<Steps>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_faactivity);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewSteps);


        step.add(new Steps("Allergies", R.drawable.allergies));
        step.add(new Steps("Asthma Attack", R.drawable.asthma));
        step.add(new Steps("Bleeding", R.drawable.bleeding));
        step.add(new Steps("Broken Bone", R.drawable.brokenbone));
        step.add(new Steps("Burns", R.drawable.burns));
        step.add(new Steps("Choking", R.drawable.choking));
        step.add(new Steps("Diabetic Emergency", R.drawable.diabetes));
        step.add(new Steps("Distress", R.drawable.distress));
        step.add(new Steps("Head Injury", R.drawable.headinjury));
        step.add(new Steps("Heart Attack", R.drawable.heartattack));
        step.add(new Steps("Heat Stroke", R.drawable.heatstroke));
        step.add(new Steps("hypothermia", R.drawable.hypothermia));
        step.add(new Steps("Poisoning or Harmful Substances", R.drawable.poisonous));
        step.add(new Steps("Seizure or Epilepsy", R.drawable.epilepsy));
        step.add(new Steps("Shock", R.drawable.shock));
        step.add(new Steps("Meningitis", R.drawable.menengitis));
        step.add(new Steps("Coronavirus", R.drawable.rona));
        step.add(new Steps("Stings or bites", R.drawable.sting));
        step.add(new Steps("Strain and sprains", R.drawable.sprain));
        step.add(new Steps("Stroke", R.drawable.stroke));
        step.add(new Steps("Unconscious breathing", R.drawable.breathing));
        step.add(new Steps("Unconscious not breathing", R.drawable.unconscious));
        step.add(new Steps("Drowning", R.drawable.drown));
        step.add(new Steps("Nosebleed", R.drawable.nosebleed));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StepsAdapter(getApplicationContext(), step, this));



    }

    @Override
    public void onStepsClicked(Steps step) {

        Intent intent = new Intent(LearnFAActivity.this, DescriptionActivity.class);
        intent.putExtra("procedure", step.getProcedure());
        intent.putExtra("image", step.getImage());
        startActivity(intent);


    }
}

