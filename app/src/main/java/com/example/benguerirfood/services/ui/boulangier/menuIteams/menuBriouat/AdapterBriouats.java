package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuBriouat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.ArrayList;

public class AdapterBriouats extends ArrayAdapter<IteamsPain> {
    private Context mContext;
    private int mResource;
    public AdapterBriouats(@NonNull Context context, int resource, ArrayList<IteamsPain> object) {
        super(context, resource,object);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition , View convertView, ViewGroup parent){
        String nameBBriouat=getItem(possition).getName();
        String priceBriouat=getItem(possition).getPrice();
        String calories = getItem(possition).getCalories();
        String dis= getItem(possition).getDiscription();
        int image = getItem(possition).getImage();
        IteamsPain iteamsPain=new IteamsPain(nameBBriouat,priceBriouat,calories,dis,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView nameBriuat=convertView.findViewById(R.id.textNomPain);
        TextView priceeBriuat=convertView.findViewById(R.id.pricePain);

        nameBriuat.setText(nameBBriouat);
        priceeBriuat.setText(priceBriouat);
        return convertView;
    }
}
