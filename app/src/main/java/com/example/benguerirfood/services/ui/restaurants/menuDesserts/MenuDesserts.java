package com.example.benguerirfood.services.ui.restaurants.menuDesserts;

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

public class MenuDesserts extends AppCompatActivity {
    private ListView listDesserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_desserts);
        listDesserts=findViewById(R.id.listDesserts);
        IteamsPizza iteamsDesserts = new IteamsPizza("Tarte Au Citron","20 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","200 calories",R.drawable.citrone);
        IteamsPizza iteamsDesserts1 = new IteamsPizza("Tarte Au Fraise","15 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","210 calories",R.drawable.fraise);
        IteamsPizza iteamsDesserts2 = new IteamsPizza("Tarte aux Amandes","25 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","140 calories",R.drawable.amandes);
        IteamsPizza iteamsDesserts4 = new IteamsPizza("Salade Fruits","10 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","280 calories",R.drawable.fruits);
        IteamsPizza iteamsDesserts5 = new IteamsPizza("Panna Cotta","18 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","200 calories",R.drawable.cotta);
        IteamsPizza iteamsDesserts6 = new IteamsPizza("Créme Caramel","30 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","240 calories",R.drawable.caramel);
        IteamsPizza iteamsDesserts7 = new IteamsPizza("Tramisu","20 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","299 calories",R.drawable.tramisu);
        IteamsPizza iteamsDesserts8 = new IteamsPizza("Mouse au Chocolat","24 DH",
                "many confections, such as biscuits,cakes, cookies, custards, gelatins, ice creams, pastries, pies","210 calories",R.drawable.mouse);

        ArrayList<IteamsPizza> list =new ArrayList<>();
        list.add(iteamsDesserts);
        list.add(iteamsDesserts1);
        list.add(iteamsDesserts2);
        list.add(iteamsDesserts4);
        list.add(iteamsDesserts5);
        list.add(iteamsDesserts6);
        list.add(iteamsDesserts7);
        list.add(iteamsDesserts8);

        AdapterDesserts adapterDesserts = new AdapterDesserts(this,R.layout.list_iteams_pizza,list);
        listDesserts.setAdapter(adapterDesserts);
        listDesserts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MenuDesserts.this, Confirmer_Comendes.class);
                IteamsPizza iteams= list.get(i);
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