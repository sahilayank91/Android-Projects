package com.rdc.mainzineapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

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
 * Created by Sahil on 6/26/2016.
 */
public class BackgroundWorker extends AsyncTask<String, Void,String> {

    Context context;
    AlertDialog.Builder builder;


    public BackgroundWorker(Context ctx){
        this.context= ctx;
    }


    ProgressDialog progressDialog;



    @Override
    protected String doInBackground(String... params) {
        String type = params[0];


      /*  String login_url = "http://10.0.3.2/register.php";*/

        String login_url = "http://zine.co.in/register.php";
        if(type.equals("register")){

            try {
                String name  = params[1];
                String email = params[2];
                String mobile = params[3];
                String id= params[4];
                String branch= params[5];
                String hosteller = params[6];


                URL url  = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream  = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data= URLEncoder.encode("name","UTF-8")+"="+ URLEncoder.encode(name,"UTF-8")+"&"
                        + URLEncoder.encode("email","UTF-8")+"="+ URLEncoder.encode(email,"UTF-8")+"&"
                        + URLEncoder.encode("id","UTF-8")+"="+ URLEncoder.encode(id,"UTF-8")+"&"
                        + URLEncoder.encode("mobile","UTF-8")+"="+ URLEncoder.encode(mobile,"UTF-8")+"&"
                        + URLEncoder.encode("branch","UTF-8")+"="+ URLEncoder.encode(branch,"UTF-8")+"&"
                        + URLEncoder.encode("hosteller","UTF-8")+"="+ URLEncoder.encode(hosteller,"UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream  = httpURLConnection.getInputStream();
                BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(inputStream,"ISO-8859-1"));
                String result="";
                String line;

                while((line=bufferedReader.readLine())!=null){
                    result+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
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
    protected void onPreExecute() {
       builder = new AlertDialog.Builder(context);
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Please Wait..");

        progressDialog.setMessage("Registering....");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();


    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        builder = new AlertDialog.Builder(context);
        builder.setTitle("Registering.");
        builder.setMessage(result);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
