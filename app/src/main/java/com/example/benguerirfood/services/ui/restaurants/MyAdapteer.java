package com.example.benguerirfood.services.ui.restaurants;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;
import com.example.benguerirfood.services.ui.restaurants.list_restaurants.List_restaurants;

import java.util.List;

public class MyAdapteer extends RecyclerView.Adapter<MyAdapteer.ViewHolder>  {
   private Context context;
   private List<IteamsPain> list_restaurant;



    public MyAdapteer(Context context, List<IteamsPain> list_restaurant) {
        this.context = context;
        this.list_restaurant = list_restaurant;

    }
    public void setList_restaurant(List<IteamsPain> list_restaurant1){
        this.list_restaurant=list_restaurant1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_restaurants,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textTitle.setText(list_restaurant.get(position).getName());
        holder.menuText.setText(list_restaurant.get(position).getDiscription());
        holder.imageView.setImageResource(list_restaurant.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list_restaurant.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textTitle,menuText;
        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle =itemView.findViewById(R.id.title1);
            menuText =itemView.findViewById(R.id.menutext);
            imageView=itemView.findViewById(R.id.imageRstraunt);
            cardView=itemView.findViewById(R.id.mycard);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            if (position==0){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 1){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.goldenpalmimag);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 2){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.imagenoisiite);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
            if (position == 3){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.imagenoisiite);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 4){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.coincourmandimage);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 5){
                Intent intent= new Intent(context, List_restaurants.class);
                 intent.putExtra("med",R.drawable.napoliimage);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 6){
                Intent intent= new Intent(context, List_restaurants.class);
               // intent.putExtra("med",R.drawable.bellaromaimag);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 7){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.bellaromaimag);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }if (position == 8){
                Intent intent= new Intent(context, List_restaurants.class);
                intent.putExtra("med",R.drawable.swidiimage);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }



        }
    }
}
