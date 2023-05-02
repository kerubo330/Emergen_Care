package com.example.firstaidmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String number = intent.getStringExtra("number");
        int image = intent.getIntExtra("image", R.drawable.firstaid);

        TextView nameView = findViewById(R.id.name);
        TextView emailView = findViewById(R.id.email);
        TextView numberView = findViewById(R.id.number);
        ImageView imageView = findViewById(R.id.image);

        nameView.setText(name);
        emailView.setText(email);
        numberView.setText(number);
        imageView.setImageResource(image);
        Database db = new Database(getApplicationContext(),"FirstAid",null,1);
    }
}