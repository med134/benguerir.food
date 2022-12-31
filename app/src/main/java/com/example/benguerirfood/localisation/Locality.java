package com.example.benguerirfood.localisation;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.benguerirfood.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class Locality extends AppCompatActivity {
    private ImageView activer_localisaton;
    private Button btnNotNow;
    LocationRequest locationRequest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activer_localisation);
        activer_localisaton=findViewById(R.id.btn_activerLocalisation);
        btnNotNow=findViewById(R.id.btn_notNow);
        ConnectivityManager manager= (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = manager.getActiveNetworkInfo();

        if(wifi == null || !wifi.isConnected() || !wifi.isAvailable() ){

        showAlertDiaoge();

        }else {
          //  startActivity(new Intent(getApplicationContext(),Get_Location.class));
            activer_localisaton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ContextCompat.checkSelfPermission(Locality.this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Locality.this, new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION
                        }, 1001);

                    } else {
                        acessLocation();
                        movetoNext();
                    }

                }
            });
        }

        btnNotNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Locality.this,Get_Location.class);
                startActivity(intent);
            }
        });
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
                    Toast.makeText(Locality.this, "Location is On", Toast.LENGTH_LONG).show();
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes
                                .RESOLUTION_REQUIRED:
                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(Locality.this, 1001);
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
    public void movetoNext(){

        Intent intent = new Intent(Locality.this,Get_Location.class);
        startActivity(intent);
    }
    void showAlertDiaoge(){
        LayoutInflater layoutInflater = LayoutInflater.from(Locality.this);
        View view =layoutInflater.inflate(R.layout.no_internet_alert,null);
        AlertDialog alertDialog =new AlertDialog.Builder(Locality.this).setView(view).create();
        Button buttonOK = view.findViewById(R.id.buttonYes1);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        alertDialog.show();
    }





}






