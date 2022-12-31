package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuCroisaants;

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

public class AdapterCroissant extends ArrayAdapter<IteamsPain> {
    private Context mContext;
    private int mResource;
    public AdapterCroissant(@NonNull Context context, int resource, ArrayList<IteamsPain> objetc) {
        super(context, resource,objetc);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition , View convertView, ViewGroup parent){
        String nameCroissant=getItem(possition).getName();
        String priceCroissant=getItem(possition).getPrice();
        String calories = getItem(possition).getCalories();
        String dis= getItem(possition).getDiscription();
        int image = getItem(possition).getImage();
        IteamsPain iteamCroissant = new IteamsPain(nameCroissant,priceCroissant,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView nameCroisssant=convertView.findViewById(R.id.textNomPain);
        TextView priceeCr=convertView.findViewById(R.id.pricePain);

        nameCroisssant.setText(nameCroissant);
        priceeCr.setText(priceCroissant);
        return convertView;
    }
}
