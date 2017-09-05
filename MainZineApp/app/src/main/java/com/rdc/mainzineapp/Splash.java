package com.rdc.mainzineapp;

/**
 * Created by Sahil on 7/5/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class Splash extends Activity {

    private final int splash_time = 4500;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              /*  if(isNetworkAvailable()){

                    Log.e("Execute","Executing listener");
                    NotificationListener notificationListener  = new NotificationListener(Splash.this);
                    AsyncTask<String, Void, String> result   =  notificationListener.execute("refresh");
                    try {
                        Log.e("json getter","getting json....");
                        String h = result.get().toString();
                        Log.e("json",h);

                        JSONObject jsonObject   = new JSONObject(h);
                        JSONArray jsonArray = jsonObject.optJSONArray("Notification");


                        DatabaseHandler db  = new DatabaseHandler(Splash.this);
                        db.deleteAllContact();
                        Log.d("Insert: ", "Inserting ..");
                        int n;
                      for(n=0;n<jsonArray.length();n++){
                            JSONObject json   = jsonArray.getJSONObject(n);
                            db.addNotification(new Notify(json.optString("title").toString(), json.optString("message").toString()));
                        }




                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                   ScheduleBackgroundWorker scheduleBackgroundWorker   = new ScheduleBackgroundWorker(Splash.this);
                    AsyncTask<String, Void, String> schedule   =  scheduleBackgroundWorker.execute("refresh");

                    String sch = null;
                    try {
                        sch = schedule.get().toString();
                        Log.e("schedule",sch);
                        JSONObject jsonObject   = new JSONObject(sch);
                        JSONArray jsonArray = jsonObject.optJSONArray("schedule");
                        int n;
                        ScheduleDatabaseHandler d  = new ScheduleDatabaseHandler(Splash.this);
                        d.deleteAllSchedule();
                        for(n=0;n<jsonArray.length();n++){
                            JSONObject json   = jsonArray.getJSONObject(n);

                            d.addSchedule(new Schedule(json.optString("group_name").toString(),json.optString("mechanical").toString(),json.optString("android").toString()
                            ,json.optString("web").toString(),json.optString("aero").toString(),json.optString("matlab").toString(),
                            json.optString("algo").toString(),json.optString("ic").toString(),
                                    json.optString("sensor").toString(),json.optString("electronic").toString(),json.optString("hacking").toString()));


                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }




                Intent homepage = new Intent(Splash.this, MainActivity.class);
                startActivity(homepage);
                finish();*/
            }
        }, splash_time);


    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}