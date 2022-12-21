package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Schedule extends AppCompatActivity {

    String name;
    String day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

    }

    public Schedule(String name, String day)
    {
        this.name = name;
        this.day = day;
    }

    public String getTime()
    {
        return this.day;
    }
    public String getName()
    {
        return this.name;
    }





    // We will have a schedule object to keep the details of the registered schedule.
    // for adding next events
    // compare events for adding
    // if not in the list add it to the Schedule object and register
    //
    // then in Schedule class it will display the registered events


}