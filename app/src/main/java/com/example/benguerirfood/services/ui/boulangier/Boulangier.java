package com.example.benguerirfood.services.ui.boulangier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.ArrayList;

public class Boulangier extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<IteamsPain> list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boulangier);
        recyclerView=findViewById(R.id.recycleBoulangie);
        list = new ArrayList<>();
        list.add(new IteamsPain("Pain","pain complet ,Harcha ,msemen et plus ecore...",R.drawable.pain_complet));
        list.add(new IteamsPain("Croissants","croissant nature ,chocolat, aux amandes et plus encore..",R.drawable.croissants));
        list.add(new IteamsPain("patisseris","Cake Amlou,Fondant au Chocolat et plus encore...",R.drawable.patisier));
        list.add(new IteamsPain("Briouats","triangle viande hacheé,Brique au poulet et plus encore...",R.drawable.broiat));
        list.add(new IteamsPain("GÂTEAU","gateau d'anniversaire, gateau au chocolat et plus encore..",R.drawable.gateau));
        adapter=new Adapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }






}