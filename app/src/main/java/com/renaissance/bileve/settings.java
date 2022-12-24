package com.renaissance.bileve;
/*
Purpose of this class is to keep the ID, Username and SecretPassword of the Client.
Clients can store their SecretPassword and Change their passwords with the relation of Database
onClick listener for buttons are used for swapping between the pages and display required message
 */


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
    Button logout;
    ImageButton homeButton;
    TextView changePassword;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        homeButton = findViewById(R.id.homeButton); // assigning buttons
        homeButton.setOnClickListener(new View.OnClickListener() { // using method to swap pages
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),homePage.class);
                startActivity(intent);
            }
        });

        changePassword = findViewById(R.id.settingsChangePassword);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),changePassword.class);
                startActivity(intent);
            }
        });

            logout = findViewById(R.id.logoutButton);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),loginPage.class);
                    startActivity(intent);
                }
            });
    }
}