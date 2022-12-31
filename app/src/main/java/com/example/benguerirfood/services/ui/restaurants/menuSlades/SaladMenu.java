package com.example.benguerirfood.services.ui.restaurants.menuSlades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.confirmer_comendes.Confirmer_Comendes;
import com.example.benguerirfood.services.ui.restaurants.menuPizza.IteamsPizza;

import java.util.ArrayList;

public class SaladMenu extends AppCompatActivity {
    private ListView listSalade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_menu);
        listSalade=findViewById(R.id.listSaldes);
        IteamsPizza iteamsSalade =new IteamsPizza("Salde Royale","20 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","50 calories",R.drawable.royale);
        IteamsPizza iteamsSalade2 =new IteamsPizza("Salde Marocaine","20 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","70 calories",R.drawable.saladmaroc);
        IteamsPizza iteamsSalade3 =new IteamsPizza("Salde Neçoise","15 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","90 calories",R.drawable.nesoise);
        IteamsPizza iteamsSalade4 =new IteamsPizza("Salde Mexicaine","25 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","60 calories",R.drawable.mexicanee);
        IteamsPizza iteamsSalade5 =new IteamsPizza("Salde Pécheur","23 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","77 calories",R.drawable.pecher);
        IteamsPizza iteamsSalade6 =new IteamsPizza("Salde De Chef","25 DH","A salad is a dish consisting of mixed pieces of food, typically with at least one raw ingredient","80 calories",R.drawable.salad);
        ArrayList<IteamsPizza> list = new ArrayList<>();
        list.add(iteamsSalade);
        list.add(iteamsSalade2);
        list.add(iteamsSalade3);
        list.add(iteamsSalade4);
        list.add(iteamsSalade5);
        list.add(iteamsSalade6);
        AdapterSalade adapterSalade = new AdapterSalade(this,R.layout.list_iteams_pizza,list);
        listSalade.setAdapter(adapterSalade);
        listSalade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SaladMenu.this, Confirmer_Comendes.class);
                IteamsPizza iteams=list.get(i);
                intent.putExtra("myImagepizza",String.valueOf(iteams.getPhoto()));
                intent.putExtra("pizza",iteams.getNamee());
                intent.putExtra("calores",iteams.getCaloriess());
                intent.putExtra("descrption",iteams.getDiscreption());
                intent.putExtra("price",iteams.getPricee());
                startActivity(intent);
            }
        });

    }
}