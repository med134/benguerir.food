package com.example.benguerirfood.services.ui.autre_services.taxi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.autre_services.list_services.ListServices;

public class Taxi extends AppCompatActivity {
    private ImageView btn_back;
    private Button getStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxi);
        getStart=findViewById(R.id.btn_move);
        btn_back=findViewById(R.id.btn_back_of_taxi);
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TaxiMaps.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListServices.class));
            }
        });
    }
}