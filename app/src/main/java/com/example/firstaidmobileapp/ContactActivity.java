package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity implements OnItemClickListener{
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Amref","0722207350 ","emergency@flydoc.org",R.drawable.ambulance));
        items.add(new Item("Red Cross","0700395395 ","dispatch@eplus.co.ke",R.drawable.ambulance));
        items.add(new Item("St. John's Ambulance ","0721225285  ","nairobi@stjohnkenya.org",R.drawable.ambulance));
        items.add(new Item("Critical Care Ambulance","0716400500 ","",R.drawable.ambulance));
        items.add(new Item("AAR Health Emergency","0725225225 ","radio.room@aar-healthcare.com",R.drawable.ambulance));
        items.add(new Item("Avenue Rescue Services","0711060000 ","dispatch@avenuehealthcare.com",R.drawable.ambulance));
        items.add(new Item("Nairobi Fire Brigade","0202222181 ","",R.drawable.firetruck));
        items.add(new Item("Kenyatta National Hospital","0738606409 ","",R.drawable.hospital));
        items.add(new Item("Aga Khan Hospital","071109200","",R.drawable.hospital));
        items.add(new Item("MP Shah Hospital","0203746177 ","",R.drawable.hospital));
        items.add(new Item("Gertrude Garden Children's Hospital","0207206000 ","",R.drawable.hospital));
        items.add(new Item("Mathare Hospital","07176943399","",R.drawable.hospital));
        items.add(new Item("Moi Teaching abbd Referal Hospital","0701393979","",R.drawable.hospital));
        items.add(new Item("Missing Child Report","0800223344 ","",R.drawable.emergencycontacts));
        items.add(new Item("Gender-Based Violence","1195 ","",R.drawable.emergencycontacts));
        items.add(new Item("Child Abuse","0722 116 116 ","",R.drawable.emergencycontacts));
        items.add(new Item("Kenya Police Headquarters","0726035455 ","",R.drawable.ambulance));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items,this));



    }


    @Override
    public void onItemClicked(Item items) {
        Intent intent= new Intent(ContactActivity.this,EditActivity.class);
        intent.putExtra("name", items.getName());
        intent.putExtra("email", items.getEmail());
        intent.putExtra("number", items.getNumber());
        intent.putExtra("image", items.getImage());
        startActivity(intent);

    }


}