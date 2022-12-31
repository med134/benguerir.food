 package com.example.benguerirfood.localisation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.Services;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Locale;

 public  class Get_Location extends AppCompatActivity implements LocationListener {
    SupportMapFragment supportMapFragment;
    public static EditText textAdress,textRepire;
    private Button btnSetAdress;
    FusedLocationProviderClient client;
    LocationManager locationManager;
    LocationRequest locationRequest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_location);
        textAdress=findViewById(R.id.text_location);
        textRepire=findViewById(R.id.text_piotRebiir);
        btnSetAdress=findViewById(R.id.button_location);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        client= LocationServices.getFusedLocationProviderClient(Get_Location.this);
        //check location permission
        if (ContextCompat.checkSelfPermission(Get_Location.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(Get_Location.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 1001);
            acessLocation();
            curent();
            getLocation();
        }
        else {
            acessLocation();
            curent();
            getLocation();
        }
      btnSetAdress.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              moveToNext();
          }
      });
    }
     @SuppressLint("MissingPermission")
     private void getLocation() {
         try {
             locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
             locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 5, Get_Location.this);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     @Override
     public void onLocationChanged(Location location) {
         try {
             Geocoder geocoder = new Geocoder(Get_Location.this, Locale.getDefault());
             List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
             String address = addresses.get(0).getAddressLine(0);
             textAdress.setText(address);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     @Override
     public void onStatusChanged(String provider, int status, Bundle extras) {

     }

     @Override
     public void onProviderEnabled(String provider) {

     }

     @Override
     public void onProviderDisabled(String provider) {

     }

     public void acessLocation() {
         locationRequest = LocationRequest.create();
         locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
         locationRequest.setInterval(5000);
         locationRequest.setFastestInterval(2000);
         LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
         builder.setAlwaysShow(true);
         Task<LocationSettingsResponse> requestTask = LocationServices.getSettingsClient(getApplicationContext()).checkLocationSettings(builder.build());
         requestTask.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
             @Override
             public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                 try {
                     LocationSettingsResponse response = task.getResult(ApiException.class);
                     Toast.makeText(Get_Location.this, "Location is On", Toast.LENGTH_LONG).show();
                 } catch (ApiException e) {
                     switch (e.getStatusCode()) {
                         case LocationSettingsStatusCodes
                                 .RESOLUTION_REQUIRED:
                             try {
                                 ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                 resolvableApiException.startResolutionForResult(Get_Location.this, 1001);
                             } catch (IntentSender.SendIntentException sendIntentException) {

                             }
                             break;
                         case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                             break;
                     }
                 }
             }
         });
     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if (requestCode == 1001) {
             switch (resultCode) {
                 case Activity
                         .RESULT_OK:
                     Toast.makeText(Get_Location.this, "Location is On", Toast.LENGTH_LONG).show();
                     break;
                 case Activity.RESULT_CANCELED:
                     Toast.makeText(Get_Location.this, "location is requied you be turned on", Toast.LENGTH_LONG).show();
             }
         }
     }

     public void curent(){
         if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                 != PackageManager.PERMISSION_GRANTED &&
                 ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                         != PackageManager.PERMISSION_GRANTED) {
             // TODO: Consider calling
             //    ActivityCompat#requestPermissions
             return;
         }
         Task<Location> task = client.getLastLocation();
         task.addOnSuccessListener(new OnSuccessListener<Location>() {
             @Override
             public void onSuccess(Location location) {
                 if(location != null){
                     supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                         @Override
                         public void onMapReady(GoogleMap googleMap) {
                             LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
                             MarkerOptions options = new MarkerOptions().position(latLng).title("");
                             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                             googleMap.addMarker(options).showInfoWindow();

                         }
                     });
                 }
             }
         });
     }
     @SuppressLint("MissingSuperCall")
     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
         if(requestCode == 1001 ){
             if(grantResults.length > 0  && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                 curent();

             }else{
                 Toast.makeText(this,"permission denide",Toast.LENGTH_SHORT).show();
             }
         }
     }
     public void moveToNext(){
         if(textRepire.length() <5) {
             textRepire.setFocusable(true);
             textRepire.setError("add a valid point repair");
             showAlertDiaoge();
         }else{
             Intent intent = new Intent(Get_Location.this, Services.class);
             startActivity(intent);
         }
     }
     void showAlertDiaoge(){
         LayoutInflater layoutInflater = LayoutInflater.from(Get_Location.this);
         View view =layoutInflater.inflate(R.layout.alert_warning,null);
         AlertDialog alertDialog =new AlertDialog.Builder(Get_Location.this).setView(view).create();
         Button buttonOK = view.findViewById(R.id.buttonYes);
         TextView text_title =view.findViewById(R.id.textTitle);
         TextView text_mesage=view.findViewById(R.id.textMessage);
         buttonOK.setText("OK");
         text_title.setText("WARNING MESSAGE");
         text_mesage.setText("Please adding repair point !");
         buttonOK.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 alertDialog.dismiss();
             }
         });
         alertDialog.show();
     }



 }
