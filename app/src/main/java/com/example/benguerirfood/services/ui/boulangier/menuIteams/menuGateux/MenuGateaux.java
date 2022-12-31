package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuGateux;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.ArrayList;

public class MenuGateaux extends AppCompatActivity {
      private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gateaux);
        listView=findViewById(R.id.listGateux);

       // IteamsPain iteamsPain = new IteamsPain("");


        ArrayList<IteamsPain> list = new ArrayList<>();



        AdapterGateux adapterGateux = new AdapterGateux(this,R.layout.list_eatms_pain,list);
        listView.setAdapter(adapterGateux);
    }
}