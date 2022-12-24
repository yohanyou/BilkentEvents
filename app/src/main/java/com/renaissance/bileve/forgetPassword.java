package com.renaissance.bileve;
/*

This class gets information from the user and checks the SecretPassword of every Client and changes password.

 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class forgetPassword extends AppCompatActivity {
    EditText bil;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        bil= findViewById(R.id.bilIDForgetPassword2);
        change = findViewById(R.id.change);


        ImageView home = findViewById(R.id.comeback3);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bil.getText().equals(createAccount.ithy)){
                    Intent intent = new Intent(forgetPassword.this, changePassword.class );
                    startActivity(intent);
                }else{
                    Toast.makeText(forgetPassword.this, "Your Security Password does not match",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}