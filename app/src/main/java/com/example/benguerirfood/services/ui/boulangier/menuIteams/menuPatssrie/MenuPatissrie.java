package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPatssrie;

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

public class MenuPatissrie extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_patissrie);
        listView=findViewById(R.id.listPatssier);


        IteamsPain item1=new IteamsPain("Cake Tous Chocolat","10 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille,cuillères à soupe de cacao en poudre,crème blanche","70 calories",R.drawable.cake_chocolat);
        IteamsPain item2=new IteamsPain("Cake Au Citron","7 DHS","verre de sucre, œufs," +
                " verre de huile, sachet de sucre vanille,citrons non traités,crème blanche","70 calories",R.drawable.cake_citron);
        IteamsPain item3=new IteamsPain("Cake A La Vanille","9 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille,citrons non traités,crème blanche","70 calories",R.drawable.vanille);
        IteamsPain item4=new IteamsPain("Cake Marbré Au Chocolat","8 DHS","verre de sucre, œufs, verre de huile, ,crème blanche","99 calories",R.drawable.marbe);
        IteamsPain item5=new IteamsPain("Brownie","11 DHS","tasse de cacao en poudre,cuil. à café de bicarbonate de soude, " +
                "chocolat noir à cuire, haché, tasse de sucre en poudre","99 calories",R.drawable.brwnie);
       IteamsPain item6=new IteamsPain("Fondant A Chocolat","16 DHS","tasse de cacao en poudre,cuil" +
               ". à café de bicarbonate de soude, chocolat noir à cuire, haché, tasse de sucre en poudre","77 calories",R.drawable.fondant);
       IteamsPain item7=new IteamsPain("SabLé a la Confiture","7 DHS","tasse de cacao en poudre,cuil, haché, tasse de sucre en poudre,Confiture","70 calories",R.drawable.sable);
        IteamsPain item8=new IteamsPain("Cake Amlou","8 DHS","tasse de cacao en poudre,cuil, haché, tasse de sucre en poudre, amlou","70 calories",R.drawable.amlou);
        IteamsPain item9=new IteamsPain("Opéra Cake","13 DHS","tasse de cacao en poudre,cuil, haché, tasse de sucre en poudre","80 calories",R.drawable.opera);
        IteamsPain item10=new IteamsPain("Mille Feuille","3 DHS","tasse de cacao en poudre,cuil, haché, tasse de sucre en poudre,caramel","99 calories",R.drawable.millefeuille);
        IteamsPain item101=new IteamsPain("Mille Feuille Vanille","5 DHS","tasse de cacao en poudre,cuil, haché, tasse de sucre en poudre, amlou,vanille","90 calories",R.drawable.mallanille);
        // add to list
        ArrayList<IteamsPain> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);
        list.add(item6);
        list.add(item7);
        list.add(item8);
        list.add(item9);
        list.add(item10);
        list.add(item101);
        AdapterPatissrie adapterPatissrie= new AdapterPatissrie(this,R.layout.list_eatms_pain,list);
        listView.setAdapter(adapterPatissrie);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IteamsPain pain = list.get(i);
                Intent intent= new Intent(MenuPatissrie.this, Confirme_Boulangie.class);
                intent.putExtra("photo",String.valueOf(pain.getImage()));
                intent.putExtra("briouat",pain.getName());
                intent.putExtra("calores",pain.getCalories());
                intent.putExtra("descrption",pain.getDiscription());
                intent.putExtra("price",pain.getPrice());
                startActivity(intent);
            }
        });

    }
}