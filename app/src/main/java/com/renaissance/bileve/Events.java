package com.renaissance.bileve;


import java.util.ArrayList;



// This class will get the Events from the DataBase and save it into the ArrayList
// DataBase implementation will be introduced later on.

public class Events {

    String eventName;
    String clubName;
    String date;
    String time;
    String location;
    int maxCapacity;


    public Events(String eventName, String clubName, String time, String date, String location, int maxCapacity) {
        this.eventName = eventName;
        this.clubName = clubName;
        this.time = time;
        this.date = date;
        this.location = location;
        this.maxCapacity = maxCapacity;
    }



    public String getEventName() {
        return this.eventName;
    }

    public String getClubName() {
        return this.clubName;
    }

    public String getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
    }

    public String getLocation() {
        return this.location;
    }

    public int getCapacity() {
        return this.maxCapacity;
    }



}