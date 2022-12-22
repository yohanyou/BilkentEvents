package com.renaissance.bileve;
/*

This class creates a template code for the simple Login Page. Displays some information measured by the algorithms.
Uses EditText AndroidUtility to add free text-typo to write and keep written info.
onClick listener for buttons are used for swapping between the pages and display required message

 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {

    // initialization of variables

    EditText email, password;
    Button login;
    DBHelper DB;
    TextView createaccount,forgot_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email =findViewById(R.id.email1);
        password= findViewById(R.id.password1);
        login = findViewById(R.id.login);
        createaccount =findViewById(R.id.create_account);
        forgot_password= findViewById(R.id.forgot_password);

        DB= new DBHelper(this); // sending information to database to store in the local
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),createAccount.class);
                startActivity(intent);
            }
        });
        TextView forgetPassword = findViewById(R.id.forgetPass);
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginPage.this, forgetPassword.class);
                startActivity(intent);
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginPage.this,changePassword.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em= email.getText().toString();
                String pass = password.getText().toString();

                if (TextUtils.isEmpty(em) || TextUtils.isEmpty(pass)){
                    Toast.makeText(loginPage.this,"All fields Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    //checkbilIDpass = DB.checkbilkentIDpassword(em,pass);
                    if (true){
                        Toast.makeText(loginPage.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Events.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginPage.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}