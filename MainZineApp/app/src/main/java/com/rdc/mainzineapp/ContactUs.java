package com.rdc.mainzineapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class ContactUs extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    ImageButton sahil_call, sahil_mail, kriti_call, kriti_mail, akshay_call, akshay_mail, manish_call, manish_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*getting value of the button for call*/
        sahil_call = (ImageButton) findViewById(R.id.call_button);
        kriti_call = (ImageButton) findViewById(R.id.call_button2);
        akshay_call = (ImageButton) findViewById(R.id.call_button3);
        manish_call = (ImageButton)findViewById(R.id.call_button4);


        sahil_mail = (ImageButton) findViewById(R.id.mail_button);
        kriti_mail = (ImageButton) findViewById(R.id.mail_button2);
        akshay_mail = (ImageButton) findViewById(R.id.mail_button3);
        manish_mail =(ImageButton)findViewById(R.id.mail_button4);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);


        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state

                        int id = menuItem.getItemId();
                        if (id == R.id.nav_home) {
                            Intent i = new Intent(ContactUs.this, MainActivity.class);
                            startActivity(i);
                        } else if (id == R.id.nav_team_zine) {
                            Intent i = new Intent(ContactUs.this, Team.class);
                            startActivity(i);
                        } else if (id == R.id.nav_about_us) {
                            Intent i = new Intent(ContactUs.this, AboutUs.class);
                            startActivity(i);
                        } else if (id == R.id.nav_register) {
                            Intent i = new Intent(ContactUs.this, ZineRegistration.class);
                            startActivity(i);
                        } else if (id == R.id.nav_achievement) {
                            Intent i = new Intent(ContactUs.this, Achievements.class);
                            startActivity(i);
                        } else if (id == R.id.nav_map) {

                            Intent i = new Intent(ContactUs.this, MnitMap.class);
                            startActivity(i);
                        } else if (id == R.id.nav_query) {
                            Intent i = new Intent(ContactUs.this, Query.class);
                            startActivity(i);

                        } else if (id == R.id.nav_workshop) {
                            Intent i = new Intent(ContactUs.this, Workshop.class);
                            startActivity(i);

                        } else if (id == R.id.nav_project) {
                            Intent i = new Intent(ContactUs.this, Projects.class);
                            startActivity(i);
                        } else if (id == R.id.nav_contact) {
                            Intent i = new Intent(ContactUs.this, ContactUs.class);
                            startActivity(i);
                        } else if (id == R.id.nav_faq) {
                            Intent i = new Intent(ContactUs.this, FAQ.class);
                            startActivity(i);

                        }
                        menuItem.setChecked(true);

                        // TODO: handle navigation

                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });


        sahil_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Calling at - 9636004841", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9636004841"));
                if (ActivityCompat.checkSelfPermission(ContactUs.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);


            }

        });
        kriti_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Snackbar.make(v,"Calling at - 9828042882", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9828042882"));
                if (ActivityCompat.checkSelfPermission(ContactUs.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);


            }

        });

        akshay_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Calling at - 7790985755", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:7790985755"));
                if (ActivityCompat.checkSelfPermission(ContactUs.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);


            }

        });

        manish_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Calling at - 9766612938", Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:9766612938"));
                if (ActivityCompat.checkSelfPermission(ContactUs.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);


            }

        });


        sahil_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mail at- sahilayank@zine.co.in", Snackbar.LENGTH_LONG).show();
            }
        });

        kriti_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mail at- kritigupta13@zine.co.in", Snackbar.LENGTH_LONG).show();
            }
        });


        akshay_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mail at- kumarakshay@zine.co.in ", Snackbar.LENGTH_LONG).show();
            }
        });

        manish_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Mail at- manishpatki007@zine.co.in ", Snackbar.LENGTH_LONG).show();
            }
        });
    }
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

        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}