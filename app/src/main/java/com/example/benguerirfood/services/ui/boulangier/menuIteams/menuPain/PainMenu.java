package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.confirmer_comendes.Confirme_Boulangie;

import java.util.ArrayList;

public class PainMenu extends AppCompatActivity {
    private ListView listPain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_menu);
        listPain=findViewById(R.id.listPan);

        IteamsPain iteamsPain=new IteamsPain("Pain Complet","1.5 DHS","80 g de farine complète,40 cl d'eau tiède","100 calories",R.drawable.pain_complet);
        IteamsPain iteamsPain1=new IteamsPain("Pain","1 DHS","80 g de farine complète,40 cl d'eau tiède","80 calories",R.drawable.pain_complet);
        IteamsPain iteamsPain2=new IteamsPain("Baguette Simple","1.20 DHS","80 g de farine complète,40 cl d'eau tiède","88 calories",R.drawable.baguette_simple);
        IteamsPain iteamsPain3=new IteamsPain("Baguette Complet","2 DHS","80 g de farine complète,40 cl d'eau tiède","99 calories",R.drawable.b_complet);
        IteamsPain iteamsPain5=new IteamsPain("Baguette sans Sel","2.5 DHS","80 g de farine complète,40 cl d'eau tiède","100 calories",R.drawable.sel);
        IteamsPain iteamsPain6=new IteamsPain("Harcha","2 DHS","semoule fine de blé dur,huile et de beurre fondu mélangés,levure boulangère","100 calories",R.drawable.harcha);
        IteamsPain iteamsPain10=new IteamsPain("Harcha Frommage","3 DHS","semoule fine de blé dur,huile et de beurre fondu mélangés,levure boulangère plus Frommage","120 calories",R.drawable.harcha);
        IteamsPain iteamsPain7=new IteamsPain("Mseman","2 DHS","semoule fine de blé dur,huile et de beurre fondu mélangés,levure boulangère,cuillère à café de sel fin","99 calories",R.drawable.mseman);
        IteamsPain iteamsPain11=new IteamsPain("Msemen Frommage","3 DHS"," semoule fine de blé dur,huile et de beurre fondu mélangés,levure boulangère,cuillère à café de sel fin plus Frommage","120 calories",R.drawable.mseman);
        IteamsPain iteamsPain12=new IteamsPain("Baghrir","2.5 DHS","semoule fine de blé dur,huile et de beurre fondu mélangés,levure boulangère," +
                "cuillère à café de sel fin,sachet de levure chimique","90 calories",R.drawable.baghrir);
        IteamsPain iteamsPain123=new IteamsPain("Baghrir avaec Laasal","3.5 DHS"," semoule fine de blé dur,huile et de beurre fondu mélangés," +
                "levure boulangère,cuillère à café de sel fin,sachet de levure chimique plus Laasal","90 calories",R.drawable.baghrir);
        IteamsPain iteamsPain13=new IteamsPain("Batbout","3 DHS"," semoule fine de blé dur,huile et de " +
                "beurre fondu mélangés,levure boulangère,cuillère à café de sel fin,cuillère à soupe de lait en poudre ","70 calories",R.drawable.batbout);



        ArrayList<IteamsPain> list= new ArrayList<>();
        list.add(iteamsPain);
        list.add(iteamsPain1);
        list.add(iteamsPain2);
        list.add(iteamsPain3);
        list.add(iteamsPain5);
        list.add(iteamsPain6);
        list.add(iteamsPain10);
        list.add(iteamsPain7);
        list.add(iteamsPain11);
        list.add(iteamsPain12);
        list.add(iteamsPain123);
        list.add(iteamsPain13);


        AdapterPain adapterPain = new AdapterPain(this,R.layout.list_eatms_pain,list);
        listPain.setAdapter(adapterPain);
        listPain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(PainMenu.this, Confirme_Boulangie.class);
                IteamsPain items = list.get(i);
                intent.putExtra("photo",String.valueOf(items.getImage()));
                intent.putExtra("briouat",items.getName());
                intent.putExtra("calores",items.getCalories());
                intent.putExtra("descrption",items.getDiscription());
                intent.putExtra("price",items.getPrice());
                startActivity(intent);
            }
        });
    }
}