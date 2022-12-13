package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {
    EditText email, password;
    Button login;
    DBHelper DB;
    TextView createaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email =findViewById(R.id.email1);
        password= findViewById(R.id.password1);
        login = findViewById(R.id.login);
        createaccount =findViewById(R.id.create_account);
        DB= new DBHelper(this);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),createAccount.class);
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
                    Boolean checkemailpass = DB.checkemailpassword(em,pass);
                    if (checkemailpass==true){
                        Toast.makeText(loginPage.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homePage.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginPage.this,"Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}