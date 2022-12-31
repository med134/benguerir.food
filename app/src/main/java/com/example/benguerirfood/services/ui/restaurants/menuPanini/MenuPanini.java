package com.example.benguerirfood.services.ui.restaurants.menuPanini;

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

public class MenuPanini extends AppCompatActivity {
    private ListView listPanini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_panini);


        listPanini=findViewById(R.id.listPanini);
        IteamsPizza iteamsPanini = new IteamsPizza("PANINI MIXTE","20 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and Michetti","140 calories",R.drawable.panini);
        IteamsPizza iteamsPanini1 = new IteamsPizza("PANINI POULET","15 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and Michetti","150 calories",R.drawable.panini);
        IteamsPizza iteamsPanini2 = new IteamsPizza("PANINI GOURMENT","20 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and Michetti","130 calories",R.drawable.gourment);
        IteamsPizza iteamsPanini3 = new IteamsPizza("PANINI THON","15 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and Thon","160 calories",R.drawable.thon);
        IteamsPizza iteamsPanini4 = new IteamsPizza("PANINI FERMIER","20 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and poulet","140 calories",R.drawable.fermier);
        IteamsPizza iteamsPanini5 = new IteamsPizza("PANINI VIANDE HACHEE","20 DH","A panini Italian pronunciation panini meaning small bread, bread rolls or panino meaning bread roll is a sandwich made with Italian\n" +
                " bread such as ciabatta, rosetta, and hache","150 calories",R.drawable.hachee);
        ArrayList<IteamsPizza> listPaniniMenu =new ArrayList<>();
        listPaniniMenu.add(iteamsPanini);
        listPaniniMenu.add(iteamsPanini1);
        listPaniniMenu.add(iteamsPanini2);
        listPaniniMenu.add(iteamsPanini3);
        listPaniniMenu.add(iteamsPanini4);
        listPaniniMenu.add(iteamsPanini5);
        AdapterPanini adapter = new AdapterPanini(this,R.layout.list_iteams_pizza,listPaniniMenu);
        listPanini.setAdapter(adapter);
        listPanini.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int possition, long id) {
                Intent intent=new Intent(MenuPanini.this, Confirmer_Comendes.class);
                IteamsPizza items= listPaniniMenu.get(possition);
                intent.putExtra("myImagepizza",String.valueOf(items.getPhoto()));
                intent.putExtra("pizza",items.getNamee());
                intent.putExtra("descrption", items.getDiscreption());
                intent.putExtra("calores",items.getCaloriess());
                intent.putExtra("price",items.getPricee());
                startActivity(intent);
            }
        });

    }
}