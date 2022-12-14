package com.renaissance.bileve;



import java.util.ArrayList;



// This class will get the Events from the DataBase and save it into the ArrayList
// DataBase implementation will be introduced later on.

public class Events {
    
    String eventName;
    String clubName;
    String date;
    String location; 
    int maxCapacity;
    ArrayList<String> eventList;
    ArrayList<Events> events; //

    public Events(String eventName, String clubName, String date, String location, int maxCapacity)
    {
        this.eventName = eventName;
        this.clubName = clubName;
        this.date = date;
        this.location = location;
        this.maxCapacity = maxCapacity;
    }

    
    public String getEventName()
    {
        return this.eventName;
    }

    public String getClubName()
    {
        return this.clubName;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getLocation()
    {
        return this.location;
    }

    public int getCapacity()
    {
        return this.maxCapacity;
    }

    
    /**
     * This method will be used in User class to create events and store them in the ArrayList of Events
     * Information from DataBase will be stored with different method and stored in the constructor shown above
     */
    public void createEventList()
    {
        events.add(new Events(eventName, clubName, date, location, maxCapacity));
    }

}
