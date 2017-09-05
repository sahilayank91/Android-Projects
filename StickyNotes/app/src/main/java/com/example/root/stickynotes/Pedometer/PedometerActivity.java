package com.example.root.stickynotes.Pedometer;

/**
 * Created by Sahil on 4/4/17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import com.example.root.stickynotes.R;

public class PedometerActivity extends Activity implements SensorEventListener{

    private TextView xText, yText, zText,steps;
    private Sensor mySensor;
    private int threshold;

    public float currentY = 0;
    public float previousY =  0;
    private float acceleration = 0.00f;
    private SensorManager SM;

    private int numSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo);
        steps =(TextView) findViewById(R.id.numsteps);
        // Create our Sensor Manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        threshold = 10;
        // Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Assign TextView
        xText = (TextView)findViewById(R.id.stepx);
        yText = (TextView)findViewById(R.id.stepy);
        zText = (TextView)findViewById(R.id.stepz);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("Value at X axis : " + event.values[0]);
        yText.setText("Value at Y axis: " + event.values[1]);
        zText.setText("Value at Z axis: " + event.values[2]);

        currentY = event.values[1];
        if(Math.abs(currentY-previousY)>threshold){
            numSteps++;
            steps.setText("The number of steps travelled: " + String.valueOf(numSteps));
        }

        previousY = event.values[1];
    }


}