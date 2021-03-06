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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Provides UI for the Detail page with Collapsing Toolbar.
 */
public class WorkshopDetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        // collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.workshop_title);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] placetitle = resources.getStringArray(R.array.workshop_title);
        TextView placetitles = (TextView) findViewById(R.id.place_title);
        placetitles.setText(placetitle[postion % placetitle.length]);

        String[] placetopic = resources.getStringArray(R.array.workshop_topics);
        TextView placetop = (TextView) findViewById(R.id.place_topic);
        placetop.setText(placetopic[postion % placetopic.length]);

        String[] placeContact = resources.getStringArray(R.array.workshop_desc);
        TextView placeinfo = (TextView) findViewById(R.id.place_detail);
        placeinfo.setText(placeContact[postion % placeContact.length]);

        String[] placeDetails = resources.getStringArray(R.array.workshop_members);
        TextView placeDetail = (TextView) findViewById(R.id.place_member);
        placeDetail.setText(placeDetails[postion % placeDetails.length]);

        String[] placeContacts = resources.getStringArray(R.array.workshop_contact);
        TextView placecontact = (TextView) findViewById(R.id.place_contact);
        placecontact.setText(placeContacts[postion % placeDetails.length]);

        String[] placeFuture = resources.getStringArray(R.array.workshop_future);
        TextView future = (TextView) findViewById(R.id.place_future);
        future.setText(placeFuture[postion % placeDetails.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.workshop_pic);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
    }
}
