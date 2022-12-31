package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuBriouat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;
import com.example.benguerirfood.services.ui.restaurants.confirmer_comendes.Confirme_Boulangie;

import java.util.ArrayList;

public class MenuBriouat extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_briouat);
        listView=findViewById(R.id.listBriouats);


        IteamsPain iteams = new IteamsPain("Prique au poulet","12 DHS","soupe d’huile" +
                " d’olive,café de cumin en poudre," +
                " café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","90 calories",R.drawable.broit_p);
        IteamsPain iteams1 = new IteamsPain("Triangle a la Viande hachée","13 DHS","soupe d’huile d’olive,café " +
                "de cumin en poudre, café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","95 calories",R.drawable.viand);
        IteamsPain iteamss = new IteamsPain("Triangle a la Poulet","13 DHS","soupe d’huile d’olive,café de cumin en poudre," +
                " café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","88 calories",R.drawable.broiat);
        IteamsPain iteams2 = new IteamsPain("Pastilla au Poisson","16 DHS","soupe d’huile d’olive,café de cumin " +
                "en poudre, café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","90 calories",R.drawable.poisson);
        IteamsPain iteams3 = new IteamsPain("Pastila au Poulet","15 DHS","soupe d’huile d’olive,poulet, Quelques pistils de " +
                "safran,café de gingembre moulu, feuilles de pâte à Filo,café de cannelle pour les amandes","94 calories",R.drawable.pastilla_polet);
        IteamsPain iteams5 = new IteamsPain("Mini Pizza Thon","12 DHS","soupe d’huile d’olive,viande hachee, Quelques pistils de" +
                " safran,café de gingembre moulu, feuilles de pâte à Filo,café de cannelle pour les amandes","90 calories",R.drawable.minithon);
        IteamsPain iteams6 = new IteamsPain("Mini Pizza Poulet","15 DHS","soupe d’huile d’olive,café de cumin en poudre, " +
                "café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","80 calories",R.drawable.minipoulet);
        IteamsPain iteams7 = new IteamsPain("Quiche Poulet","13 DHS","soupe d’huile d’olive,café de cumin en poudre, " +
                "café de paprika fort,café de piment de Cayenne,Brins de persil,brochette poulet","95 calories",R.drawable.quiche_poulet);
        IteamsPain iteams8 = new IteamsPain("Quiche Viande Hachée","13 DHS","soupe d’huile d’olive,café de cumin en poudre," +
                " café de paprika fort,café de piment de Cayenne,Brins de persil,viande hacheé","99 calories",R.drawable.quich_hachee);

         // add to list menu
        ArrayList<IteamsPain> list = new ArrayList<>();
        list.add(iteams);
        list.add(iteams1);
        list.add(iteamss);
        list.add(iteams2);
        list.add(iteams3);
        list.add(iteams5);
        list.add(iteams6);
        list.add(iteams7);
        list.add(iteams8);

        AdapterBriouats adapterBriouats=new AdapterBriouats(this,R.layout.list_eatms_pain,list);
        listView.setAdapter(adapterBriouats);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IteamsPain iteamsPain = list.get(i);
                Intent intent= new Intent(MenuBriouat.this, Confirme_Boulangie.class);
                intent.putExtra("photo",String.valueOf(iteamsPain.getImage()));
                intent.putExtra("briouat",iteamsPain.getName());
                intent.putExtra("calores",iteamsPain.getCalories());
                intent.putExtra("descrption",iteamsPain.getDiscription());
                intent.putExtra("price",iteamsPain.getPrice());
                startActivity(intent);
            }
        });

    }
}