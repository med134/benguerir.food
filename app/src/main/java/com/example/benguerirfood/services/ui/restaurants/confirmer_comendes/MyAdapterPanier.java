package com.example.benguerirfood.services.ui.restaurants.confirmer_comendes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.benguerirfood.R;

import java.util.ArrayList;
public class MyAdapterPanier extends RecyclerView.Adapter<MyAdapterPanier.ViewHolder> {
    ArrayList<Iteams> listFoodSelected;
    Context context;

   public MyAdapterPanier( Context context,ArrayList<Iteams> listFoodSelected){
          this.context=context;
          this.listFoodSelected=listFoodSelected;
   }

    @NonNull
    @Override
    public MyAdapterPanier.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.panier_holder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterPanier.ViewHolder holder, int position) {
             holder.title.setText(listFoodSelected.get(position).getName());
             holder.price.setText(listFoodSelected.get(position).getPrice());
             holder.numbreIteam.setText(listFoodSelected.get(position).getContité());
             int drawableId= holder.itemView.getContext().getResources()
                     .getIdentifier(listFoodSelected.get(position).getImage(),
                             "drawable",holder.itemView.getContext().getPackageName());
             Glide.with(holder.itemView.getContext()).load(drawableId).into(holder.pic);




    }
    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private TextView title,price,numbreIteam;
       private ImageView pic,plusItem, minusItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTxet);
            price=itemView.findViewById(R.id.prixt);
            numbreIteam=itemView.findViewById(R.id.incrementProduit);
            plusItem=itemView.findViewById(R.id.plusCardBtn);
            minusItem=itemView.findViewById(R.id.minusCardBtn);
            pic=itemView.findViewById(R.id.image_Panier);
        }
    }
}
