package com.renaissance.bileve;

public class schedule {
    String eventName;
    String clubName;
    String date;
    String location;
    int maxCapacity;

    //creating an event
    public schedule(String eventName, String clubName, String date,String location,int maxCapacity){
        this.eventName=eventName;
        this.clubName=clubName;
        this.date=date;
        this.location=location;
        this.maxCapacity=maxCapacity;
    }

    //getting events information

    public String getEventName(){
        return this.eventName;
    }
    public String getClubName(){
        return this.clubName;
    }
    public String getDate(){
        return this.date;
    }
    public String getLocation(){
        return this.location;
    }
    public int getMaxCapacity(){
        return this.maxCapacity;
    }
}
