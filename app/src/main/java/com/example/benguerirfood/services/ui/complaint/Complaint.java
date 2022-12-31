package com.example.benguerirfood.services.ui.complaint;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.benguerirfood.R;
import com.example.benguerirfood.services.Services;


public class Complaint extends Fragment{
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Button button;
    private TextView textView;
    private EditText editText_phone,text_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_complaint, container, false);

        button=v.findViewById(R.id.getComplaint);
        radioGroup=v.findViewById(R.id.radioGroup1);

        textView=v.findViewById(R.id.text42);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()==-1){
                    showWarningDialog();
                }else{
                   showAlertDiaoge1();
                }
            }
        });
        return v;
    }
    void showAlertDiaoge1(){
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view =layoutInflater.inflate(R.layout.alert_phone_complaint,null);
        AlertDialog alertDialog =new AlertDialog.Builder(getActivity()).setView(view).create();
        Button buttonOK = view.findViewById(R.id.buttonYes);
        editText_phone=view.findViewById(R.id.text_phone);
        text_name=view.findViewById(R.id.text_phone_name);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_name.requestFocus();
              if(editText_phone.length() != 10 || text_name.length() <7){
                  editText_phone.setError("Entre phone numbre please");
                  text_name.setError("Enter full name");
              }else {
                  showAlertDiaoge2();
              }
            }
        });
        alertDialog.show();
    }
    void showAlertDiaoge2(){
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view =layoutInflater.inflate(R.layout.secsusfely_alert_dialoge,null);
        AlertDialog alertDialog =new AlertDialog.Builder(getActivity()).setView(view).create();
        TextView buttonOK = view.findViewById(R.id.btn_yes);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Services.class));
            }
        });
        alertDialog.show();
    }
    private void showWarningDialog(){
        LayoutInflater inflater= LayoutInflater.from(getActivity());
        View view =inflater.inflate(R.layout.alert_warning,null);
        Button button_yes=view.findViewById(R.id.buttonYes);
        AlertDialog builder = new AlertDialog.Builder(getActivity()).setView(view).create();
        TextView text_title =view.findViewById(R.id.textTitle);
        TextView text_mesage=view.findViewById(R.id.textMessage);
        button_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               builder.dismiss();
            }
        });
        text_title.setText("WARNING MESSAGE");
        text_mesage.setText("Please chose your problem comlplaint !");
        button_yes.setText("OK");
        builder.show();


       }
}
