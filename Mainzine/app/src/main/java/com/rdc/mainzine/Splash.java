package com.rdc.mainzine;


import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.content.Intent;


public class Splash extends Activity {

    private final int splash_time = 3000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homepage = new Intent(Splash.this, MainActivity.class);
                startActivity(homepage);
                finish();
            }
        }, splash_time);


    }

}
