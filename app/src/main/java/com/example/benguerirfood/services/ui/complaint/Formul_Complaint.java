package com.example.benguerirfood.services.ui.complaint;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;

public class Formul_Complaint extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formul_complaint);
        textView=findViewById(R.id.textreserve);


    }
}