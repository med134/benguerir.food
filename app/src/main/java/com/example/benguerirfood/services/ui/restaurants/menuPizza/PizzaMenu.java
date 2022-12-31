package com.example.benguerirfood.services.ui.restaurants.menuPizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.confirmer_comendes.Confirmer_Comendes;

import java.util.ArrayList;

public class PizzaMenu extends AppCompatActivity {
    private ListView listPiza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);
        listPiza=findViewById(R.id.lisPiza);
        IteamsPizza iteams= new IteamsPizza(" Pizza Poulet","35 DH","pizza, dish of" +
                " Italian origin consisting of a flattened ","266 calories",R.drawable.polet);
        IteamsPizza iteams2= new IteamsPizza(" Pizza 4 Saisons","50 DH","pizza, dish of Italian origin" +
                " consisting of a flattened","266 calories",R.drawable.pizza);
        IteamsPizza iteams3= new IteamsPizza("Fruit de Mer","80 DH",
                "pizza, dish of Italian origin consisting of a flattened","240 calories",R.drawable.fruitdemeer);
        IteamsPizza iteams4= new IteamsPizza(" Pizza Royale","40 DH",
                "pizza, dish of Italian origin consisting of a flattened","270 calories",R.drawable.piizax);
        IteamsPizza iteams6= new IteamsPizza(" Pizza Chef","45 DH","pizza, dish of Italian origin consisting of a flattened","190 calories",R.drawable.pizza);
        IteamsPizza iteams7= new IteamsPizza("4 Frommages","45 DH","pizza, dish of Italian origin consisting of a flattened","180 calories",R.drawable.qutre);
        IteamsPizza iteams8= new IteamsPizza("Pizza Thon","25 DH","pizza, dish of Italian origin consisting of a flattened","200 calories",R.drawable.pizza);
        IteamsPizza iteams9= new IteamsPizza("Pizza Viande Hachée","45 DH","pizza, dish of Italian origin consisting of a flattened","199 calories",R.drawable.viande);
        IteamsPizza iteams10= new IteamsPizza("Pizza Pepperoni","50 DH","pizza, dish of Italian origin consisting of a flattened","200 calories",R.drawable.peproni);
        IteamsPizza iteams11= new IteamsPizza("Pizza Jambon Fumé","60 DH","pizza, dish of Italian origin consisting of a flattened","250 calories",R.drawable.peproni);
        IteamsPizza iteams12= new IteamsPizza("Pizza Vegétarienne","26 DH","pizza, dish of Italian origin consisting of a flattened","100 calories",R.drawable.pizza);
        ArrayList<IteamsPizza> listPizae = new ArrayList<>();
        listPizae.add(iteams);
        listPizae.add(iteams2);
        listPizae.add(iteams3);
        listPizae.add(iteams4);
        listPizae.add(iteams6);
        listPizae.add(iteams7);
        listPizae.add(iteams8);
        listPizae.add(iteams9);
        listPizae.add(iteams10);
        listPizae.add(iteams11);
        listPizae.add(iteams12);

       IteamsListAdapter adapter=new IteamsListAdapter(this,R.layout.list_iteams_pizza,listPizae);
       listPiza.setAdapter(adapter);
       listPiza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(PizzaMenu.this, Confirmer_Comendes.class);
               IteamsPizza pizza=listPizae.get(i);
               intent.putExtra("myImagepizza",String.valueOf(pizza.getPhoto()));
               intent.putExtra("pizza",pizza.getNamee());
               intent.putExtra("calores",pizza.getCaloriess());
               intent.putExtra("descrption",pizza.getDiscreption());
               intent.putExtra("price",pizza.getPricee());
               startActivity(intent);
           }
       });

    }

}