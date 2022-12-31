package com.example.benguerirfood.services.ui.autre_services.taxi;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.benguerirfood.R;
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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class TaxiMaps extends FragmentActivity implements OnMapReadyCallback {
    private SupportMapFragment fragment;
    private FusedLocationProviderClient client;
    private LocationRequest locationRequest;
    private GoogleMap map;
    private AutoCompleteTextView searchView;
    private Button btnTruck;
    private FloatingActionButton btnLOcation;
    private EditText textPosstion;
    private MarkerOptions place1,place2;
    private Double latiti1,lontit2;
    private Double lat1,lon2;
    private Polyline currentPolyline;
    ArrayAdapter<String> adapter;
    String[] listQuartie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi_map);
        btnTruck=findViewById(R.id.btnTruck);
        btnLOcation=findViewById(R.id.getLocations);
        textPosstion=findViewById(R.id.votrePossition);
        searchView  = findViewById(R.id.search_view);
        listQuartie= getResources().getStringArray(R.array.list);
        fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.taxiMaps);
        client = LocationServices.getFusedLocationProviderClient(this);
        acessLocation();

        btnTruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                place1 = new MarkerOptions().position(new LatLng(latiti1, lontit2)).title("Location 1");
                place2 = new MarkerOptions().position(new LatLng(lat1, lon2)).title("Location 2");
                String src= textPosstion.getText().toString().trim();
               // String dis=searchView.getQuery().toString().trim();
                //displaydraw(src,dis);
            }
        });
        btnLOcation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                acessLocation();
                curent();
            }
        });
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listQuartie);
        searchView.setThreshold(1);
         searchView.setAdapter(adapter);
         searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String location=  adapter.getItem(1);
                 List<Address> addressList = null;
                 if(location != null || !location.equals("")){
                     Geocoder geocoder = new Geocoder(TaxiMaps.this);
                     try {
                         addressList=geocoder.getFromLocationName(location,1);
                     }catch (IOException e){
                         e.printStackTrace();
                     }
                     Address address=addressList.get( 0 );
                     LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                     map.addMarker(new MarkerOptions().position(latLng).title(location).
                             icon(bitmapDescriptor(getApplicationContext(),R.drawable.pin)));
                     map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
                     lat1=address.getLatitude();
                     lon2=address.getLongitude();
                 }
             }
         });
        /*
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location=  searchView.getQuery().toString().trim();
                List<Address> addressList = null;
                if(location != null || !location.equals("")){
                    Geocoder geocoder= new Geocoder(TaxiMaps.this);
                    try {
                        addressList=geocoder.getFromLocationName(location,1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address=addressList.get( 0 );
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    map.addMarker(new MarkerOptions().position(latLng).title(location).
                            icon(bitmapDescriptor(getApplicationContext(),R.drawable.pin)));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
                    lat1=address.getLatitude();
                    lon2=address.getLongitude();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

         */

        fragment.getMapAsync(this);

    }
    private void displaydraw(String src, String dis) {
        try {
            Uri uri =Uri.parse("https://www.google.co.in/maps/dir/"+src+ "/"+dis);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            Uri uri =Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
    }

    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map=googleMap;

    }
    // permmssion de acces localisation
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
                    Toast.makeText(TaxiMaps.this, "Location is On", Toast.LENGTH_LONG).show();
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case LocationSettingsStatusCodes
                                .RESOLUTION_REQUIRED:

                            try {
                                ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                                resolvableApiException.startResolutionForResult(TaxiMaps.this, 1001);
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
                    Toast.makeText(TaxiMaps.this, "Location is On", Toast.LENGTH_LONG).show();
                    break;
                case Activity.RESULT_CANCELED:
                    Toast.makeText(TaxiMaps.this, "location is requied you be turned on",Toast.LENGTH_LONG).show();
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
                    fragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            LatLng latLng=new LatLng(location.getLatitude(),location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(latLng).title("");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
                            googleMap.addMarker(options).showInfoWindow();
                            latiti1=location.getLatitude();
                            lontit2=location.getLongitude();
                            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                            try {
                                List<Address> addresses= geocoder.getFromLocation(latiti1,lontit2,1);
                                String adressss= addresses.get(0).getAddressLine(0);
                                textPosstion.setText(adressss);


                            }catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });
    }
    private BitmapDescriptor bitmapDescriptor(Context context ,int vector){
        Drawable vectorDrawble = ContextCompat.getDrawable(context,vector);
        vectorDrawble.setBounds(0,0,vectorDrawble.getIntrinsicWidth(),vectorDrawble.getIntrinsicHeight());
        Bitmap bitmap=Bitmap.createBitmap(vectorDrawble.getIntrinsicWidth(),vectorDrawble.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas= new Canvas(bitmap);
        vectorDrawble.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);

    }



}