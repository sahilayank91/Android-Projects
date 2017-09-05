package com.example.android.materialdesigncodelab;

/**
 * Created by Sahil on 5/13/2016.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;


public class Achievements extends AppCompatActivity {
    RecyclerView recyclerView;
    private Achievement_Recycler_View_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.insert(0, new Data("New Movie", "Movie description", R.drawable.ic_assignment_black_24dp));

            }
        });


        List<Data> data = fill_with_data();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new Achievement_Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);





        recyclerView.setLayoutManager(new LinearLayoutManager(this));


//        Modify the DefaultItemAnimator
  RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Create a list of Data objects
    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("GridTech’15, Pragati Maidan, New Delhi", "-Won 1st prize at Students Innovation Pavillion worth of Rs. 1 lakh in the Category Robotic Technology in Inspection of Transmission Lines.\n" +
                "-Won 1st prize at Students Innovation Pavillion worth of Rs. 50 thousand in the Category Smartmeter. ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Blitzschlag 2015, MNIT Jaipur", "-Circuit mania blitz 2015 2nd and 4th position ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Texas Instruments Analog Design Contest’15", "-Project Solar tracker reached finals  ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Kshitij’15 IIT, Kharagpur", "-Won first prize in semi-autonomous event MINEFIELD. \n" +
                "-Won first prize in manual event Skyfall. \n" +
                "-Finalist in manual event Cascade.", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Autodesk 3D Student Design Challenge-2014", "-1st and 3rd position in the Regionals held at Noida \n" +
                "-Won the National Title held at Mumbai \n" +
                "-Presented the design at the Autdoesk Panorama, Held in Shanghai, China-9-13th March'15 ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Projects Approved", "-5 projects were approved by the TEQUIP worth of 2.5 lakh from Malaviya National Institute of Technology(MNIT Jaipur). \n" +
                "-7 projects were approved worth of 42 lakh from Ministry of Micro Small and Medium Enterprises(MSME), Govt. of India. ", R.drawable.ic_bookmark_border_black_24dp));

        data.add(new Data("Blitzschlag 2014, MNIT, Jaipur", "-1st Runner up in Retro Electronics \n" +
                "-1st Runner up in AUTOQUIZ \n" +
                "-1st Runner up in Circuit Biz \n" +
                "-1st Runner Up in CADesign \n" +
                "-4th place in Piezo Alert ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Research Papers", "-Short Term Load Forecasting using Artificial Neural Networks: A State of Art , Author- Jatin Verma \n" +
                "-A robust technique for Detection of P300 signals, Author- Saatvik Shah, Anirudha Kumar \n" +
                "-Classification of mental tasks from EEG data using backtracking search optimization based neural classifier at Neurocomputing, Elsevier \n" +
                "-Group based Swarm evolution algorithm (GSEA) driven mental task classifier at Memetic Computing,Springer \n" +
                "-Paper presentation on \"use of epoxy resin viscous fiber polymer in turbine blades\",IIT ROORKEE \n" +
                "-Designed and fabricated an RC S.P.A.D. Airplane \n" +
                "-Best Paper Award at International Conference on Advances in Computer Engineering and Applications (ICACEA) 2015, IMS Ghaziabad INDIA \n" +
                "-Best Paper Award in 3rd International Conference on \"Advance Trends in Engineering, Technology and Research\" (ICATETR) 2014; 22-24 Dec BKIT, Kota Rajasthan. ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Tech Expo 2014 , MNIT, Jaipur", "-1st prize SmartCopter, Mechanical Category \n" +
                "-1st prize Solar Tracker, Electronics Category \n" +
                "-1st prize Interactive SmartBoard , Computer Science Category\n" +
                "-2nd Prize Bus Lane with Intermittent Priority, Civil Category \n" +
                "-2nd prize Robotic Hand (Robo-Arm) in Open Category ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Miscellaneous", "-Participated in Fusion 360 Hackathon, Tongji University, China \n" +
                "-TATA MOTORS mind rover champion.. pre placement interview to KARSH Tharyani,(2nd year)", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("PREVENTIVE GEAR MAINTANENCE", "-Filed for Patent \n" +
                "-Nominated for Best Innovation Award \n" +
                "-Team Members: Saatvik Shah, Vaibhav Jain, Sanjay Thakur ", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("GridTech’13, Pragati Maidan, New Delhi", "-Organized by Power Grid Corporation of India Ltd. Is an international event in which companies, colleges and institutes present their prototypes for different real-time problems \n" +
                "-Our team was awarded 3rd prize in the competition \n" +
                "-Team Members: Nikhil Jain, Harshit Saxena, Abhishek Gupta, Avinash Baheti, Arush Pratap Singh Rawat", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("INSPIRON","- Won Third Prize in Kshitij, IIT Kharagpur 2014 \n" +
                "-Team Members: Devang Darode, Karsh, Bharat", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("JBiofeedback through electronic Goniometer","- Patent is sought on the concept as well as on the device. Patent application filed in July 2011 by the Malaviya National Institute of Technology, Jaipur, India \n" +
                "-Our team was awarded 3rd prize in the competition \n" +
                "-Team Members: Dr. Rajesh Kumar with Alok Agrawal, Anoop Honnekeri Nagraj, Rohit Saxena", R.drawable.ic_bookmark_border_black_24dp));

        data.add(new Data("Smart Card based Real Time Emission Measurement and Pollution Control Enforcement","-Patent application filed in January 2012 by the Malaviya National Institute of Technology, Jaipur, India \n" +
                "-Nominated for Best Innovation Award \n" +
                "-Team Members: Dr. Rajesh Kumar with Alok Agrawal, Jai Dhariwal, Nirmala Kunwar, Ritika Dhyawala", R.drawable.ic_bookmark_border_black_24dp));

        data.add(new Data("TI- Analog Design Contest 2012","-Five teams took part this year and again cleared the three interim stages of the contest \n" +
                "\n" +
                "Low cost plant fertilizer dispenser aid\n" +
                "\n" +
                "-Team Members:Deenbandhu, Prince Jain, Anshul Khandelwal \n" +
                "\n" +
                "A portable system to prevent tyre bursting\n" +
                "\n" +
                "-Team Members:Hemant Yadav, Deepank, Mayank \n" +
                "\n" +
                "Home Automation \n" +
                "Team Members:Himanshu, Nilesh \n" +
                "\n" +
                "On Line Low cost unbalance Source Identifier\n" +
                "\n" +
                "-Team Members:Bhanu Pratap Singh, Abhishek Gupta, Saurabh agarwal \n" +
                "\n" +
                "Potable Medical Meter\n" +
                "\n" +
                "-Team Members:Umang, Akhil, Dhruv \n" +
                "\n" +
                "Out of 5 teams, one team was selected for paper presentation for the next round at TIIEC Conference, banglore and two other teams were also selected for poster presentation at the very same. The paper has been later published in the IEEE proceedings, Banglore chapter", R.drawable.ic_bookmark_border_black_24dp));

        data.add(new Data("Paper presentation","-On Line Low cost unbalance Source Identifier\n" +
                "\n", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Poster Presentation\n","-Low cost plant fertilizer dispenser aid, A portable system to prevent tyre bursting", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("JUST A TOUCH","-An event organized in IIT-jodhpur during their annual technical function. Our team won First Prize in the competition \n" +
                "-Team Members: Bhanu Pratap Singh, Abhishek Gupta, Avinash Baheti, Nikhil Jain", R.drawable.ic_bookmark_border_black_24dp));
        data.add(new Data("Nexus 2009","Nexus 2009-Nexus is the regional competition of the biggest autonomous bot competition i-NEXUS at IIT-Bombay Techfest. The task was to make two autonomous bots which can coordinate among themselves and pick the boxes placed randomly in the arena and then dispose them off at a dumping site. Our team stood 1st at the regional level", R.drawable.ic_bookmark_border_black_24dp));

        return data;
    }


}