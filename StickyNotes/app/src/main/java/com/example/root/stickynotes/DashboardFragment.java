package com.example.root.stickynotes;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by root on 31/3/17.
 */

public class DashboardFragment extends Fragment {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.dashboard, container, false);
        Button create =(Button) rootView.findViewById(R.id.create);
        Button calender = (Button) rootView.findViewById(R.id.calender);
        Button important = (Button) rootView.findViewById(R.id.important);








        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View mView = getActivity().getLayoutInflater().inflate(R.layout.popup_dialog, null);
               final EditText title = (EditText) mView.findViewById(R.id.title);
              final EditText message = (EditText) mView.findViewById(R.id.message);

                Button image = (Button) mView.findViewById(R.id.add_image);
                Button save = (Button) mView.findViewById(R.id.action_button);

                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        // Start the Intent
                        startActivityForResult(galleryIntent, 1);
                    }
                });

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg = message.getText().toString();
                        String head = title.getText().toString();

                        Log.i("in main activity :", msg + "   " + head);

                        if (!msg.isEmpty() && !head.isEmpty()) {
                            DatabaseHandler db = new DatabaseHandler(getContext());
                            db.addNotification(new Notify(head, msg));
                            dialog.dismiss();
                            startActivity(new Intent(getContext(), MainActivity.class));
                            db.close();
                        } else {
                            Toast.makeText(getContext(), "Some of the Inputs were not filled.", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });

            }
        });


        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






       return rootView;
    }
}
