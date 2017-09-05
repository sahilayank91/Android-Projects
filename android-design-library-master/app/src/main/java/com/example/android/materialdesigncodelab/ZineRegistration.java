package com.example.android.materialdesigncodelab;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Sahil on 6/29/2016.
 */
public class ZineRegistration extends AppCompatActivity{

    EditText name, phone, email, id;
    TextView sol;
    Spinner spinner;
    RadioGroup radioGroup;
    String uname, uphone, uemail,uid, uhosteller, ubranch;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText)findViewById(R.id.stud_name);
        email  =(EditText)findViewById(R.id.stud_email);
        phone = (EditText)findViewById(R.id.stud_phone);
        id =(EditText)findViewById(R.id.college_id);
        spinner  = (Spinner)findViewById(R.id.spinner);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        button = (Button)findViewById(R.id.email_sign_in_button);



        uname = name.getText().toString();  /* these variables are not available to the execute statement inside...which fucked my lot of tym*/
        uemail   =email.getText().toString();
        uphone = phone.getText().toString();
        uid = id.getText().toString();
        ubranch = spinner.getSelectedItem().toString();
        int opt = radioGroup.getCheckedRadioButtonId();

        if(opt==R.id.radio_no){
            uhosteller="No";
        }else{
            uhosteller="Yes";
        }
      final String type ="register";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundWorker backgroundWorker   = new BackgroundWorker(ZineRegistration.this);
                backgroundWorker.execute(type,name.getText().toString(),email.getText().toString(),phone.getText().toString(),id.getText().toString(),ubranch,uhosteller);
            }
        });

    }




    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }
}
