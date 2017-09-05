package com.rdc.mainzineapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Sahil on 7/2/2016.
 */
public class NotificationListener extends AsyncTask<String, Void, String> {
    ProgressDialog progressDialog;
    Context context;
    AlertDialog.Builder builder;

    public NotificationListener(Context ctx){
        this.context= ctx;
    }

    public NotificationListener() {

    }


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];

        if(type.equals("refresh")) {


            String notif_url = "http://zine.co.in/json_notification.php";
            try {

                URL url  = new URL(notif_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);



                InputStream inputStream  = httpURLConnection.getInputStream();
                BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(inputStream,"ISO-8859-1"));
                String result="";
                String line;
            Log.e("Background task","Executing background task");
                while((line=bufferedReader.readLine())!=null){
                    result+=line;



                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.e("result",result);
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    public void onPostExecute(String result) {
        try {
            JSONObject jsonObject   = new JSONObject(result);
            JSONArray jsonArray = jsonObject.optJSONArray("Notification");
            int i;


            for(i=0;i<jsonArray.length();i++)
            {

                JSONObject json   = jsonArray.getJSONObject(i);
                Log.w("title",json.optString("title").toString());
                Log.w("message",json.optString("message").toString());


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}