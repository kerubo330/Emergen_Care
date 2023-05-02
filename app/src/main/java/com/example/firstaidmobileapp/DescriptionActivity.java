package com.example.firstaidmobileapp;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstaidmobileapp.databinding.ActivityEmergencyBinding;
import com.example.firstaidmobileapp.databinding.ActivityLearnFaactivityBinding;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    TextView procedureView,descriptionView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptions);


        Intent intent = getIntent();
        String procedure = intent.getStringExtra("procedure");
        int image = intent.getIntExtra("image", R.drawable.firstaid);

        // Display the procedure name and description
        procedureView = findViewById(R.id.procedure);
        imageView = findViewById(R.id.image);
        descriptionView = findViewById(R.id.description);
        procedureView.setText(procedure);
        imageView.setImageResource(image);


                if ("Allergies".equals(procedure)) {
                    String allergy = getString(R.string.Allergies);
                    descriptionView.setText(allergy);
                }
                if ("Asthma Attack".equals(procedure)) {
                    String asthma = getString(R.string.Asthma_Attack);
                    descriptionView.setText(asthma);
                }
                if ("Bleeding".equals(procedure)) {
                    String b = getString(R.string.Bleeding);
                    descriptionView.setText(b);
                }
                if ("Broken Bone".equals(procedure)) {
                    String c = getString(R.string.Broken_Bone);
                    descriptionView.setText(c);
                }
                if ("Burns".equals(procedure)) {
                    String d = getString(R.string.Burns);
                    descriptionView.setText(d);
                }
                if ("Choking".equals(procedure)) {
                    String e = getString(R.string.Choking);
                    descriptionView.setText(e);
                }
                if ("Diabetic Emergency".equals(procedure)) {
                    String f = getString(R.string.Diabetic_Emergency);
                    descriptionView.setText(f);
                }
                if ("Distress".equals(procedure)) {
                    String g = getString(R.string.Distress);
                    descriptionView.setText(g);
                }
                if ("Head Injury".equals(procedure)) {
                    String h = getString(R.string.Head_Injury);
                    descriptionView.setText(h);
                }
                if ("Heart Attack".equals(procedure)) {
                    String i = getString(R.string.Heart_Attack);
                    descriptionView.setText(i);
                }
                if ("Heat Stroke".equals(procedure)) {
                    String j = getString(R.string.Heat_Stroke);
                    descriptionView.setText(j);
                }
                if ("Hypothermia".equals(procedure)) {
                    String k = getString(R.string.Hypothermia);
                    descriptionView.setText(k);
                }
                if ("Poisonous or Harmful Substances".equals(procedure)) {
                    String l = getString(R.string.Poisoning_or_Harmful_Substances);
                    descriptionView.setText(l);
                }
                if ("Seizure or Epilepsy".equals(procedure)) {
                    String m = getString(R.string.Seizure_or_Epilepsy);
                    descriptionView.setText(m);
                }
                if ("Shock".equals(procedure)) {
                    String n = getString(R.string.Shock);
                    descriptionView.setText(n);
                }
                if ("Meningitis".equals(procedure)) {
                    String o = getString(R.string.Meningitis);
                    descriptionView.setText(o);
                }
                if ("Coronavirus".equals(procedure)) {
                    String p = getString(R.string.Coronavirus);
                    descriptionView.setText(p);
                }
                if ("Stings or bites".equals(procedure)) {
                    String al = getString(R.string.Stings_or_bites);
                    descriptionView.setText(al);
                }
                if ("Strain and sprains".equals(procedure)) {
                    String q = getString(R.string.Strain_and_sprains);
                    descriptionView.setText(q);
                }
                if ("Stroke".equals(procedure)) {
                    String r = getString(R.string.Stroke);
                    descriptionView.setText(r);
                }
                if ("Unconscious breathing".equals(procedure)) {
                    String s = getString(R.string.Unconscious_breathing);
                    descriptionView.setText(s);
                }
                if ("Unconscious not breathing".equals(procedure)) {
                    String t = getString(R.string.Unconscious_not_breathing);
                    descriptionView.setText(t);
                }
                if ("Drowning".equals(procedure)) {
                    String tl = getString(R.string.Drowning);
                    descriptionView.setText(tl);
                }
                if ("Nosebleed".equals(procedure)) {
                    String u = getString(R.string.Nosebleed);
                    descriptionView.setText(u);
                }

                if ("Emergency Kit".equals(procedure)) {
                    String u = getString(R.string.Emergency_Kit);
                    descriptionView.setText(u);
                }
                if ("Drought".equals(procedure)) {
                    String u = getString(R.string.Drought);
                    descriptionView.setText(u);
                }
                if ("Earthquake".equals(procedure)) {
                    String u = getString(R.string.Earthquake);
                    descriptionView.setText(u);
                }
                if ("Everyday Emergencies".equals(procedure)) {
                    String u = getString(R.string.Everyday_Emergencies);
                    descriptionView.setText(u);
                }
                if ("Fire".equals(procedure)) {
                    String u = getString(R.string.Fire);
                    descriptionView.setText(u);
                }
                if ("Flooding".equals(procedure)) {
                    String u = getString(R.string.Flooding);
                    descriptionView.setText(u);
                }
                if ("Food Safety".equals(procedure)) {
                    String u = getString(R.string.Food_Safety);
                    descriptionView.setText(u);
                }
                if ("Heatwave".equals(procedure)) {
                    String u = getString(R.string.Heatwave);
                    descriptionView.setText(u);
                }
                if ("Power Outage".equals(procedure)) {
                    String u = getString(R.string.Power_Outage);
                    descriptionView.setText(u);
                }
                if ("Pet Preparedness".equals(procedure)) {
                    String u = getString(R.string.Pet_Preparedness);
                    descriptionView.setText(u);
                }
                if ("Water Safety".equals(procedure)) {
                    String u = getString(R.string.Water_Safety);
                    descriptionView.setText(u);
                }
                if ("Tsunami".equals(procedure)) {
                    String u = getString(R.string.Tsunami);
                    descriptionView.setText(u);
                }
                if ("Wild Fires".equals(procedure)) {
                    String u = getString(R.string.Wild_fires);
                    descriptionView.setText(u);
                }
                if ("Landslide".equals(procedure)) {
                    String u = getString(R.string.Landslide);
                     descriptionView.setText(u);
                }
                if ("About".equals(procedure)) {
                    String u = getString(R.string.About);
                    descriptionView.setText(u);
                }
                if ("Share".equals(procedure)) {
                    String u = getString(R.string.Share);
                    descriptionView.setText(u);
                }

            }

        }




