package com.example.jonas.wetter;

import java.util.ArrayList;

public class URLProvider {
    private static URLProvider instance;
    private ArrayList<String> tempUrls;
    private ArrayList<String> tempDateStrings;
    private ArrayList<String> precipUrls;
    private ArrayList<String> precipDateStrings;
    private ArrayList<String> cloudUrls;
    private ArrayList<String> cloudDateStrings;
    private ArrayList<String> wetterkartenUrls;


    private URLProvider(){
        tempUrls = new ArrayList<String>();
        tempDateStrings = new ArrayList<String>();
        precipUrls = new ArrayList<String>();
        precipDateStrings = new ArrayList<String>();
        cloudUrls = new ArrayList<String>();
        cloudDateStrings = new ArrayList<String>();
        wetterkartenUrls = new ArrayList<String>();


    }

    public void refresh(){
        new FetchUrlsAsyncTask().execute();
    }

    public void setTempUrls(ArrayList<String> tempUrls) {
        this.tempUrls = tempUrls;
    }

    public ArrayList<String> getTempUrls() {
        return tempUrls;
    }

    public void setTempDateStrings(ArrayList<String> tempDateStrings) {
        this.tempDateStrings = tempDateStrings;
    }

    public ArrayList<String> getTempDateStrings() {
        return tempDateStrings;
    }

    public void setCloudUrls(ArrayList<String> cloudUrls) {
        this.cloudUrls = cloudUrls;
    }

    public ArrayList<String> getCloudUrls() {
        return cloudUrls;
    }

    public void setCloudDateStrings(ArrayList<String> cloudDateStrings) {
        this.cloudDateStrings = cloudDateStrings;
    }

    public ArrayList<String> getCloudDateStrings() {
        return cloudDateStrings;
    }

    public void setPrecipUrls(ArrayList<String> precipUrls) {
        this.precipUrls = precipUrls;
    }

    public ArrayList<String> getPrecipUrls() {
        return precipUrls;
    }

    public void setPrecipDateStrings(ArrayList<String> precipDateStrings) {
        this.precipDateStrings = precipDateStrings;
    }

    public ArrayList<String> getPrecipDateStrings() {
        return precipDateStrings;
    }

    public void setWetterkartenUrls(ArrayList<String> wetterkartenUrls) {
        this.wetterkartenUrls = wetterkartenUrls;
    }

    public ArrayList<String> getWetterkartenUrls() {
        return wetterkartenUrls;
    }

    public static URLProvider getInstance(){
        if(instance == null){
            instance = new URLProvider();
        }
        return instance;
    }
}
