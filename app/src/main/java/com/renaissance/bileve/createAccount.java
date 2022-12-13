package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class createAccount extends AppCompatActivity {
    EditText email,password;
    Button login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.signup);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(em) || TextUtils.isEmpty(pass))
                    Toast.makeText(createAccount.this,"All fields Required", Toast.LENGTH_SHORT).show();
                else   {
                    Boolean checkuser = DB.checkemail(em);
                    if (checkuser==false){
                        Boolean insert = DB.insertData(em,pass);
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