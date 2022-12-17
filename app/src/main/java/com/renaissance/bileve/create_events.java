package com.renaissance.bileve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class create_events extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_events);

        recyclerView =findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), add_events.class);
                startActivity(intent);
            }
        });
    }



}
