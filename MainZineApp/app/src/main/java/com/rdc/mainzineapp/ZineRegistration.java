package com.rdc.mainzineapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
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
public class ZineRegistration extends AppCompatActivity {

    EditText name, phone, email, id;
    TextView sol;
    Spinner spinner,spinnerhostel;
    RadioGroup radioGroup;
    AlertDialog.Builder builder;
    String uname, uphone, uemail,uid;
    static String uhosteller;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name = (EditText) findViewById(R.id.stud_name);
        email = (EditText) findViewById(R.id.stud_email);
        phone = (EditText) findViewById(R.id.stud_phone);
        id = (EditText) findViewById(R.id.college_id);
        spinner = (Spinner) findViewById(R.id.spinner);
        button = (Button) findViewById(R.id.email_sign_in_button);
        spinnerhostel = (Spinner)findViewById(R.id.spinnerhostel);

        uname = name.getText().toString();  /* these variables are not available to the execute statement inside...which fucked my lot of tym*/
        uemail = email.getText().toString();
        uphone = phone.getText().toString();
        uid = id.getText().toString();


        final String type = "register";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundWorker backgroundWorker = new BackgroundWorker(ZineRegistration.this);
                backgroundWorker.execute(type, name.getText().toString(), email.getText().toString(), phone.getText().toString(), id.getText().toString(), spinner.getSelectedItem().toString(),spinnerhostel.getSelectedItem().toString());
                 name.setText("");  /* these variables are not available to the execute statement inside...which fucked my lot of tym*/
                 email.setText("");
                 phone.setText("");
                 id.setText("");
            }
        });

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }
}
