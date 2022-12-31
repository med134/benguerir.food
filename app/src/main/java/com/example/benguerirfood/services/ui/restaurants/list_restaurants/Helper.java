package com.example.benguerirfood.services.ui.restaurants.list_restaurants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;

public class Helper extends RecyclerView.Adapter<Helper.ViewHolder> {
    private Context context;
     int[] listDrinks;

    public Helper(Context context, int[] listDrinks) {
        this.context = context;
        this.listDrinks=listDrinks;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.drink_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.imageView.setImageResource(listDrinks[position]);
    }


    @Override
    public int getItemCount() {
        return listDrinks.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.phone_image);
        }
    }
}
