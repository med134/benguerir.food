package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuGateux;

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

public class AdapterGateux extends ArrayAdapter<IteamsPain> {
    private Context mContext;
    private int mResource;
    public AdapterGateux(@NonNull Context context, int resource, ArrayList<IteamsPain> object) {
        super(context, resource,object);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition , View convertView, ViewGroup parent){
        String nameGateuax=getItem(possition).getName();
        String priceGateux=getItem(possition).getPrice();
        String calories = getItem(possition).getCalories();
        String dis= getItem(possition).getDiscription();
        int image = getItem(possition).getImage();
        IteamsPain iteamsPain=new IteamsPain(nameGateuax,priceGateux,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView nameGateux=convertView.findViewById(R.id.textNomPain);
        TextView priceeGateux=convertView.findViewById(R.id.pricePain);

        nameGateux.setText(nameGateuax);
        priceeGateux.setText(priceGateux);
        return convertView;
    }
}
