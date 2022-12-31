package com.example.benguerirfood.services.ui.info;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;

public class Conditions_Vente extends AppCompatActivity {
    private TextView textVente;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditions_vente);
        textVente=findViewById(R.id.textVente);
    }
}
