package com.example.firstaidmobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class HospitalActivity extends AppCompatActivity {
    private static final String TAG ="HospitalActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        if (isServicesOK()) {
            init();
        }

    }
    private void init() {
        Button btnMap=(Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HospitalActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(HospitalActivity.this);
        if( available == ConnectionResult.SUCCESS){
            //everything is ok
            Log.d(TAG,"isServiceOK: Google Play Services is working");
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //error occurred but can be resolved
            Log.d(TAG,"isServiceOK: an error occurred but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(HospitalActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }
        else{
            Toast.makeText(this, "We can't make map requests",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}