package com.rdc.mainzine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class tabslider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabslider);
    }


    public CharSequence getPageTitle(int position)
    {  switch (position) {
        case 0 :    return "LIST";
        case 1 :    return "CONTACT";
        case 2 :    return "SETTINGS";
        default:    return null;  } }
}
