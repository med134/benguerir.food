package com.example.benguerirfood.services.ui.autre_services.taxi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.ui.autre_services.list_services.ListServices;

public class GetTaxi extends AppCompatActivity {
    private Button btn_confirmer;
    private EditText textPhone,textName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_taxi);
        btn_confirmer=findViewById(R.id.btn_confirmation_taxi);
        textName=findViewById(R.id.text_taxi_name);
        textPhone=findViewById(R.id.numbre_phone_taxi);
        btn_confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textPhone.length() !=10 || textName.length() <4){
                    textName.setError("Entre full name");
                    textPhone.setError("Entrez un numéro de téléphone valide");
                }else{
                   showAlertDiaoge();
                }
            }
        });
    }
    void showAlertDiaoge(){
        LayoutInflater layoutInflater = LayoutInflater.from(GetTaxi.this);
        View view =layoutInflater.inflate(R.layout.secss_alert_taxi,null);
        AlertDialog alertDialog =new AlertDialog.Builder(GetTaxi.this).setView(view).create();
        TextView textMessage=view.findViewById(R.id.textMessage);
        Button buttonOK = view.findViewById(R.id.buttonYes);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetTaxi.this, ListServices.class));
            }
        });
        textMessage.setText("Nous vous contacterons et vous enverrons le taxi le plus proche..  merci !");
        alertDialog.show();
    }
}

