package com.example.benguerirfood.services.ui.autre_services.pharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.autre_services.list_services.ListServices;

public class Pharmacy extends AppCompatActivity {
   private ImageView btnBack;
   private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        btnBack=findViewById(R.id.btnBack);
        btnNext=findViewById(R.id.btnNext);

          // intent Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pharmacy.this, ListServices.class);
                startActivity(intent);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pharmacy.this, Activity_Soins.class);
                startActivity(intent);
            }
        });



    }
}