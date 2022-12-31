package com.example.benguerirfood.services.ui.restaurants.confirmer_comendes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;


public class Caisse extends AppCompatActivity {
    private Toolbar backbtn;
    private Button btnConfirmer,btnAddProduits;
    private EditText textNumbre;
    TextView lieuDeLivrasion,totalPrix,titleComande;
     public EditText lieu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caisse);
       btnConfirmer=findViewById(R.id.btnConfirmer);
        totalPrix=findViewById(R.id.totalPrix);
        titleComande=findViewById(R.id.titleComande);
        textNumbre=findViewById(R.id.textNumbre);
        btnAddProduits=findViewById(R.id.btnAddProduits);
        lieu=findViewById(R.id.text_location);
        backbtn=findViewById(R.id.backbtn);
        lieuDeLivrasion=findViewById(R.id.lieuDeLivrasion);


        // get values from Confirmer demande activity
        Bundle bundle =getIntent().getExtras();
        int value= bundle.getInt("cont");
        int valueprix= bundle.getInt("contee");
        String title1=bundle.getString("tittle");
        titleComande.setText(title1+"\n"+" x"+value+" Produits");

        // calculer price total
        int  totloio=value*valueprix+5;
        totalPrix.setText(String.valueOf(totloio));



       // ajouter des produits
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenet=new Intent(getApplicationContext(),Confirmer_Comendes.class);
                startActivity(intenet);
            }
        });

         // get Lieu from the location google map
      //  lieuDeLivrasion.setText(Get_Location.textAdress.getText().toString());

        // chek the numbre phone
        if(textNumbre.getText().length()==0){
            textNumbre.setError("Entre your Phone");
        }

        btnConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textNumbre.length()<10){
                    textNumbre.setError("Entre your Phone");
                }
            }
        });
        btnAddProduits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent i =new Intent(getApplicationContext(), Alpha_Activity.class);
               // startActivity(i);
            }
        });



    }

}