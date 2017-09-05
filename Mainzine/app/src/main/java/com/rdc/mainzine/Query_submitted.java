package com.rdc.mainzine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;


public class Query_submitted extends Activity {

    private  final int show_time=2000;
    @Override

        public void onCreate(Bundle SavedInstanceState)
    {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_query_submitted);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent submitted = new Intent(Query_submitted.this,MainActivity.class);
                startActivity(submitted);
                finish();
            }
        },show_time);

    }



    }


