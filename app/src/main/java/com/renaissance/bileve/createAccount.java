package com.renaissance.bileve;
/*
We create UI of CreateAccount and store the information on Database accordingly.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class createAccount extends AppCompatActivity {
    public static int ithy;
    EditText email,password;
    Button login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        // initialization of events
        email = findViewById(R.id.passwordCreate);
        password = findViewById(R.id.bilkentID);
        login = findViewById(R.id.signup);

        ImageView b1;

        DB = new DBHelper(this);

        b1 = findViewById(R.id.comeback);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(createAccount.this, loginPage.class);
                startActivity(intent);
            }
        });


        // Checks whether this User is already registered or not. Also requires to fill all the tables
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
                            ithy = (int) ((Math.random()*10.8)+1)*180;
                            Toast.makeText(createAccount.this, "Registered Successfully, Your Security Code is: " + ithy,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),loginPage.class);
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