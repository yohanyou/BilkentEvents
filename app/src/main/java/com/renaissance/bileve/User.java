package com.renaissance.bileve;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class User extends AppCompatActivity {

    ArrayList<Events> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        RecyclerView recyclerView = findViewById(R.id.recycle);

        createEvents();

        AdapterOfEvents  adapter = new AdapterOfEvents(this,events);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void createEvents()
    {
        Events e1 = new Events("a","b","c","d","f",50);
        Events e2 = new Events("a","b","c","d","f",40);

        Events e3 = new Events("a","b","c","d","f",60);
        Events e4 = new Events("a","b","c","d","f",88);

        Events e5 = new Events("a","b","c","d","f",770);

        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
    }


}
