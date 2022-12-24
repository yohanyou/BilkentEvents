package com.renaissance.bileve;
/*
This class shows the created events by the admin. For displaying we are using Adapter class of AndroidStudio and send data's accordingly
We get information from Database and use them in Adapter object for visibility.
 */

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Events extends AppCompatActivity implements RecyclerViewInterface {

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
    ImageView toLogOut;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_events);
        toLogOut = findViewById(R.id.logout);
        toLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Events.this, loginPage.class);
                startActivity(intent);
            }
        });
        toSettings = findViewById(R.id.homToSettings);
        toSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Events.this, settings.class);
                startActivity(intent);
            }
        });
        toHome = findViewById(R.id.toHomePage);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Events.this, homePage.class);
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
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.floatingActionButton);
        add_button.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), EventAdder.class);
            startActivity(intent);
        });

        // getting information from the database

        myDB = new MyDatabaseHelper(Events.this);
        event_id = new ArrayList<>();
        event_title = new ArrayList<>();
        event_lang = new ArrayList<>();
        event_date = new ArrayList<>();
        event_loc = new ArrayList<>();

        storeDataInArrays(); // storing information in arrays by extracting from Database

        // creating adapter object by getting Event paramaters and sending to RecyclerView to display

        customAdapter = new CustomAdapter(Events.this, event_id, event_title, event_lang, event_date, event_loc, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Events.this));

    }



    /**
     * Getting the created events from Database and store them in Arrays for using in Adapter class
     */
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
     * When clicked on the event it shows the details of the event while registering
     * Intent class is used to send information for usage
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(Events.this, RegisterEvents.class);
        intent.putExtra("name", event_title.get(position));
        intent.putExtra("id", event_id.get(position));
        intent.putExtra("lang", event_lang.get(position));
        intent.putExtra("date", event_date.get(position));
        intent.putExtra("loc", event_loc.get(position));

        startActivity(intent);

    }


}