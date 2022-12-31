package com.example.benguerirfood.services.ui.autre_services.list_services;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.autre_services.courcier.Courcier;
import com.example.benguerirfood.services.ui.autre_services.pharmacy.Pharmacy;
import com.example.benguerirfood.services.ui.autre_services.taxi.Taxi;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
        Context context;
        List<IteamsPain> list;

    public AdapterView(Context context, List<IteamsPain> list) {
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mylist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IteamsPain p=list.get(position);
        holder.title.setText(p.getName());
        holder.discrption.setText(p.getDiscription());
        holder.image.setImageResource((p.getImage()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title,discrption;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleX);
            discrption=itemView.findViewById(R.id.dicpX);
             image=itemView.findViewById(R.id.picX);
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            int possition =getAdapterPosition();
            if(possition==0){
                Intent intent = new Intent(context, Taxi.class);
                context.startActivity(intent);
            }else if(possition==1){
                Intent intent = new Intent(context, Courcier.class);
                context.startActivity(intent);
            }else if(possition==2){
                Intent intent = new Intent(context, Pharmacy.class);
                context.startActivity(intent);
            }

        }
    }
}
