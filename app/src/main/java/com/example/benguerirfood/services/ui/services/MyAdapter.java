package com.example.benguerirfood.services.ui.services;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.autre_services.list_services.ListServices;
import com.example.benguerirfood.services.ui.boulangier.Boulangier;
import com.example.benguerirfood.services.ui.restaurants.Resturants;

import org.jetbrains.annotations.NotNull;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    String data1[],data2[];
    int image[];
    Context context;
    RatingBar ratingBar;

    public MyAdapter( Context context,String[] data1, String[] data2, int[] image,RatingBar ratingBar) {
        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.image = image;
        this.ratingBar=ratingBar;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_services,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.serviceNmae.setText(data2[position]);
        holder.discription.setText(data1[position]);
        holder.imgSrvies.setImageResource(image[position]);
    }
    @Override
    public int getItemCount() {
        return image.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgSrvies;
        TextView discription,serviceNmae;
        RatingBar ratingBar;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgSrvies=itemView.findViewById(R.id.imageRstraunt);
            discription=itemView.findViewById(R.id.textViewTitle);
            serviceNmae=itemView.findViewById(R.id.textViewDisc);
            ratingBar=itemView.findViewById(R.id.serviceRagtinBar);
            linearLayout=itemView.findViewById(R.id.myLinyar);
            itemView.setOnClickListener(this::onClick);
        }
        @Override
        public void onClick(View view) {
        int position=getAdapterPosition();
        if(position == 0){
            Intent intent = new Intent(context, Resturants.class);
            context.startActivity(intent);
        }else if (position==1){

        }else if (position==2){
           Intent intent = new Intent(context, Boulangier.class);
           context.startActivity(intent);
        }else if (position==3){
            Intent intent = new Intent(context, ListServices.class);
            context.startActivity(intent);
           }

        }
    }

}

