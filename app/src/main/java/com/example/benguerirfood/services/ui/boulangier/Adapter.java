package com.example.benguerirfood.services.ui.boulangier;

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
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuBriouat.MenuBriouat;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuCroisaants.MenuCroissants;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuGateux.MenuGateaux;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.IteamsPain;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPain.PainMenu;
import com.example.benguerirfood.services.ui.boulangier.menuIteams.menuPatssrie.MenuPatissrie;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<IteamsPain> iteamsList;
    public Adapter(Context context, List<IteamsPain> iteamsList){
        this.context=context;
        this.iteamsList=iteamsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.boulangier_iteams,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       IteamsPain p =iteamsList.get(position);
       holder.textViewNma.setText(p.getName());
       holder.textprice.setText(p.getDiscription());
       holder.imageView.setImageResource(p.getImage());

    }
    @Override
    public int getItemCount() {
        return iteamsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView imageView;
            private TextView textViewNma,textprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.picee);
            textViewNma=itemView.findViewById(R.id.namePain);
            textprice=itemView.findViewById(R.id.pricePain);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position=getAdapterPosition();
            if (position==0){
                Intent intent = new Intent(context, PainMenu.class);
                context.startActivity(intent);
            }else if(position==1){
                Intent intent = new Intent(context, MenuCroissants.class);
                context.startActivity(intent);
            }else if(position==2){
                Intent intent = new Intent(context, MenuPatissrie.class);
                context.startActivity(intent);
            }else if(position==3){
                Intent intent = new Intent(context, MenuBriouat.class);
                context.startActivity(intent);
            }else if(position==4){
                Intent intent = new Intent(context, MenuGateaux.class);
                context.startActivity(intent);
            }
        }
    }
}
