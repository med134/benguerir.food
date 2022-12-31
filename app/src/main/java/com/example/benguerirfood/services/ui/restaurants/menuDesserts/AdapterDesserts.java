package com.example.benguerirfood.services.ui.restaurants.menuDesserts;

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

public class AdapterDesserts extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;
    public AdapterDesserts(@NonNull Context context, int resource, ArrayList<IteamsPizza> object) {
        super(context, resource,object);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
        String nameDessert =getItem(possition).getNamee();
        String priceDessert =getItem(possition).getPricee();
        String dis= getItem(possition).getDiscreption();
        String calories = getItem(possition).getDiscreption();
        int image = getItem(possition).getPhoto();
        IteamsPizza iteamsDesserts=new IteamsPizza(nameDessert,priceDessert,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView textNameDessert= convertView.findViewById(R.id.textNomPizza);
        TextView prixDesserts= convertView.findViewById(R.id.price);

        textNameDessert.setText(nameDessert);
        prixDesserts.setText(priceDessert);
        return convertView;
    }
}
