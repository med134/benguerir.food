package com.example.benguerirfood.services.ui.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benguerirfood.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link List_services#newInstance} factory method to
 * create an instance of this fragment.
 */
public class List_services extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public List_services() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Services.
     */
    // TODO: Rename and change types and number of parameters
    public static List_services newInstance(String param1, String param2) {
        List_services fragment = new List_services();
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
    private RecyclerView recyclerView;
    private String data1[],data2[];
    private RatingBar ratingBar;
    private int image[]={R.drawable.restaurant,R.drawable.supermarcher,R.drawable.bakery,R.drawable.autreservices};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_services, container,false);
        recyclerView=v.findViewById(R.id.recyclerView);
        ratingBar=v.findViewById(R.id.serviceRagtinBar);
        data1=getResources().getStringArray(R.array.listServices);
        data2=getResources().getStringArray(R.array.Discription);
        MyAdapter adapter = new MyAdapter(getContext(),data1,data2,image,ratingBar);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}