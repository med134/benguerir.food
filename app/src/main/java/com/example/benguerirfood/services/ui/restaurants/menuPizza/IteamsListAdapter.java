package com.example.benguerirfood.services.ui.restaurants.menuPizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.benguerirfood.R;

import java.util.ArrayList;

public class IteamsListAdapter extends ArrayAdapter<IteamsPizza> {
    private Context mContext;
    private int mResource;

    public IteamsListAdapter(Context context, int resource, ArrayList<IteamsPizza> objects) {
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition, View convertView , ViewGroup parent){
        String pizzaName=getItem(possition).getNamee();
        String price=getItem(possition).getPricee();
        String dis= getItem(possition).getDiscreption();
        String calories = getItem(possition).getDiscreption();
        int image = getItem(possition).getPhoto();
        IteamsPizza iteams= new IteamsPizza(pizzaName,price,dis,calories,image);

            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
             TextView textpiza= convertView.findViewById(R.id.textNomPizza);
              TextView prix= convertView.findViewById(R.id.price);

              textpiza.setText(pizzaName);
              prix.setText(price);
              return convertView;
    }

}
