package com.example.firstaidmobileapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.firstaidmobileapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private static final String TAG = "MapActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private Boolean mLocationPermissionGranted = false;
    //private FusedLocationProviderClient mFusedLocationProviderClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLocationPermissions();

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
    /* private void getDeviceLocation(){
           *Log.d(TAG,"getDeviceLocation: getting the device's current  location");
           *mFusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this);
           *try{
              * if(mLocationPermissionGranted){
                  * Task location = mFusedLocationProviderClient.getLastLocation();
                   location.addOnCompleteListener(new OnCompleteListener() {
                       @Override
                       public void onComplete(@NonNull Task task) {
                           if(task.isSuccessful()){
                               Log.d(TAG,"onComplete: found location");
                               Location currentLocation = (Location) task.
                           }else{
                               Log.d(TAG,"onComplete: current location is null");
                               Toast.makeText(MapsActivity.this,"Unable to get Current Location", Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
               }
           }catch(SecurityException e){
               Log.e(TAG,"getDeviceLocation: SecurityException", + e.getMessage());
           }

       }
    */
    private void initMap() {
        Log.d(TAG,"initMap: Initializing Map");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Toast.makeText(this,"Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"onReadyMap: Map is Ready");

        // Check if location permission is granted
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Search for nearby hospitals
        String hospital = "hospital";
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=" + mMap.getMyLocation().getLatitude() + "," + mMap.getMyLocation().getLongitude() +
                "&radius=5000" +
                "&types=" + hospital +
                "&key=" + getString(R.string.google_maps_API_key);
    }
    private void getLocationPermissions(){
        Log.d(TAG,"getLocationPermission: getting Location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                mLocationPermissionGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,permissions,LOCATION_PERMISSION_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG,"OnRequestPermissionResult:called.");
        mLocationPermissionGranted = false;

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionGranted = false;
                            Log.d(TAG,"OnRequestPermissionResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG,"OnRequestPermissionResult: permission granted");
                    mLocationPermissionGranted = true;
                    //initialize map
                    initMap();

                }
            }
        }
    }
}