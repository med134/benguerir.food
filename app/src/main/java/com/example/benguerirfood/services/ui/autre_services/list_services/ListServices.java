package com.example.benguerirfood.services.ui.autre_services.list_services;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.ArrayList;

public class ListServices extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<IteamsPain> list ;
    AdapterView adapterView;
    androidx.appcompat.widget.Toolbar tooolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_services);
        tooolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.secondView);
        setSupportActionBar(tooolbar);
        tooolbar.setTitle("List Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list= new ArrayList<>();


        list.add(new IteamsPain("Taxi","Petit Taxi, Grand Taxi...",R.drawable.taxi));
        list.add(new IteamsPain("Coursier","Courcier patrout la ville Benguerir...",R.drawable.courciere));
        list.add(new IteamsPain("Medical","Soins Infirmiers & Pharmacie,Rendez-Vous... ",R.drawable.pharmacy));



        adapterView=new AdapterView(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterView);
    }
}