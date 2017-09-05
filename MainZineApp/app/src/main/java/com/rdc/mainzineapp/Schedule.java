package com.rdc.mainzineapp;

/**
 * Created by Sahil on 7/30/2016.
 */
public class Schedule {


    int nid;
    String mech;
    String aero;
    String andro;
    String web;
    String matlab;
    String algo;
    String ic;
    String sensor;
    String electronic;
    String hacking;
    String group_name;
    String differential;
    String arduino;
    String timer;
    String opamp;
    public Schedule(){}

 /*   public Schedule(String group_name,String mech, String andro, String web, String aero, String matlab, String algo, String ic, String sensor, String electronic, String hacking,String differential, String timer, String arduino, String opamp){

        this.group_name= group_name;
        this.mech = mech;
        this.aero = aero;
        this.andro = andro;
        this.web = web;
        this.matlab = matlab;
        this.algo = algo;
        this.ic = ic;
        this.sensor  = sensor;
        this.electronic  = electronic;
        this.hacking=  hacking;
        this.arduino=arduino;
        this.timer =timer;
        this.opamp = opamp;
        this.differential = differential;
    }*/

    public Schedule(int id, String mech, String andro, String web, String aero, String matlab, String algo, String ic, String sensor, String electronic, String hacking){

        this.nid = id;
        this.mech = mech;
        this.aero = aero;
        this.andro = andro;
        this.web = web;
        this.matlab = matlab;
        this.algo = algo;
        this.ic = ic;
        this.sensor  = sensor;
        this.electronic  = electronic;
        this.hacking=  hacking;
    }
    public Schedule(String group_name, String mech, String andro, String web, String aero, String matlab, String algo, String ic, String sensor, String electronic, String hacking){

        this.group_name=group_name;
        this.mech = mech;
        this.aero = aero;
        this.andro = andro;
        this.web = web;
        this.matlab = matlab;
        this.algo = algo;
        this.ic = ic;
        this.sensor  = sensor;
        this.electronic  = electronic;
        this.hacking=  hacking;
    }



    public int getID(){
        return this.nid;

    }

    public void setID(int id){
        this.nid =id;
    }

    public String getGroup_name(){
        return this.group_name;
    }
    public void setGroup_name(String group_name){
        this.group_name = group_name;
    }


    public String getMech(){
        return this.mech;
    }

    public void setMech(String mech){
        this.mech =mech;
    }

    public String getAero(){
        return this.aero;
    }
    public void setAero(String aero){
        this.aero  = aero;
    }

    public String getAndro(){
        return this.andro;

    }

    public void setAndro(String andro){
        this.andro =andro;
    }
    public String getWeb(){
        return this.web;
    }
    public void setWeb(String web){
        this.web  = web;
    }

    public String getMatlab(){
        return this.matlab;
    }
    public void setMatlab(String matlab){
        this.matlab  = matlab;
    }

    public String getAlgo(){
        return this.algo;
    }
    public void setAlgo(String algo){
        this.algo  = algo;
    }

    public String getIc(){
        return this.ic;
    }
    public void setIc(String ic){
        this.ic  = ic;
    }

    public String getSensor(){
        return this.sensor;
    }
    public void setSensor(String sensor){
        this.sensor  = sensor;
    }

    public String getElectronic(){
        return this.electronic;
    }
    public void setElectronic(String electronic){
        this.electronic  = electronic;
    }

    public String getHacking(){
        return this.hacking;
    }
    public void setHacking(String hacking){
        this.hacking  = hacking;
    }

    public String getDifferential(){
        return this.differential;
    }

    public void setDifferential(String differential){
        this.differential =differential;
    }

    public String getArduino(){
        return this.arduino;
    }

    public void setArduino(String arduino){
        this.arduino =arduino;
    }

    public String getTimer(){
        return this.timer;
    }

    public void setTimer(String timer){
        this.timer =timer;
    }

    public String getOpamp(){
        return this.opamp;
    }

    public void setOpamp(String opamp){
        this.opamp =opamp;
    }

}
