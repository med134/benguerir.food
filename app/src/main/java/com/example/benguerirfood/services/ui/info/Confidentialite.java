package com.example.benguerirfood.services.ui.info;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;

public class Confidentialite extends AppCompatActivity {
    private TextView textConfidilité;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confidentialite_info);
        textConfidilité=findViewById(R.id.textConfidilité);
    }
}
