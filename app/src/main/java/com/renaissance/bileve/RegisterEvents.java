package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterEvents extends AppCompatActivity {
    Button register;
    TextView namex, idx, datex, locx, langx;
    Button button;
    Context context;
    ArrayList<Schedule> schedule = new ArrayList<>();
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String lang = getIntent().getStringExtra("lang");
        String date = getIntent().getStringExtra("date");
        String loc = getIntent().getStringExtra("loc");


        ImageView backArrow = findViewById(R.id.lastArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterEvents.this, Events.class);
                startActivity(intent);
            }
        });



        button = findViewById(R.id.registerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //checks if the schedule is empty
                if(schedule.isEmpty()){
                    schedule.add(new Schedule(context, id,name,lang, date, loc));
                    Toast.makeText(getApplicationContext(), "Registered to the first activity!", Toast.LENGTH_SHORT).show();
                }

                else {
                    for (int b = 0; schedule.size() > b; b++) {
                        //checks for specific time conflicts
                        if (!schedule.get(b).getTime().equals(date)) {
                            i++;

                        }
                    }
                    if (i > schedule.size()) {
                        //adds schedule to the schedule arraylist
                        schedule.add(new Schedule(context, id,name,lang, date, loc));
                        Toast.makeText(getApplicationContext(), "Registered to the new activity!", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        int c = 0;
                        for (int b = 0; schedule.size() > b; b++) {

                            if (schedule.get(b).getTime().equals(date) && schedule.get(b).getName().equals(name)) {
                                c++; // eger
                            }
                        }
                        if (c > 0) {
                            Toast.makeText(getApplicationContext(), "Already Registered to the new activity!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }



            }

        });





        namex = findViewById(R.id.EventName);
        namex.setText(name);

        idx = findViewById(R.id.EventId);
        idx.setText(id);

        datex = findViewById(R.id.EventDate);
        datex.setText(date);

        locx = findViewById(R.id.EventLoc);
        locx.setText(loc);

        langx = findViewById(R.id.EventLanguage);
        langx.setText(lang);

    }

    public boolean equals (Object o) {
        Schedule x = (Schedule) o;
        if(o instanceof Schedule)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList<Schedule> getList() {

        return schedule;
    }

}