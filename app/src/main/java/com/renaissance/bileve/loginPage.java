package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //creates a button and then attaches it to the login button
        Button button = (Button) findViewById(R.id.login);
        //sets an on on click listener to this button
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //whenever the button is clicked it executes the homePage method
                homePage();
            }

        });
    }

    public void homePage(){
        //creates a new intent
        Intent intent = new Intent(this, homePage.class);
        //changes from this Activity to the homePage class
        startActivity(intent);
    }

}