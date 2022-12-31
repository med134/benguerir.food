package com.example.benguerirfood.services.ui.restaurants.menuBerger;

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

public class BurgerMenu extends AppCompatActivity {
    private ListView listBuerger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_menu);
        listBuerger=findViewById(R.id.listBurger);
        IteamsPizza iteamsBurger = new IteamsPizza("Steak And Cheese","30 DH","A hamburger is a food," +
                " typically considered a sandwich, consisting of one or more cooked patties—usually ground meat, typically beef—may ","199 calories",R.drawable.chesse);
        IteamsPizza iteamsBurger1 = new IteamsPizza("Chiken And Cheese","25 DH","Steak And CheeseA hamburger is a food typically considered a sandwich, " +
                "consisting of one or more cooked patties—usually ground meat, typically beef—may","199 calories",R.drawable.chesse);
        IteamsPizza iteamsBurger3=new IteamsPizza("WHOPPER","28 DH","A hamburger is a food, typically considered a sandwich, consisting of one or more" +
                "cooked patties—usually ground meat, typically beef—may","199 calories",R.drawable.whopeer);
        IteamsPizza iteamsBurger2 = new IteamsPizza("DOUBLE WHOPPER","35 DH","A hamburger is a food, typically considered a sandwich, consisting" +
                "of one or more cooked patties—usually ground meat, typically beef—may","199 calories",R.drawable.douebl);




        ArrayList<IteamsPizza> listBurger = new ArrayList<>();
        listBurger.add(iteamsBurger);
        listBurger.add(iteamsBurger1);
        listBurger.add(iteamsBurger3);
        listBurger.add(iteamsBurger2);

        AdapterBurger adapterBurger = new AdapterBurger(this,R.layout.list_iteams_pizza,listBurger);
        listBuerger.setAdapter(adapterBurger);
        listBuerger.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BurgerMenu.this, Confirmer_Comendes.class);
                IteamsPizza iteams = listBurger.get(i);
                intent.putExtra("myImagepizza",String.valueOf(iteams.getPhoto()));
                intent.putExtra("pizza",iteams.getNamee());
                intent.putExtra("calores",iteams.getCaloriess());
                intent.putExtra("descrption",iteams.getDiscreption() );
                intent.putExtra("price",iteams.getPricee());
                startActivity(intent);
            }
        });
    }
}