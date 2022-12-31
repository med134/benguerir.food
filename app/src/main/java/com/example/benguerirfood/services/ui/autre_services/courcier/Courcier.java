package com.example.benguerirfood.services.ui.autre_services.courcier;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.benguerirfood.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Courcier extends AppCompatActivity {
    private FloatingActionButton addPic;
    private Button btnConfirmer;
    private Toolbar toolbar;
    private TextView price;
    private EditText editCourcier,depuis,versOu,num;
    private ImageView imagPackeg;
    private Spinner spinner;
    String[] listPackege={"Carton","Dossier","Matiriel","Mobilier","Boîtes"};
    private static final int IMAGE_PIK_CODE=1000;
    private static final int PERMISSION_CODE=1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courcier);
        // identfie les varibale
        toolbar=findViewById(R.id.toolbar);
        addPic=findViewById(R.id.addPic);
        depuis=findViewById(R.id.depuid);
        imagPackeg=findViewById(R.id.imagPackeg);
        versOu=findViewById(R.id.versOu);
        spinner=findViewById(R.id.spinner);
        num=findViewById(R.id.num);
        price=findViewById(R.id.textPrice);
        btnConfirmer=findViewById(R.id.btnConfirmer);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Détails de Package");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),R.layout.my_spinner_iteams,listPackege);
        adapter.setDropDownViewResource(R.layout.my_drop_spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choise=parent.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // setPrice
        btnConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        addPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                        String[] permmisions={Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permmisions,PERMISSION_CODE);
                    }else{
                        pickImageFromGallury();
                    }
                }else {
                    pickImageFromGallury();

                }
            }
        });

    }

    private void pickImageFromGallury() {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PIK_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_DENIED){
                    pickImageFromGallury();
                }else{
                    Toast.makeText(getApplicationContext(),"denied",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode == IMAGE_PIK_CODE){
            imagPackeg.setImageURI(data.getData());
        }
    }


}