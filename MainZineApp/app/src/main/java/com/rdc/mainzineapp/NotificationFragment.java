package com.rdc.mainzineapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Sahil on 7/4/2016.
 */
public class NotificationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

            ContentAdapter adapter = null;
            try {
                adapter = new ContentAdapter(getContext());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
            itemAnimator.setAddDuration(1000);
            itemAnimator.setRemoveDuration(1000);
            recyclerView.setItemAnimator(itemAnimator);
            Log.e("start", "Notification Fragment accessed");

        if(isNetworkAvailable()==false){
            Toast.makeText(getContext(), "Internet Connection Not Detected... " +
                    "Turn on internet for updating notification", Toast.LENGTH_LONG).show();

        }

            return recyclerView;


}


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public TextView name;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            avator = (ImageView) itemView.findViewById(R.id.list_avatar);
            name = (TextView) itemView.findViewById(R.id.list_title);
            description = (TextView) itemView.findViewById(R.id.list_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;

        public String[] title = new String[100];
        public String[] message = new String[100];

        public int counter;
        private final Drawable[] mPlaceAvators;
        public ContentAdapter(Context context) throws ExecutionException, InterruptedException, JSONException {
         /*  progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Refreshing...");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
            NotificationListener notificationListener  = new NotificationListener();
           AsyncTask<String, Void, String> result   =  notificationListener.execute("refresh");
           String h =  result.get().toString();
            Log.w("ddddd",h);
            progressDialog.dismiss();
            JSONObject jsonObject   = new JSONObject(h);
            JSONArray jsonArray = jsonObject.optJSONArray("Notification");

            counter =jsonArray.length();
            int n;
            for(n=0;n<jsonArray.length();n++){
                JSONObject json   = jsonArray.getJSONObject(n);
                title[n] = json.optString("title").toString();
                message[n]=json.optString("message").toString();
            }
            */

          DatabaseHandler db  = new DatabaseHandler(context);
            int count=0;

            List<Notify> notifyList = db.getAllNotification();
            for (Notify cn : notifyList) {
                         String log = "Id: "+cn.getId()+" ,Title: " + cn.getTitle() + " ,Message: " +
                                    cn.getMessage() ;

                    title[count] = cn.getTitle().toString();
                    message[count] = cn.getMessage().toString();
                          // Writing Contacts to log
                        Log.d("Notification: ", log);

                        count++;
                        Log.d("Value of Count", String.valueOf(count));


            }

            counter = count;

            Resources resources = context.getResources();
            TypedArray a = resources.obtainTypedArray(R.array.place_avator);
            mPlaceAvators = new Drawable[a.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceAvators[i] = a.getDrawable(i);
            }
            a.recycle();
            int i;
            for (i=0;title[i]!=null;i++){
                Log.i("title",title[i]);
                Log.i("message",message[i]);

            }


        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.avator.setImageDrawable(mPlaceAvators[position % title.length]);
            holder.name.setText(title[position % 100]);
            holder.description.setText(message[position % 100]);
        }

        @Override
        public int getItemCount() {
            return counter;
        }



    }




}
