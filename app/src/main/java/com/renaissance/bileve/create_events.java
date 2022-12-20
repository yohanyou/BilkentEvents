package com.renaissance.bileve;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class create_events extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    MyDatabaseHelper myDB;
    ArrayList<String> event_id, event_title, event_lang, event_date, event_loc;
    CustomAdapter customAdapter;
    SearchView searchView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_events);

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        recyclerView =findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), add_events.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(create_events.this);
        event_id = new ArrayList<>();
        event_title = new ArrayList<>();
        event_lang = new ArrayList<>();
        event_date = new ArrayList<>();
        event_loc = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(create_events.this, event_id, event_title, event_lang, event_date, event_loc);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(create_events.this));

    }

    private void filterList(String text) {

    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() ==0 ){
            Toast.makeText(this, "No Data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                event_id.add(cursor.getString(0));
                event_title.add(cursor.getString(1));
                event_lang.add(cursor.getString(2));
                event_date.add(cursor.getString(3));
                event_loc.add(cursor.getString(4));
            }
        }
    }

}
