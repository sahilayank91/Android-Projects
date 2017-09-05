package com.rdc.mainzine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Query extends AppCompatActivity {

    String name, email, query;
    EditText user_name,mobile, user_email, user_query;
    Button submit;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        user_name=(EditText)findViewById(R.id.reg_name);
        user_query=(EditText)findViewById(R.id.query);
        user_email = (EditText) findViewById(R.id.reg_email);
        submit = (Button) findViewById(R.id.submit_button);
        mobile =(EditText)findViewById(R.id.phone);
        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if (user_name.getText().toString().equals("") || user_email.getText().toString().equals("") ||mobile.getText().toString().equals("")|| user_query.getText().toString().equals("")) {
                                              builder = new AlertDialog.Builder(Query.this);
                                              builder.setTitle("Something went Wrong..");
                                              builder.setMessage("Please fill all the Fields..");
                                              builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      dialog.dismiss();
                                                  }
                                              });

                                              AlertDialog alertDialog = builder.create();
                                              builder.show();
                                          }
                                          else{
                                              BackgroundTask backgroundTask = new BackgroundTask(Query.this);
                                              backgroundTask.execute("query", user_name.getText().toString(), user_email.getText().toString(),mobile.getText().toString(), user_query.getText().toString());
                                              builder = new AlertDialog.Builder(Query.this);
                                              builder.setTitle("Congratulations...");
                                              builder.setMessage("Query Submitted...");
                                              builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {
                                                        Intent submit=new Intent(Query.this,Query_submitted.class);
                                                      startActivity(submit);
                                                  }
                                              });

                                              AlertDialog alertDialog = builder.create();
                                              alertDialog.show();


                                          }
                                          }






                                      }


                                  );


    }


    }
