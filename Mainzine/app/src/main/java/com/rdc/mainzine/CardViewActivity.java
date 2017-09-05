package com.rdc.mainzine;

/**
 * Created by Sahil on 5/13/2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;


public class CardViewActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(
                new MyRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);


                if(position==0)
                {
                    Intent human = new Intent(CardViewActivity.this,HumanComputerInterface.class);
                    startActivity(human);
                }else if (position==1)
                {
                    Intent bci = new Intent(CardViewActivity.this,BrainComputingInterface.class);
                    startActivity(bci);
                }else if(position==2){
                    Intent quad = new Intent(CardViewActivity.this,AutonomousQuadcopter.class);
                    startActivity(quad);

                }else if(position==3){
                    Intent gait = new Intent(CardViewActivity.this,HomeEnergy.class);
                    startActivity(gait);

                }else if(position==4){
                    Intent gait = new Intent(CardViewActivity.this,GairAnalysis.class);
                    startActivity(gait);

                }
                else if(position==5){
                    Intent malti = new Intent(CardViewActivity.this,MultiActuator.class);
                    startActivity(malti);

                }else if(position==6){
                        Intent vol = new Intent(CardViewActivity.this,VoltageInspection.class);
                    startActivity(vol);
                }else if(position==7){
                    Intent smart = new Intent(CardViewActivity.this,SmartGrid.class);
                    startActivity(smart);

                }else if(position==8){
                    Intent exo = new Intent(CardViewActivity.this,Exoskeleton.class);
                    startActivity(exo);

                }else if(position==9){
                    Intent agas = new Intent(CardViewActivity.this,Agastuti.class);
                    startActivity(agas);

                }else if(position==10){
                    Intent hand = new Intent(CardViewActivity.this,HandGesture.class);
                    startActivity(hand);

                }else if(position==11){
                        Intent sun = new Intent(CardViewActivity.this,SunTracker.class);
                        startActivity(sun);

                }else if(position==12){
                            Intent arm = new Intent(CardViewActivity.this,ProstheticArm.class);
                            startActivity(arm);

                }else if(position==13) {
                    Intent wh = new Intent(CardViewActivity.this, AutonomousWheelchair.class);
                    startActivity(wh);
            }



        }


        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();

        DataObject obj = new DataObject("Human Computer Interface","Team Members-\n Anshul Mittal\n Maitreyee Mehta\n Mihika Gupta\n Sharad Garg");
        results.add(0,obj);


         obj = new DataObject("Brain Computing Interface","Team Members-\n Saurabh Aggarwal\nBhanu Pratap\n Singh Rawat");
        results.add(1,obj);

        obj = new DataObject("Autonomous Quadcopter","Team Members- \nAkash Shah\n" +
                "Anirudha Kumar\n" +
                "Rajat Arya");
        results.add(2,obj);

        obj = new DataObject("Intelligent Home Energy Management System","Team Members- ");
        results.add(3,obj);

        obj = new DataObject("Gait Analysis(Investigating Postural Deviation through Human Gait Pattern Mining Techniques)","Team Members-\nAnshul Mittal\n" +
                "Kanika Gupta ");
        results.add(4,obj);
        obj = new DataObject("Multi Actuator Switch Mode Hydraulic System","Team Members-\nParesh Anand\n" +
                "Piyush Chauhan\n" +
                "Sharad Garg ");
        results.add(5,obj);
        obj = new DataObject("Robotic Technology for High Voltage Line Inspection and Repair","Team Members- \nAkash Shah" +
                "Akshay Kumar\n" +
                "Anirudha Kumar, " +
                "Anshul Mittal\n" +
                "Rajat Arya, " +
                "Sharad Garg");

        results.add(6,obj);

        obj = new DataObject("Smart Grid","Team Members-\nJatin Verma\n" +
                "Akshay Kumar ");
        results.add(7,obj);

        obj = new DataObject("Exoskeleton","Team Members- \nDevang Darode\n" +
                "Sarthak Jain\n" +
                "Ayush Jhalani\n" +
                "Akshay Kumar");
        results.add(8,obj);

        obj = new DataObject("A.G.A.S.T.U.T.I(Autonomous Goods & Services Transport Using Touch Interface)","Team Members-\nDevang Darode\n" +
                "Karsh Tharyani\n" +
                "Ayush Jhalani ");
        results.add(9,obj);

        obj = new DataObject("Hand Gesture Recognition","Team Members-\nKarsh Tharyani \n" +
                "Vishakha Tyagi\n" +
                "Jatin Verma ");
        results.add(10,obj);

        obj = new DataObject("Sun Tracker","Team Members- \nSharad Garg\n" +
                "Anshul Mittal");
        results.add(11,obj);

        obj = new DataObject("Prosthetics Arm","Team Members- ");
        results.add(12,obj);

        obj = new DataObject("AUTONOMOUS WHEELCHAIR","Team Members-\nAkash Shah\n" +
                "Anirudha Kumar\n" +
                "Rajat Arya ");
        results.add(13,obj);

        return results;
    }
}