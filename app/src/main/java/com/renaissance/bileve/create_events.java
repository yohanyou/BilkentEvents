package com.renaissance.bileve;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class create_events extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyDatabaseHelper myDB;
    ArrayList<String> event_id, event_title, event_lang, event_date, event_loc;
    //ArrayList<String>filteredId, filteredTitle, filteredLang, filteredDate, filteredLoc;
    //int indexNo, increment;
    //customadapter customFilteredAdapter
    CustomAdapter customAdapter;
    SearchView searchView;

    ImageButton toHome;
    ImageButton toSettings;
    Button toLogOut;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_events);
        toLogOut = findViewById(R.id.logout);
        toLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_events.this, loginPage.class);
                startActivity(intent);
            }
        });
        toSettings = findViewById(R.id.homToSettings);
        toSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_events.this, settings.class);
                startActivity(intent);
            }
        });
        toHome = findViewById(R.id.toHomePage);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_events.this, homePage.class);
                startActivity(intent);
            }
        });

        searchView = findViewById(R.id.searchView);
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

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), add_events.class);
            startActivity(intent);
        });

        myDB = new MyDatabaseHelper(create_events.this);
        event_id = new ArrayList<>();
        event_title = new ArrayList<>();
        event_lang = new ArrayList<>();
        event_date = new ArrayList<>();
        event_loc = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(create_events.this, event_id, event_title, event_lang, event_date, event_loc, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(create_events.this));

    }

    private void filterList(String text) {
        /*
        filteredId = new ArrayList<>();
        filteredTitle = new ArrayList<>();
        filteredLang = new ArrayList<>();
        filteredDate = new ArrayList<>();
        filteredLoc = new ArrayList<>();
        increment = 0;

        for (String filter : event_date) {
            if (filter.equals(text)) {
                indexNo = event_date.indexOf(filter);
                filteredId.set(increment, event_id.get(indexNo));
                filteredTitle.set(increment, event_title.get(indexNo));
                filteredLang.set(increment, event_lang.get(indexNo));
                filteredLoc.set(increment, event_loc.get(indexNo));
                increment++;
            }
        }

        customFilteredAdapter = new CustomAdapter(create_events.this, filteredId, filteredTitle, filteredLang, filteredDate, filteredLoc);
        recyclerView.setAdapter(customFilteredAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(create_events.this));
         */
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                event_id.add(cursor.getString(0));
                event_title.add(cursor.getString(1));
                event_lang.add(cursor.getString(2));
                event_date.add(cursor.getString(3));
                event_loc.add(cursor.getString(4));
            }
        }
    }

    /**
     * We are taking the position of the event and displaying the details after clicking
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(create_events.this, Register.class);
        intent.putExtra("name", event_title.get(position));
        intent.putExtra("id", event_id.get(position));
        intent.putExtra("lang", event_lang.get(position));
        intent.putExtra("date", event_date.get(position));
        intent.putExtra("loc", event_loc.get(position));

        startActivity(intent);
        //event_id, event_title, event_lang, event_date, event_loc;


    }
}