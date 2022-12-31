package com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPatssrie;

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

public class AdapterPatissrie extends ArrayAdapter<IteamsPain> {
    private Context mContext;
    private int mResource;
    public AdapterPatissrie(@NonNull Context context, int resource, ArrayList<IteamsPain> objects) {
        super(context, resource,objects);
        mContext=context;
        mResource=resource;
    }
    @NonNull
    @Override
    public View getView(int possition , View convertView, ViewGroup parent){
        String nameCake=getItem(possition).getName();
        String priceCake=getItem(possition).getPrice();
        String calories = getItem(possition).getCalories();
        String dis= getItem(possition).getDiscription();
        int image = getItem(possition).getImage();
        IteamsPain iteamsPain=new IteamsPain(nameCake,priceCake,dis,calories,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView nameeCakee=convertView.findViewById(R.id.textNomPain);
        TextView priceeCakee=convertView.findViewById(R.id.pricePain);

        nameeCakee.setText(nameCake);
        priceeCakee.setText(priceCake);
        return convertView;
    }
}
