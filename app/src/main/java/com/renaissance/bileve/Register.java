package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String lang = getIntent().getStringExtra("lang");
        String date = getIntent().getStringExtra("date");
        String loc = getIntent().getStringExtra("loc");


        TextView namex, idx, datex, locx, langx;
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
}