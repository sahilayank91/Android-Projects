package com.example.root.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    private Button logout;
    public TextView user;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            finish();
            Toast.makeText(Profile.this,"User not Logged in..",Toast.LENGTH_LONG).show();
            startActivity(new Intent(Profile.this,LoginActivity.class));
        }

        FirebaseUser username = firebaseAuth.getCurrentUser();

        user = (TextView)findViewById(R.id.user);
        user.setText(username.getEmail());

        logout  = (Button)findViewById(R.id.lout);
        logout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v== logout){
            firebaseAuth.signOut();
            finish();
            Toast.makeText(Profile.this,"Logging out",Toast.LENGTH_LONG).show();
            startActivity(new Intent(Profile.this,MainActivity.class));
        }

    }
}
