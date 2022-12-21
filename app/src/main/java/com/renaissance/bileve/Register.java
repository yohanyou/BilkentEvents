package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity {
    Button register;
    TextView namex, idx, datex, locx, langx;
    Button button;
    ArrayList<Schedule> schedule = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String lang = getIntent().getStringExtra("lang");
        String date = getIntent().getStringExtra("date");
        String loc = getIntent().getStringExtra("loc");



        button = findViewById(R.id.registerButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i = 0;

                if(schedule.isEmpty()){
                    schedule.add(new Schedule(name,date));
                    Toast.makeText(getApplicationContext(), "Registered to the first activity!", Toast.LENGTH_SHORT).show();
                }

                else {
                    for (int b = 0; schedule.size() > b; b++) {

                        if (!schedule.get(b).getTime().equals(date)) {
                            i++;
                            // 1dene obje var// eger arrayda yoxdusa artir, varsa artirma
                        }
                    }
                    if (i > schedule.size()) {
                        schedule.add(new Schedule(name, date));
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

}