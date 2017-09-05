package com.rdc.mainzineapp;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
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

import java.util.ArrayList;
import java.util.List;


public class Projects extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(),R.color.white,getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Set behavior of Navigation drawer
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state

                        int id = menuItem.getItemId();
                        if(id==R.id.nav_home){
                            Intent i  = new Intent(Projects.this,MainActivity.class);
                            startActivity(i);
                        }
                        else if(id==R.id.nav_team_zine){
                            Intent i = new Intent(Projects.this,Team.class);
                            startActivity(i);
                        }else if(id==R.id.nav_about_us){
                            Intent i  = new Intent(Projects.this,AboutUs.class);
                            startActivity(i);
                        }else if(id==R.id.nav_register){
                            Intent i = new Intent(Projects.this,ZineRegistration.class);
                            startActivity(i);
                        }else if(id==R.id.nav_achievement){
                            Intent i  = new Intent(Projects.this,Achievements.class);
                            startActivity(i);
                        }else if(id==R.id.nav_map){

                            Intent i = new Intent(Projects.this,MnitMap.class);
                            startActivity(i);
                        }else if(id==R.id.nav_query){
                            Intent i = new Intent(Projects.this,Query.class);
                            startActivity(i);

                        }else if(id==R.id.nav_workshop) {
                            Intent i = new Intent(Projects.this, Workshop.class);
                            startActivity(i);

                        }else if(id==R.id.nav_project) {
                            Intent i = new Intent(Projects.this, Projects.class);
                            startActivity(i);
                        }else if(id==R.id.nav_contact) {
                            Intent i = new Intent(Projects.this, ContactUs.class);
                            startActivity(i);
                        }else if(id==R.id.nav_faq){
                            Intent i  = new Intent(Projects.this, FAQ.class);
                            startActivity(i);

                        }


                        menuItem.setChecked(true);

                        // TODO: handle navigation

                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });


    }


    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ProjectsContentFragment(), "Projects");

        viewPager.setAdapter(adapter);
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent internetIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.zine.co.in"));
            internetIntent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
            internetIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(internetIntent);
        }else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}



