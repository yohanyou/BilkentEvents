package com.renaissance.bileve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homePage extends AppCompatActivity {
    TextView logout1,applyt;
    ImageButton settings, eventApply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        applyt = findViewById(R.id.applyText);


        //creates a button-listener for the settings button
        settings = findViewById(R.id.settings);
        applyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), create_events.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), settings.class);
                startActivity(intent);
            }
        });

        //creates a button-listener for the event applying button
        eventApply = findViewById(R.id.eventApply);
        eventApply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), create_events.class);
                startActivity(intent);
            }
        });

        //creates a button-listener for the logout button
        logout1 = findViewById(R.id.logout);
        logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),loginPage.class);
                startActivity(intent);
            }
        });
    }

}