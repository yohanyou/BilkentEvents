package com.renaissance.bileve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class changePassword extends AppCompatActivity {
    EditText oldPassword, createPassword, newPasswordConfirm;
    ImageButton backButton;
    Button passwordChangeButton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        oldPassword= findViewById(R.id.oldPassword);
        createPassword= findViewById(R.id.createPassword);
        newPasswordConfirm= findViewById(R.id.newPasswordConfirm);
        passwordChangeButton=findViewById(R.id.passwordChangeButton);
        backButton=findViewById(R.id.settingsBack);
        DB = new DBHelper(this);

        passwordChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = oldPassword.getText().toString();
                String createPass= createPassword.getText().toString();
                String newPass= newPasswordConfirm.getText().toString();
                if (oldPass.isEmpty()||createPass.isEmpty()||newPass.isEmpty()){
                        Toast.makeText(changePassword.this, "You have to fill all of them",Toast.LENGTH_SHORT).show();
                }
                if (!createPass.equals(newPass)){
                    Toast.makeText(changePassword.this, "Your new passwords do not match",Toast.LENGTH_SHORT).show();
                }
                if (createPass.equals(newPass) && !createPass.isEmpty() && !newPass.isEmpty()){
                    Toast.makeText(changePassword.this, "Your password changed",Toast.LENGTH_SHORT).show();
                }
//                if ()
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),settings.class);
                startActivity(intent);
            }
        });
    }
}