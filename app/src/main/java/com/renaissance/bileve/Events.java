package com.renaissance.bileve;



import android.widget.TextView;

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
    ArrayList<String> eventList;
    ArrayList<Events> events; //

    public Events(String eventName, String clubName, String time, String date, String location, int maxCapacity)
    {
        this.eventName = eventName;
        this.clubName = clubName;
        this.time=time;
        this.date = date;
        this.location = location;
        this.maxCapacity = maxCapacity;
        createEventList();
    }

    
    public String getEventName()
    {
        return this.eventName;
    }

    public String getClubName()
    {
        return this.clubName;
    }

    public String getTime()
    {
        return this.time;
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

    /*
    * comparing day, month, year, time
    * data should be added such as dd/mm/yy :day/month/year
    * time should be added as hh/mm : hour/minute
    * */

    public int compareTo(Events aschedule){
        int day = Integer.parseInt(this.date.substring(0,2));
        int month = Integer.parseInt(this.date.substring(3,5));
        int year = Integer.parseInt("22" + this.date.substring(6));
        int hour = Integer.parseInt(this.time.substring(0,2));
        int minute = Integer.parseInt(this.time.substring(3,5));

        int otherDay = Integer.parseInt(aschedule.date.substring(0,2));
        int otherMonth = Integer.parseInt(aschedule.date.substring(3,5));
        int otherYear = Integer.parseInt("22" + aschedule.date.substring(6));
        int otherHour = Integer.parseInt(aschedule.time.substring(0,2));
        int otherMinute = Integer.parseInt(aschedule.time.substring(3,5));

        if(day==otherDay && minute==otherMinute && hour==otherHour && month==otherMonth && year==otherYear)
            return 1;
        else return -1;
    }

    /*
     * This method will be used in User class to create events and store them in the ArrayList of Events
     * Information from DataBase will be stored with different method and stored in the constructor shown above
     */

    public void createEventList()
    {
        events.add(new Events(eventName, clubName, time, date, location, maxCapacity));
    }

    public void ListEvvents()
    {
        for(int i=0;i<events.size();i++){
            Events a = events.get(i);
            //TextView textView = (TextView)....
            //the text
            textView.setText(a.eventName);
            textView.append(a.clubName+a.time+a.date+a.location+maxCapacity);
        }
    }
}
