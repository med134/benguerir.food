package com.example.benguerirfood.services.ui.restaurants.list_restaurants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;

public class HelperJuices extends RecyclerView.Adapter<HelperJuices.ViewHolder> {
    private Context context;
    int[] listDrink;
    public HelperJuices(Context context, int[] listDrinkse) {
        this.context = context;
        this.listDrink=listDrinkse;
    }

    @NonNull
    @Override
    public HelperJuices.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.juices_layout,parent,false);
        return new HelperJuices.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HelperJuices.ViewHolder holder, int position) {
        holder.imageView.setImageResource(listDrink[position]);

    }

    @Override
    public int getItemCount() {
        return listDrink.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_juices);
        }
    }
}
