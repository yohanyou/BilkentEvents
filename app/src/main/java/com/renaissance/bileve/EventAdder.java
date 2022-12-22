package com.renaissance.bileve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class add_events extends AppCompatActivity {

    EditText title_input, language_input, date_input, location_input ;
    Button addbutton;
    ImageView toHome;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_events);
        toHome=findViewById(R.id.comeback4);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_events.this, homePage.class);
                startActivity(intent);
            }
        });

        ImageView back = findViewById(R.id.arrowBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(add_events.this, create_events.class);
            }
        });

        title_input = findViewById(R.id.event_title);
        language_input = findViewById(R.id.event_language);
        date_input = findViewById(R.id.event_date);
        location_input = findViewById(R.id.event_location);
        addbutton = findViewById(R.id.add_button);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(add_events.this);
                myDB.addEvent(title_input.getText().toString().trim(),language_input.getText().toString().trim(),date_input.getText().toString().trim(),location_input.getText().toString().trim());
            }
        });
    }
}
