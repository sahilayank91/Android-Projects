/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.root.stickynotes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.attr.button;

/**
 * Provides UI for the view with Cards.
 */
public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);
        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       String search = getArguments().getString("string");

        return recyclerView;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public EditText message;
        public EditText name;
        public TextView userid;
        public ImageButton edit;
        public ImageButton delete;
        public Button action;
        public ImageButton share;
        public TextView description;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            message = (EditText) itemView.findViewById(R.id.message);
            name = (EditText) itemView.findViewById(R.id.title);
            edit = (ImageButton) itemView.findViewById(R.id.edit_button);
            userid = (TextView) itemView.findViewById(R.id.user);
            delete = (ImageButton) itemView.findViewById(R.id.delete_button);
            action = (Button) itemView.findViewById(R.id.action_button);
            share = (ImageButton) itemView.findViewById(R.id.share_button);


            final DatabaseHandler db = new DatabaseHandler(itemView.getContext());
            // description = (TextView) itemView.findViewById(R.id.card_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Position: "+ getAdapterPosition(),Toast.LENGTH_SHORT).show();

                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    message.setEnabled(true);
                    name.setEnabled(true);
                    action.setText("SAVE");
                }
            });

            action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String msg = message.getText().toString();
                    String tit = name.getText().toString();

                    Log.e("after pressing save: ", msg + " and " + tit);
                    db.deleteToDo(userid.getText().toString());
                    db.addNotification(new Notify(tit,msg));
                    db.close();
                    Context context = v.getContext();
                    Intent intent = new Intent(context,MainActivity.class);
                    context.startActivity(intent);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    final Context context = v.getContext();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Are you sure, You wanted to make decision");
                    alertDialogBuilder.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Log.e("inside","delete");
                                    db.addTrash(new Trash(name.getText().toString(),message.getText().toString()));
                                    db.deleteToDo(userid.getText().toString());
                                    Context context1 = v.getContext();
                                    Intent intent = new Intent(context,MainActivity.class);
                                    context1.startActivity(intent);

                                }
                            });

                    alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Context context = v.getContext();
                            Toast.makeText(context,"You cancelled the action",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context,MainActivity.class);
                            context.startActivity(intent);
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            });

            delete.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(final View v) {
                    final Context context = v.getContext();
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setMessage("Do you want to permanently delete the data.");
                    alertDialogBuilder.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Log.e("inside", "delete");
                                    db.deleteToDo(userid.getText().toString());
                                    Context context1 = v.getContext();
                                    Intent intent = new Intent(context, MainActivity.class);
                                    context1.startActivity(intent);

                                }
                            });

                    alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Context context = v.getContext();
                            Toast.makeText(context, "You cancelled the action", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                    return false;
                }

            });

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, message.getText().toString());
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, name.getText().toString());
                    context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
                }
            });



        }
    }




    /**
     * Adapter to display recycler view.
     */
    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of Card in RecyclerView.
        private static final int LENGTH = 18;



        public String[] title = new String[100];
        public String[] message = new String[100];
        public String[] date = new String[100];
        public Integer[] id = new Integer[100];

        public int counter;
        public ContentAdapter(Context context) {
            DatabaseHandler db  = new DatabaseHandler(context);
            int count=0;


            List<Notify> notifyList = db.getSearch("My");
            for (Notify cn : notifyList) {
                String log = "Id: "+cn.getId()+" ,Title: " + cn.getTitle() + " ,Message: " +
                        cn.getMessage() ;

                title[count] = cn.getTitle().toString();
                message[count] = cn.getMessage().toString();
                date[count]  = cn.getMessage().toString();
                id[count] = cn.getId();
                // Writing Contacts to log
                Log.d("Notification: ", log);

                count++;
                Log.d("Value of Count", String.valueOf(count));
            }
            counter = count;


            int i;
            for (i=0;title[i]!=null;i++){
                Log.i("title",title[i]);
                Log.i("message",message[i]);
                Log.i("id",String.valueOf(id[i]));

            }

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.message.setText(message[position % 100]);
            holder.name.setText(title[position % 100]);
            holder.userid.setText(id[position %100].toString());

            //  holder.description.setText(title[position % 100]);

        }

        @Override
        public int getItemCount() {
            return counter;
        }



    }


}
