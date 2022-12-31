package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.benguerirfood.R;

import java.util.ArrayList;

public class AdapterPain extends ArrayAdapter<IteamsPain> {
    private Context mContext;
    private int mResource;

    public AdapterPain(@NonNull Context context, int resource, ArrayList<IteamsPain> object) {
        super(context, resource,object);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition , View convertView, ViewGroup parent){
        String namePain=getItem(possition).getName();
        String price=getItem(possition).getPrice();
        String calories = getItem(possition).getCalories();
        String dis= getItem(possition).getDiscription();
        int image = getItem(possition).getImage();
        IteamsPain iteamsPain=new IteamsPain(namePain,price,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView nameePain=convertView.findViewById(R.id.textNomPain);
        TextView pricee=convertView.findViewById(R.id.pricePain);

        nameePain.setText(namePain);
        pricee.setText(price);
        return convertView;
    }
}
