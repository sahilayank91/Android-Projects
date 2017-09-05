package com.rdc.mainzineapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahil on 7/30/2016.
 */
public class ScheduleDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ScheduleHandler";
    private static final String TABLE_NAME = "notification";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME
            = "title";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_DATE = "date";
    private static final String TABLE_NAME_SCHEDULE = "schedule";
    private static final String KEY_MECH = "mechanical";
    private static final String KEY_ANDRO = "android";
    private static final String KEY_WEB = "web";
    private static final String KEY_AERO = "aero";
    private static final String KEY_MATLAB = "matlab";
    private static final String KEY_ALGO = "algo";
    private static final String KEY_IC = "ic";
    private static final String KEY_SENSOR = "sensor";
    private static final String KEY_ELECTRO = "electronic";
    private static final String KEY_HACK = "hacking";
    private static final String KEY_GROUP = "group_name";
    private static final String KEY_DIFFER= "differential";
    private static final String KEY_ARDUINO = "arduino";
    private static final String KEY_TIMER = "timer";
    private static final String KEY_OPAMP = "opamp";







    public ScheduleDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTIFICATION_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MESSAGE + " TEXT" +")";

        String CREATE_SCHEDULE_TABLE = "CREATE TABLE " + TABLE_NAME_SCHEDULE +"(" +
                "  `group_name` varchar(255) NOT NULL,\n" +
                "  `mechanical` varchar(255) NOT NULL,\n" +
                "  `android` varchar(255) NOT NULL,\n" +
                "  `web` varchar(255) NOT NULL,\n" +
                "  `aero` varchar(255) NOT NULL,\n" +
                "  `matlab` varchar(255) NOT NULL,\n" +
                "  `algo` varchar(255) NOT NULL,\n" +
                "  `ic` varchar(255) NOT NULL,\n" +
                "  `sensor` varchar(255) NOT NULL,\n" +
                "  `electronic` varchar(255) NOT NULL,\n" +
                "  `hacking` varchar(255) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ")";

        String CREATE_SCHEDULE ="CREATE TABLE " + TABLE_NAME_SCHEDULE +"("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_GROUP + " TEXT,"
                + KEY_MECH + " TEXT,"
                + KEY_ANDRO + " TEXT,"
                + KEY_WEB + " TEXT,"
                + KEY_AERO + " TEXT,"
                + KEY_MATLAB + " TEXT,"
                + KEY_ALGO + " TEXT,"
                + KEY_IC + " TEXT,"
                + KEY_SENSOR + " TEXT,"
                + KEY_ELECTRO +  " TEXT,"
                + KEY_HACK + " TEXT "
               /* + KEY_DIFFER + " TEXT,"
                + KEY_TIMER + " TEXT,"
                + KEY_ARDUINO + " TEXT,"
                + KEY_OPAMP + " TEXT"*/

                +")";

        db.execSQL(CREATE_SCHEDULE);
        Log.e("table creation","schedule table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //dropping table on upgrading or if the internet is found again on next startup
        db.execSQL("DROP TABLE " + TABLE_NAME_SCHEDULE);
        Log.e("table dropped","notification table dropped");

        //creating a database after dropping if they found it

        onCreate(db);

    }



    void addSchedule(Schedule schedule){

        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        Log.e("content values","content claues started");

        cv.put(KEY_GROUP,schedule.getGroup_name());
        cv.put(KEY_MECH,schedule.getMech());
        cv.put(KEY_AERO,schedule.getAero());
        cv.put(KEY_ANDRO,schedule.getAndro());
        cv.put(KEY_WEB,schedule.getWeb());
        cv.put(KEY_MATLAB,schedule.getMatlab());
        cv.put(KEY_ALGO,schedule.getAlgo());
        cv.put(KEY_IC,schedule.getIc());
        cv.put(KEY_SENSOR,schedule.getSensor());
        cv.put(KEY_ELECTRO,schedule.getSensor());
        cv.put(KEY_HACK,schedule.getHacking());
      /*  cv.put(KEY_DIFFER,schedule.getDifferential());
        cv.put(KEY_TIMER,schedule.getTimer());
        cv.put(KEY_ARDUINO,schedule.getArduino());
        cv.put(KEY_OPAMP,schedule.getOpamp());
*/
        Log.e("Inserting","Inserting...");

        db.insert(TABLE_NAME_SCHEDULE,null,cv);
        db.close();


    }








    public List<Schedule> getAllSchedule(){

        List<Schedule> scheduleList  = new ArrayList<Schedule>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME_SCHEDULE;

        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){

            do{
                Schedule schedule = new Schedule();

                schedule.setID(Integer.parseInt(cursor.getString(0)));
                schedule.setGroup_name(cursor.getString(1));
                schedule.setMech(cursor.getString(2));
                schedule.setAndro(cursor.getString(3));
                schedule.setWeb(cursor.getString(4));
                schedule.setAero(cursor.getString(5));
                schedule.setMatlab(cursor.getString(6));
                schedule.setAlgo(cursor.getString(7));
                schedule.setIc(cursor.getString(8));
                schedule.setSensor(cursor.getString(9));
                schedule.setElectronic(cursor.getString(10));
                schedule.setHacking(cursor.getString(11));
            /*    schedule.setDifferential(cursor.getString(12));
                schedule.setTimer(cursor.getString(13));
                schedule.setArduino(cursor.getString(14));
                schedule.setOpamp(cursor.getString(15));*/

                scheduleList.add(schedule);

            }while(cursor.moveToNext());
        }


        return scheduleList;
    }

    public int getNotificationsCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    public void deleteAllContact(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from " + TABLE_NAME);


    }
    public void deleteAllSchedule(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from " + TABLE_NAME_SCHEDULE);


    }

}
