package com.rdc.mainzineapp;

/**
 * Created by Sahil on 7/30/2016.
 */
public class Notify {


    int nid;
    String ntitle;
    String nmessage;
    String ndate;
    public Notify(){}

    public Notify(String title, String message){
        this.ntitle = title;
        this.nmessage = message;
    }

    public Notify(int id, String title, String message){
        this.ntitle = title;
        this.nmessage = message;
        this.nid = id;
    }
    public Notify(String title, String message, String date){
        this.ntitle = title;
        this.nmessage=message;
        this.ndate=date;
    }

    public Notify(int id, String title, String message, String date){
        this.ntitle = title;
        this.nmessage=message;
        this.nid = id;
        this.ndate=date;
    }


    public int getId(){
        return this.nid;

    }

    public void setID(int id){
     this.nid =id;
    }

    public String getTitle(){
        return this.ntitle;
    }

    public void setTitle(String title){
        this.ntitle =title;
    }

    public String getMessage(){
        return this.nmessage;
    }
    public void setMessage(String message){
        this.nmessage  = message;
    }

    public String getDate(){
        return this.ndate;

    }

    public void setDate(String date){
        this.ndate =date;
    }



}
