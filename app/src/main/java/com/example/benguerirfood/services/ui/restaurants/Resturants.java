package com.example.benguerirfood.services.ui.restaurants;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.ArrayList;
import java.util.List;

public  class Resturants extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SearchView searchView;
    private MyAdapteer adapteer;
    private List<IteamsPain> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturants);
        recyclerView= (RecyclerView) findViewById(R.id.recycle);
        searchView=findViewById(R.id.searchView1);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtreText(newText);
                return true;
            }
        });


        list= new ArrayList<>();
        list.add(new IteamsPain("Alpha","Modern Cuisine: Pizza, Tacos, Salades, Panini...",R.drawable.alpha));
        list.add(new IteamsPain("Golden Palm","Pizza, Sandwitch, Tacos, Salades, Panini...",R.drawable.goldenpalm));
        list.add(new IteamsPain("Noisette","Pizza, Sandwitch, Tacos, Salades, Panini...",R.drawable.noisset));
        list.add(new IteamsPain("Snack Brothres","Pizza, Tacos, Salades, Panini, Émincé...",R.drawable.snackbrothres));
        list.add(new IteamsPain("Coin Gourmand","Moderen Cuisine: Pizza, Tacos, Burger...",R.drawable.coingurmeent));
        list.add(new IteamsPain("Napoli","Moderen Cuisine: Pizza, Tacos, Burger ,Émincé...",R.drawable.rty));
        list.add(new IteamsPain("Mac Sola","Pizza, Sandwitch, Tacos, Panini...",R.drawable.macesola));
        list.add(new IteamsPain("Bella Roma","Moderen Cuisine: Pizza, Tacos, Burger...",R.drawable.bellaroma));
        list.add(new IteamsPain("Tacos Swidi","Moderen Cuisine: Pizza, Tacos, Burger...",R.drawable.swidi));
        MyAdapteer adapteer = new MyAdapteer(getApplicationContext(),list);
        recyclerView.setAdapter(adapteer);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list=new ArrayList<>();




        }

    private void filtreText(String text) {
        List<IteamsPain> listRestaurants =new ArrayList<>();
        for (IteamsPain iteamsPain :list){
            if(iteamsPain.getName().toLowerCase().contains(text.toLowerCase())){
                listRestaurants.add(iteamsPain);
            }
        }
        if(listRestaurants.isEmpty()){
            Toast.makeText(this, "no data found", Toast.LENGTH_SHORT).show();
        }else{
             adapteer.setList_restaurant(listRestaurants);
        }
    }

}