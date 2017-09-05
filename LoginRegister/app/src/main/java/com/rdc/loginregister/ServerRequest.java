package com.rdc.loginregister;

import android.app.ProgressDialog;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;
import java.lang.*;
/**
 * Created by Sahil on 3/21/2016.
 */
public class ServerRequest {

    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT=1000*15;
    public static final String="http://www.google.com/";

    public ServerRequest(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait....");


    }

    public void storeUserDataInBackground(User user,GetUserCallback callback){
        progressDialog.show();
        GetUserCallback userCallBack;
        new StoreUserDataAsyncTask(user,userCallBack).execute();

    }


    public void fetchUserDataInBackground(User user,GetUserCallback callback){
        progressDialog.show();
    }


    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void> {

        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback getUserCallback) {

            this.user = user;
            this.userCallback = userCallback;
        }

        @Override
        protected User doInBackground(Void... params) {
            return null;
        }

        protected void onPostExecute(Void aVoid){
            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }
    }
}
