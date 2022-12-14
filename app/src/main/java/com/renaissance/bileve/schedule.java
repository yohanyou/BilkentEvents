package com.renaissance.bileve;

public class schedule {
    String eventName;
    String clubName;
    String date;
    String location;
    String language;
    int maxCapacity;

    //creating an event
    public schedule(String eventName, String clubName, String date,String location, String language,int maxCapacity){
        this.eventName=eventName;
        this.clubName=clubName;
        this.date=date;
        this.location=location;
        this.language=language;
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
    public String getLanguage(){
        return this.language;
    }
    public int getMaxCapacity(){
        return this.maxCapacity;
    }

    /*checking whether events' dates are same or not
    dates should be added as dd/mm/yy
    if dates are same method will return 1; otherwise -1;
    */
    public int compareTo(schedule aschedule){
        int day = Integer.parseInt(this.date.substring(0,2));
        int month = Integer.parseInt(this.date.substring(2,4));
        int year = Integer.parseInt("22" + this.date.substring(4));
        int otherDay = Integer.parseInt(aschedule.date.substring(0,2));
        int otherMonth = Integer.parseInt(aschedule.date.substring(2,4));
        int otherYear = Integer.parseInt("22" + aschedule.date.substring(4));

        if(year==otherYear&&month==otherMonth&&day==otherDay)
            return 1;
        else return -1;
    }
}
