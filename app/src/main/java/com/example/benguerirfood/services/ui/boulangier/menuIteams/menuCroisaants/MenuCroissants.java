package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuCroisaants;

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

public class MenuCroissants extends AppCompatActivity {
  private  ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_croissants);
        listView=findViewById(R.id.listCroissant);

        IteamsPain iteamCroissant0 = new IteamsPain("Croissant Nature","2    DHS","verre de sucre, œufs, verre de huile, " +
                "sachet de sucre vanille, verre de lait tiède,500 g farine","45 calories",R.drawable.croissants);
        IteamsPain iteamCroissant = new IteamsPain("Croissant Au Chocolat","3 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille, verre de lait tiède,500 g farine,poudre chocolat","50 calories",R.drawable.c_chocolat);
        IteamsPain iteamCroissant2 = new IteamsPain("Croissant Au Ctiron","2 DHS","verre de sucre, œufs, verre de huile, " +
                "sachet de sucre vanille, verre de lait tiède,500 g farine,poudre chocolat","50 calories",R.drawable.citronee);
        IteamsPain iteamCroissant3 = new IteamsPain("Pain Suisse","3 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille, verre de lait tiède,500 g farine,poudre chocolat","50 calories",R.drawable.painsuise);
        IteamsPain iteamCroissant4 = new IteamsPain("Brioche aux Amandes","2 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille, soupe de graines de sésame,soupe d'eau de fleur d'oranger","55 calories",R.drawable.b_amande);
        IteamsPain iteamCroissantr = new IteamsPain("Brioche aux Sucre Perlé","2 DHS","verre de sucre, œufs, verre de huile, sachet de sucre vanille," +
                " soupe de graines de sésame,soupe d'eau de fleur d'oranger","50 calories",R.drawable.perl);
        IteamsPain iteamsPain8 = new IteamsPain("Brioche Sesame","2 DHS","verre de sucre, œufs, verre de huile," +
                " sachet de sucre vanille, soupe de graines de sésame,soupe d'eau de fleur d'oranger","45 calories",R.drawable.seasme);
        IteamsPain iteamCroissant5 = new IteamsPain("Donut simple","1 DHS","verre de sucre, œufs, verre de huile,cuillère à soupe de sucre semoule," +
                " sachet de sucre vanille, verre de lait tiède,500 g farine","",R.drawable.donut1);
        IteamsPain iteamCroissant6 = new IteamsPain("Donut Chocolat","2.5 DHS","verre de sucre, œufs, verre de huile,cuillère à soupe de sucre semoule," +
                " sachet de sucre vanille, verre de lait tiède,500 g farine,poudre chocolat","66 calories",R.drawable.d_chocolat);
        IteamsPain iteamCroissant7 = new IteamsPain("Ghriba amandes","2 DHS","verre de sucre, œufs, verre " +
                "de huile,graines de sésame,beurre ramolli,sachet de sucre vanillé","50 calories",R.drawable.ghriba_amande);
        IteamsPain iteamCroissant8 = new IteamsPain("Cigare Louz","3 DHS","verre de sucre,feuilles de pastilla, sachet de sucre vanille, " +
                "verre de lait tiède,500 g farine,poudre chocolat,viande d'agneau hachée, feuilles de menthe ciselées","55 calories",R.drawable.cigareslouz);

        ArrayList<IteamsPain> list= new ArrayList<>();
        list.add(iteamCroissant0);
        list.add(iteamCroissant);
        list.add(iteamCroissant2);
        list.add(iteamCroissant3);
        list.add(iteamCroissant4);
        list.add(iteamCroissantr);
        list.add(iteamsPain8);
        list.add(iteamCroissant5);
        list.add(iteamCroissant6);
        list.add(iteamCroissant7);
        list.add(iteamCroissant8);

        AdapterCroissant adapterCroissant = new AdapterCroissant(this,R.layout.list_eatms_pain,list);
        listView.setAdapter(adapterCroissant);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IteamsPain iteamsPain = list.get(i);
                Intent intent= new Intent(MenuCroissants.this, Confirme_Boulangie.class);
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