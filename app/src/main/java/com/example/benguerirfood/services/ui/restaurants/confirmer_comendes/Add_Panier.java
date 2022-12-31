package com.example.benguerirfood.services.ui.restaurants.confirmer_comendes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;

public class Add_Panier extends AppCompatActivity {
    private TextView titleTxet,numberItemTxxt,prixt,totalPrice,isEmpty;
    private ImageView pic,plusCardBtn,minusCardBtn;
    private RecyclerView mylistViewh;
    private ScrollView scrollView;
    private static int i=1;
    Iteams object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_panier);
        scrollView=findViewById(R.id.myScrool);
        pic=findViewById(R.id.image_Panier);
        plusCardBtn=findViewById(R.id.plusCardBtn);
        mylistViewh=findViewById(R.id.mylistViewh);
        minusCardBtn=findViewById(R.id.minusCardBtn);
        titleTxet=findViewById(R.id.titleTxet);
        isEmpty=findViewById(R.id.textEmpty);
        totalPrice=findViewById(R.id.totalCaise);
        numberItemTxxt=findViewById(R.id.incrementProduit);
        prixt=findViewById(R.id.prixt);



        }
}