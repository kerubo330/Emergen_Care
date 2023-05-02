package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome "+username,Toast.LENGTH_SHORT).show();

        CardView learn = findViewById(R.id.cardLearnFA);
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,LearnFAActivity.class));
            }
        });

        CardView emergency = findViewById(R.id.cardEmergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,EmergencyActivity.class));
            }
        });

        CardView hospital = findViewById(R.id.cardFindHospital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,HospitalActivity.class));
            }
        });

        CardView contact = findViewById(R.id.cardEmergencyContacts);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,ContactActivity.class));
            }
        });

        CardView quiz = findViewById(R.id.cardQuiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(HomeActivity.this,QuizActivity.class));

            }
        });

        CardView more = findViewById(R.id.cardMore);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MoreActivity.class));
            }
        });
    }
}