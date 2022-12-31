package com.example.benguerirfood.services.ui.restaurants.menuTacos;

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

public class TacosMenu extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacos_menu);
        listView=findViewById(R.id.listTacos);
        IteamsPizza iteamsTacos= new IteamsPizza("Tacos Poulet","20 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","221 calories",R.drawable.tacos);
        IteamsPizza iteamsTacos1= new IteamsPizza("Tacos Tikka","25 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","200 calories",R.drawable.tikka);
        IteamsPizza iteamsTacos2= new IteamsPizza("Tacos Viande Hachée","30 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","240 calories",R.drawable.tacos);
        IteamsPizza iteamsTacos3= new IteamsPizza("Tacos Chawarma","25 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","200 calories",R.drawable.chawarma);
        IteamsPizza iteamsTacos4= new IteamsPizza("Tacos Nuggets","30 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","200 calories",R.drawable.nuggest);
        IteamsPizza iteamsTacos5= new IteamsPizza("Tacos Cordon Blue","35 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","199 calories",R.drawable.cordne);
        IteamsPizza iteamsTacos7= new IteamsPizza("Tacos Mixte","25 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","250 calories",R.drawable.mixtee);
        IteamsPizza iteamsTacos8= new IteamsPizza("Tacos Saucisses","30 DH",
                "Traditional Mexican beef tacos are made with marinated sliced or shredded beef on soft corn tortillas","210 calories",R.drawable.suicce);

        ArrayList<IteamsPizza> listTacos =new ArrayList<>();
        listTacos.add(iteamsTacos);
        listTacos.add(iteamsTacos1);
        listTacos.add(iteamsTacos2);
        listTacos.add(iteamsTacos3);
        listTacos.add(iteamsTacos4);
        listTacos.add(iteamsTacos5);
        listTacos.add(iteamsTacos7);
        listTacos.add(iteamsTacos8);
        AdapterTacos adapterTacos = new AdapterTacos(this,R.layout.list_iteams_pizza,listTacos);
        listView.setAdapter(adapterTacos);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TacosMenu.this, Confirmer_Comendes.class);
                IteamsPizza iteams=listTacos.get(i);
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