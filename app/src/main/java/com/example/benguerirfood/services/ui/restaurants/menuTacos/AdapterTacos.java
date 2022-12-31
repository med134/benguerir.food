package com.example.benguerirfood.services.ui.restaurants.menuTacos;

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

public class AdapterTacos  extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;
    public AdapterTacos(Context context, int resource, ArrayList<IteamsPizza> objects) {
        super(context, resource,objects);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
        String tacosName=getItem(possition).getNamee();
        String priceTacos=getItem(possition).getPricee();
        String dis= getItem(possition).getDiscreption();
        String calories = getItem(possition).getDiscreption();
        int image = getItem(possition).getPhoto();
        IteamsPizza iteams= new IteamsPizza(tacosName,priceTacos,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tacos= convertView.findViewById(R.id.textNomPizza);
        TextView priceTax= convertView.findViewById(R.id.price);
        tacos.setText(tacosName);
        priceTax.setText(priceTacos);
        return convertView;
    }
}
