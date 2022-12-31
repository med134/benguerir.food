package com.example.benguerirfood.services.ui.restaurants.list_restaurants;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.fragment.app.Fragment;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.restaurants.menuBerger.BurgerMenu;
import com.example.benguerirfood.services.ui.restaurants.menuDesserts.MenuDesserts;
import com.example.benguerirfood.services.ui.restaurants.menuPanini.MenuPanini;
import com.example.benguerirfood.services.ui.restaurants.menuPizza.PizzaMenu;
import com.example.benguerirfood.services.ui.restaurants.menuSlades.SaladMenu;
import com.example.benguerirfood.services.ui.restaurants.menuTacos.TacosMenu;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Food#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Food extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Food() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Food.
     */
    // TODO: Rename and change types and number of parameters
    public static Food newInstance(String param1, String param2) {
        Food fragment = new Food();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
     private ImageFilterView imaPizza,imgPanini,imgDeserts,imgTacos,imgSalades,imgBurger;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_food, container, false);
        imaPizza=v.findViewById(R.id.imgPizza);
        imgPanini=v.findViewById(R.id.imgPanini);
        imgDeserts=v.findViewById(R.id.imgDeserts);
        imgTacos=v.findViewById(R.id.imgTacos);
        imgSalades=v.findViewById(R.id.imgSalades);
        imgBurger=v.findViewById(R.id.imgBurger);
        imaPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PizzaMenu.class);
                startActivity(intent);
            }
        });

        imgDeserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MenuDesserts.class);
                startActivity(intent);
            }
        });
        imgTacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TacosMenu.class);
                startActivity(intent);
            }
        });
        imgSalades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SaladMenu.class);
                startActivity(intent);
            }
        });
        imgBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BurgerMenu.class);
                startActivity(intent);
            }
        });
        imgPanini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuPanini.class);
                startActivity(intent);
            }
        });
        return  v;
    }
}