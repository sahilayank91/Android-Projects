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
public class DetailActivity extends AppCompatActivity {
    String h;
    public static final String EXTRA_POSITION = "position";
    public String[] title = new String[100];
    public String[] message = new String[100];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificatioin);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Log.w("position", String.valueOf(postion));
        Resources resources = getResources();
        collapsingToolbar.setTitle("ZINE");

    /*    NotificationListener notificationListener  = new NotificationListener(this);
        AsyncTask<String, Void, String> result   =  notificationListener.execute("refresh");
        try {
            h =  result.get().toString();
            Log.w("Details",h);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject   = null;
        try {
            jsonObject = new JSONObject(h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = jsonObject.optJSONArray("Notification");
        try {
            JSONObject json = jsonArray.getJSONObject(postion);
            TextView placeDetail = (TextView) findViewById(R.id.placetitle);
            placeDetail.setText(json.optString("title").toString());
            TextView placeLocation =  (TextView) findViewById(R.id.place_message);
            if (placeLocation != null) {
                placeLocation.setText(json.optString("message").toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
*/


        DatabaseHandler db  = new DatabaseHandler(this);
        int count=0;

        List<Notify> notifyList = db.getAllNotification();
        for (Notify cn : notifyList) {
            String log = "Id: "+cn.getId()+" ,Title: " + cn.getTitle() + " ,Message: " +
                    cn.getMessage() + "Date: " + cn.getDate();

            title[count] = cn.getTitle().toString();
            message[count] = cn.getMessage().toString();

            // Writing Contacts to log
            Log.d("Notification: ", log);

            count++;
            Log.d("Value of Count", String.valueOf(count));


        }

        TextView placeDetail = (TextView) findViewById(R.id.placetitle);
        placeDetail.setText(title[postion]);

        TextView placeLocation =  (TextView) findViewById(R.id.place_message);
        placeLocation.setText(message[postion]);


        TypedArray placePictures = resources.obtainTypedArray(R.array.places_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();



    }
}
