package com.example.benguerirfood.services.ui.restaurants.menuSlades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.menuPizza.IteamsPizza;

import java.util.ArrayList;

public class AdapterSalade extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;
    public AdapterSalade(@NonNull Context context, int resource, ArrayList<IteamsPizza> objet) {
        super(context, resource,objet);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
       String nameSalad =getItem(possition).getNamee();
        String priceSalad =getItem(possition).getPricee();
        String dis= getItem(possition).getDiscreption();
        String calories = getItem(possition).getDiscreption();
        int image = getItem(possition).getPhoto();
        IteamsPizza iteamsSalade = new IteamsPizza(nameSalad,priceSalad,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView textnameSald= convertView.findViewById(R.id.textNomPizza);
        TextView prixSalad= convertView.findViewById(R.id.price);

        textnameSald.setText(nameSalad);
        prixSalad.setText(priceSalad);
        return convertView;
    }
}
