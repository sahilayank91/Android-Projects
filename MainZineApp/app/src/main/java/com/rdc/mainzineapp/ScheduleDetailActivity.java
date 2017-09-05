/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rdc.mainzineapp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class ScheduleDetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
    public String[] mech = new String[100];
    public String[] andro = new String[100];
    public String[] aero = new String[100];
    public String[] web = new String[100];
    public String[] matlab = new String[100];
    public String[] algo = new String[100];
    public String[] ic = new String[100];
    public String[] sensor = new String[100];
    public String[] electronics = new String[100];
    public String[] hacking = new String[100];
    public String[] differential = new String[100];
    public String[] timer = new String[100];
    public String[] arduino = new String[100];
    public String[] opamp = new String[100];


    TextView nmech, nandro,naero,nweb,nmatlab,nalgo,nic,nsensor,nelectronics,nhacking,ndifferential,ntimer,narduino,nopamp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));
        collapsingToolbar.setTitle("ZINE");

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);

        ScheduleDatabaseHandler db  = new ScheduleDatabaseHandler(this);
        int count=0;


        List<Schedule> scheduleList = db.getAllSchedule();
        for (Schedule cn : scheduleList) {
            String log = "Id: " + cn.getID() + " ,Mech: " + cn.getMech() + " ,android: " +
                    cn.getAndro() + "aero: " + cn.getAero() + "web" + cn.getWeb() + "matlab" + cn.getMatlab()
                    + "algo" + cn.getAlgo() + "ic" + cn.getIc() + "sensor" + cn.getSensor()
                    + "electronic" + cn.getElectronic() + "hacking" + cn.getHacking() + "differential: " + cn.getDifferential() +
                    "timer: " + cn.getTimer() + "arduino: " + cn.getArduino() + "opamp: " + cn.getOpamp();
            Log.e("Schedule",log);
            mech[count] = cn.getMech().toString();
            andro[count] = cn.getAndro().toString();
            aero[count] = cn.getAero().toString();
            web[count] = cn.getWeb().toString();
            matlab[count] = cn.getMatlab().toString();
            algo[count] = cn.getAlgo().toString();
            ic[count] = cn.getIc().toString();
            sensor[count] = cn.getSensor().toString();
            electronics[count] = cn.getElectronic().toString();
            hacking[count] = cn.getHacking().toString();
          /*  differential[count] =cn.getDifferential().toString();
            timer[count]=cn.getTimer().toString();
            arduino[count]=cn.getArduino().toString();
            opamp[count] = cn.getOpamp().toString();*/
        count++;

        }
         nmech = (TextView) findViewById(R.id.mech);
        nandro =(TextView)findViewById(R.id.andro);
        naero =(TextView)findViewById(R.id.aero);
        nweb =(TextView)findViewById(R.id.web);
        nmatlab =(TextView)findViewById(R.id.matlab);
        nalgo =(TextView)findViewById(R.id.algo);
        nic =(TextView)findViewById(R.id.ic);
        nsensor =(TextView)findViewById(R.id.sensor);
        nelectronics =(TextView)findViewById(R.id.electronics);
        nhacking =(TextView)findViewById(R.id.hacking);
     /*   ndifferential=(TextView)findViewById(R.id.differential_drive);
        ntimer =(TextView)findViewById(R.id.timeric);
        narduino =(TextView)findViewById(R.id.arduino);
        nopamp=(TextView)findViewById(R.id.opamp);*/


        nmech.setText(mech[postion]);
        nandro.setText(andro[postion]);
        naero.setText(aero[postion]);
        nweb.setText(web[postion]);
        nmatlab.setText(matlab[postion]);
        nalgo.setText(algo[postion]);
        nic.setText(ic[postion]);
        nsensor.setText(sensor[postion]);
        nelectronics.setText(electronics[postion]);
        nhacking.setText(hacking[postion]);
/*        ndifferential.setText(differential[postion]);
        ntimer.setText(timer[postion]);
        narduino.setText(arduino[postion]);
        nopamp.setText(opamp[postion]);*/






     /*   String[] placeInterest = resources.getStringArray(R.array.second_year_interest);
        TextView placeInt = (TextView)findViewById(R.id.place_interest);
        placeInt.setText(placeInterest[postion % placeInterest.length]);*/

        Resources resources = getResources();
        TypedArray placePictures = resources.obtainTypedArray(R.array.schedule);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
    }
}
