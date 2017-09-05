package com.rdc.mainzine;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Sahil on 3/26/2016.
 */
public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;
    Activity activity;
    ProgressDialog progressDialog;
    String register_url = "http://10.0.3.2/loginapp/query.php";
    AlertDialog.Builder builder;


    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
        activity = (Activity)ctx;

    }


    @Override
    protected void onPreExecute() {
        builder = new AlertDialog.Builder(activity);
        progressDialog = new ProgressDialog(ctx);
        progressDialog.setTitle("Please Wait..");

        progressDialog.setMessage("Connecting to Server....");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];

        if(method.equals("query"))
        {
            try {

                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String name = params[1];
                String email = params[2];
                String mobile = params[3];
                String query = params[4];
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8") + "&" +
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8") + "&" +
                        URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(mobile,"UTF-8")+ "&" +
                        URLEncoder.encode("que","UTF-8")+"="+URLEncoder.encode(query,"UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line="";

                while((line = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");

                }

                httpURLConnection.disconnect();
                Thread.sleep(5000);
                return stringBuilder.toString().trim();
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String json) {

        try {
            progressDialog.dismiss();

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("server_response");
            JSONObject JO = jsonArray.getJSONObject(0);
            String code = JO.getString("code");
            String message = JO.getString("message");

            if(code.equals("query_true"))
            {
                showDialog("Query Submitted",message,code);
            }

            else if (code.equals("query_false"))
            {
                showDialog("Query Submission Failed",message,code);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void showDialog(String title,String message, String code)
    {
        builder.setTitle(title);
        if(code.equals("query_true")||code.equals("query_false"))
        {
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    activity.finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

