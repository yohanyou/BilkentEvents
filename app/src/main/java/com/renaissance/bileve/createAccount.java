package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class createAccount extends AppCompatActivity {
    EditText email,password;
    Button login;
    ImageButton turnback;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        email = findViewById(R.id.passwordCreate);
        password = findViewById(R.id.bilkentID);
        login = findViewById(R.id.signup);
        turnback = findViewById(R.id.turnback);
        DB = new DBHelper(this);

        turnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),loginPage.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(em) || TextUtils.isEmpty(pass))
                    Toast.makeText(createAccount.this,"All fields Required", Toast.LENGTH_SHORT).show();
                else   {
                    Boolean checkuser = DB.checkbilkentID(em);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(pass,em);
                        if (insert==true){
                            Toast.makeText(createAccount.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),homePage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(createAccount.this, "User Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });


    }
}