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

public class Register extends AppCompatActivity {
    ImageButton homePage, backArrow;
    Button register;
    TextView namex, idx, datex, locx, langx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        String name = getIntent().getStringExtra("name");
        String id = getIntent().getStringExtra("id");
        String lang = getIntent().getStringExtra("lang");
        String date = getIntent().getStringExtra("date");
        String loc = getIntent().getStringExtra("loc");

        homePage = findViewById(R.id.homeButton);
        backArrow = findViewById(R.id.backArrow);
        register = findViewById(R.id.registerButton);

        homePage.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), homePage.class);
            startActivity(intent);
        });

        backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), create_events.class);
            startActivity(intent);
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), create_events.class);
            startActivity(intent);
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
}