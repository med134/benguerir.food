package com.example.benguerirfood.services.ui.restaurants.menuPanini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.menuPizza.IteamsPizza;

import java.util.ArrayList;

public class AdapterPanini extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;
    public AdapterPanini(@NonNull Context context, int resource, ArrayList<IteamsPizza> object) {
        super(context, resource,object);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
        String paniniName=getItem(possition).getNamee();
        String pricePanini=getItem(possition).getPricee();
        String dis= getItem(possition).getDiscreption();
        String calories = getItem(possition).getDiscreption();
        int image = getItem(possition).getPhoto();
        IteamsPizza iteams= new IteamsPizza(paniniName,pricePanini,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView textpiza= convertView.findViewById(R.id.textNomPizza);
        TextView prix= convertView.findViewById(R.id.price);
        ImageView imagestar=convertView.findViewById(R.id.imageStar);
        textpiza.setText(paniniName);
        prix.setText(pricePanini);
        return convertView;
    }
}
