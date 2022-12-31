package com.example.benguerirfood.services.ui.restaurants.confirmer_comendes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.benguerirfood.R;

public class Confirmer_Comendes extends AppCompatActivity {
    private ImageView fooPic,plusCardBtn,minusCardBtn;
    private TextView numberItemTxt,descriptionTxt,titleTxt,VicaloriesTxt,priceTxt;
    public static TextView total;
    private Button addToCartBtn;
    private Toolbar toolbar;
    public static int i=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmer_comendes);
        fooPic=findViewById(R.id.foodPic);
        plusCardBtn=findViewById(R.id.plusCardBtn);
        minusCardBtn=findViewById(R.id.minusCardBtn);
        numberItemTxt=findViewById(R.id.numberItemTxt);
        titleTxt=findViewById(R.id.titleTxt);
        plusCardBtn=findViewById(R.id.plusCardBtn);
        minusCardBtn=findViewById(R.id.minusCardBtn);
        VicaloriesTxt=findViewById(R.id.VicaloriesTxt);
        priceTxt=findViewById(R.id.priceTxt);
        minusCardBtn=findViewById(R.id.minusCardBtn);
        numberItemTxt=findViewById(R.id.numberItemTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        addToCartBtn=findViewById(R.id.btn_add_tocart);
      //,  total=findViewById(R.id.total);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Add To Card");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        numberItemTxt.setText(String.valueOf(i));


        plusCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                numberItemTxt.setText(String.valueOf(i));
            }
        });
        minusCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>1){
                    i--;
                    numberItemTxt.setText(String.valueOf(i));
                }else{
                    Toast.makeText(getApplicationContext(),"UNE COMMANDE MINUMUM",Toast.LENGTH_LONG).show();
                }
            }
        });
        // intent to caisse activity
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Add_Panier.class));
            }
        });

        Intent intent=getIntent();
        fooPic.setImageResource(Integer.parseInt(intent.getStringExtra("myImagepizza")));
        titleTxt.setText(intent.getStringExtra("pizza"));
        VicaloriesTxt.setText(intent.getStringExtra("calores"));
        descriptionTxt.setText(intent.getStringExtra("descrption"));
        priceTxt.setText(intent.getStringExtra("price"));

    }

}