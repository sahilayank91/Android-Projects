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
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NotificationHandler";
    private static final String TABLE_NAME = "notification";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "title";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_DATE = "date";
    private static final String TABLE_NAME_SCHEDULE = "schedule";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_NOTIFICATION_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MESSAGE + " TEXT" +")";



        db.execSQL(CREATE_NOTIFICATION_TABLE);
        Log.e("table creation","Notification table created");
        Log.e("table creation","schedule table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //dropping table on upgrading or if the internet is found again on next startup
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.e("table dropped","notification table dropped");

        //creating a database after dropping if they found it

        onCreate(db);

    }

    void addNotification(Notify notify){

        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues cv  =  new ContentValues();

        cv.put(KEY_NAME,notify.getTitle());
        cv.put(KEY_MESSAGE,notify.getMessage());

        db.insert(TABLE_NAME,null,cv);
        db.close();
    }


    void addSchedule(Schedule schedule){

        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        Log.e("content values","content claues started");

        cv.put("group_name",schedule.getGroup_name());
        cv.put("mechanical",schedule.getMech());
        cv.put("aero",schedule.getAero());
        cv.put("android",schedule.getAndro());
        cv.put("web",schedule.getWeb());
        cv.put("matlab",schedule.getMatlab());
        cv.put("algo",schedule.getAlgo());
        cv.put("ic",schedule.getIc());
        cv.put("sensor",schedule.getSensor());
        cv.put("electronic",schedule.getSensor());
        cv.put("hacking",schedule.getHacking());

        Log.e("Inserting","Inserting...");

        db.insert(TABLE_NAME_SCHEDULE,null,cv);
        db.close();


    }



    Notify notify(int id){

        SQLiteDatabase db  =this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
                                     KEY_NAME, KEY_MESSAGE,KEY_DATE }, KEY_ID + "=?",
                            new String[] { String.valueOf(id) }, null, null, null, null);
             if (cursor != null)
                     cursor.moveToFirst();

                Notify notify = new Notify(Integer.parseInt(cursor.getString(0)),
                                cursor.getString(1), cursor.getString(2),cursor.getString(3));
             // return the notification
               return notify;

    }


    public List<Notify> getAllNotification(){

        List<Notify> notifyList = new ArrayList<Notify>();

        //Selecting all from the Database

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

                SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);



        // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                        do {
                              Notify notify = new Notify();
                               notify.setID(Integer.parseInt(cursor.getString(0)));
                                notify.setTitle(cursor.getString(1));
                                notify.setMessage(cursor.getString(2));
                            // Adding contact to list
                                notifyList.add(notify);
                        } while (cursor.moveToNext());
                  }

            return notifyList;



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
