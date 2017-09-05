package com.example.root.stickynotes;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahil on 7/30/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NotificationHandler";
    private static final String TABLE_NAME = "notification";
    private static final String TABLE_NAME_TRASH = "TrashHandler";
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
                + KEY_MESSAGE + " TEXT" +
                KEY_DATE + "DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";

        String CREATE_TRASH_TABLE  = "CREATE TABLE " + TABLE_NAME_TRASH + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MESSAGE + " TEXT" +
                KEY_DATE + "DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";



        db.execSQL(CREATE_NOTIFICATION_TABLE);
        db.execSQL(CREATE_TRASH_TABLE);
        Log.e("table creation", "Notification table created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //dropping table on upgrading or if the internet is found again on next startup
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_TRASH);
        Log.e("table dropped", "notification table dropped");

        //creating a database after dropping if they found it

        onCreate(db);

    }

    void addNotification(Notify notify) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME, notify.getTitle());
        cv.put(KEY_MESSAGE, notify.getMessage());

        db.insert(TABLE_NAME, null, cv);

        db.close();

        }


    void addTrash(Trash trash) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        Log.e("adding into trash...:",trash.getTitle() + "and"  + trash.getMessage());
        cv.put(KEY_NAME, trash.getTitle());
        cv.put(KEY_MESSAGE, trash.getMessage());
        db.insert(TABLE_NAME_TRASH, null, cv);



    }

    Notify notify(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,
                        KEY_NAME, KEY_MESSAGE, KEY_DATE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Notify notify = new Notify(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return the notification
        return notify;

    }

    Trash trash(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME_TRASH, new String[]{KEY_ID,
                        KEY_NAME, KEY_MESSAGE, KEY_DATE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Trash trash = new Trash(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return the notification
        return trash;

    }


    public List<Notify> getAllNotification() {

        List<Notify> notifyList = new ArrayList<Notify>();

        //Selecting all from the Database

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY id DESC";


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
    public List<Trash> getAllTrash() {

        List<Trash> trashList = new ArrayList<Trash>();

        //Selecting all from the Database

        String selectQuery = "SELECT  * FROM " + TABLE_NAME_TRASH + " ORDER BY id DESC";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Trash trash = new Trash();
                trash.setID(Integer.parseInt(cursor.getString(0)));
                trash.setTitle(cursor.getString(1));
                trash.setMessage(cursor.getString(2));

                // Adding contact to list
                trashList.add(trash);
            } while (cursor.moveToNext());
        }

        return trashList;


    }

    public List<Notify> getSearch(String str) {

        List<Notify> notifyList = new ArrayList<Notify>();

        //Selecting all from the Database

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE "+KEY_NAME + " like %"+ str+"%;";


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


    public int getNotificationsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        Log.d("count",String.valueOf(cursor.getCount()));
        // return count
        return cursor.getCount();
    }

    public void deleteAllTodo() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from " + TABLE_NAME);

        db.close();
    }

    public void deleteAllSchedule() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_NAME_SCHEDULE);
        db.close();
    }

    public void deleteToDo(String id) {
        int uid = Integer.parseInt(id);
        Log.e("Id in deletetodo",id);
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("DELETE FROM "+ TABLE_NAME + " WHERE " + KEY_ID + " = " + uid);
        stmt.execute();
        //getNotificationsCount();
        db.close();
    }

    public void deleteTrash(String id) {
        int uid = Integer.parseInt(id);
        Log.e("Id in deletetodo",id);
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("DELETE FROM "+ TABLE_NAME_TRASH + " WHERE " + KEY_ID + " = " + uid);
        stmt.execute();
        //getNotificationsCount();
        db.close();
    }
}
