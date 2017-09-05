package com.rdc.mainzine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Movie> movieList = new ArrayList<>();

    private MoviesAdapter mAdapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);

        prepareMovieData();












        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_aboutus) {
            // Handle the information about the team members of zine
            Intent intro = new Intent(MainActivity.this,Introduction.class);
            startActivity(intro);

        } else if (id == R.id.nav_gallery) {
            Intent g = new Intent(MainActivity.this,ZineGallery.class);
            startActivity(g);

        } else if (id == R.id.nav_team) {
            Intent t = new Intent(MainActivity.this,CardViewActivity.class);
            startActivity(t);
        } else if (id == R.id.nav_project) {
            Intent j = new Intent(MainActivity.this,CardViewActivity.class);
            startActivity(j);

        } else if (id == R.id.nav_workshop) {
            Intent w = new Intent(MainActivity.this,tabslider.class);
            startActivity(w);

        } else if (id == R.id.nav_faq) {
            Intent faq = new Intent(MainActivity.this, zine_faq.class);
            startActivity(faq);
        }else if (id==R.id.nav_achievement){


        }else if(id==R.id.nav_register){
            Intent r  = new Intent(MainActivity.this,Registration.class);
            startActivity(r);

        }else if (id==R.id.nav_query){
            Intent query = new Intent(MainActivity.this, Query.class);
            startActivity(query);

        }else if (id==R.id.nav_map){
            Intent m  = new Intent(MainActivity.this, MnitMap.class);
            startActivity(m);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void prepareMovieData() {
        Movie movie = new Movie("Sahil Ayank", "CSE", "1st year");
        movieList.add(movie);

        movie = new Movie("Md Saif", "EE", "1st year");
        movieList.add(movie);

        movie = new Movie("Ayushi Jain", "ECE", "1st year");
        movieList.add(movie);

        movie = new Movie("Vrinda Agarwal", "CIVIL", "1st year");
        movieList.add(movie);

        movie = new Movie("Ankit Pachauri", "CIVIL", "1st year");
        movieList.add(movie);

        movie = new Movie("Parth Agarwal", "ME", "1st year");
        movieList.add(movie);

        movie = new Movie("Piyush", "ECE", "1st year");
        movieList.add(movie);

        movie = new Movie("Kriti Gupta", "CSE", "1st year");
        movieList.add(movie);

        movie = new Movie("Rashesh S Vagadia", "EE", "1st year");
        movieList.add(movie);

        movie = new Movie("Puru Lokender Singh", "EE", "1st year");
        movieList.add(movie);

      /*  movie = new Movie("", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);
*/
        mAdapter.notifyDataSetChanged();
    }
}



