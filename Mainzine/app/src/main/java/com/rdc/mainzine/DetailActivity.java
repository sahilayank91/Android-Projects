package com.rdc.mainzine;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sahil on 5/20/2016.
 */
public class DetailActivity extends AppCompatActivity {

    public  static final String EXTRA_POSITION="position";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //set collapsing toolbar layout to the screen

        CollapsingToolbarLayout collapsingToolbar=
                (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        //set title of detail page
        // collapsing toolbar.settitle(getString(Rstring.itrm_title));

        int pos= getIntent().getIntExtra(EXTRA_POSITION,0);
        Resources resources= getResources();
        String[] name= resources.getStringArray(R.array.fyname);
        collapsingToolbar.setTitle(name[pos % name.length]);

        String[] description= resources.getStringArray(R.array.fydesc);
        TextView desc= (TextView)findViewById(R.id.person_detail);
        desc.setText(description[pos % description.length]);


        String[] interests= resources.getStringArray(R.array.fyint);
        TextView interest  = (TextView)findViewById(R.id.person_interest);
        interest.setText(interests[pos % interests.length]);

        TypedArray fypictures = resources.obtainTypedArray(R.array.fy_picture);
        ImageView fypic = (ImageView)findViewById(R.id.image);
        fypic.setImageDrawable(fypictures.getDrawable(pos % fypictures.length()));

        fypictures.recycle();


    }
}
