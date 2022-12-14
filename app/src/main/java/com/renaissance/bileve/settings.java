package com.renaissance.bileve;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
    loginPage logp = new loginPage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }
}