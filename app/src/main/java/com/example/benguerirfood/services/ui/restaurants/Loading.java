package com.example.benguerirfood.services.ui.restaurants;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;

public class Loading extends AppCompatActivity {
    Dialog alertDialog;
    AlertDialog builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_loading);


    }
    @SuppressLint("InflateParams")
    public void starLoading(){
        alertDialog=new Dialog(getApplicationContext());
        LayoutInflater inflater=getLayoutInflater();
        alertDialog.setContentView(inflater.inflate(R.layout.custom_loading,null));
        alertDialog.setCancelable(false);
        alertDialog.create();
        alertDialog.show();
    }
    public void dimmiss(){
        alertDialog.dismiss();
    }
    public void setAlertDialog(){
        AlertDialog.Builder builder= new AlertDialog.Builder(getApplicationContext());
        LayoutInflater inflater=getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_loading,null));
        builder.setCancelable(false);
        builder.create();
        builder.show();

    }






}
