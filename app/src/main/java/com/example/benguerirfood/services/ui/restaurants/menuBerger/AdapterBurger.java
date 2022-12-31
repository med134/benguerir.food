package com.example.benguerirfood.services.ui.restaurants.menuBerger;

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

public class AdapterBurger extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;
    public AdapterBurger(@NonNull Context context, int resource, ArrayList<IteamsPizza> objetc) {
        super(context, resource,objetc);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
        String buergerName=getItem(possition).getNamee();
        String priceBurger=getItem(possition).getPricee();
        String discreption = getItem(possition).getDiscreption();
        String calories = getItem(possition).getCaloriess();
        int image =getItem(possition).getPhoto();
        IteamsPizza iteams= new IteamsPizza(buergerName,priceBurger,discreption,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView buerger= convertView.findViewById(R.id.textNomPizza);
        TextView prix= convertView.findViewById(R.id.price);

        buerger.setText(buergerName);
        prix.setText(priceBurger);
        return convertView;
    }
}
