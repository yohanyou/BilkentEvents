package com.renaissance.bileve;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class changePassword extends AppCompatActivity {
    EditText bilID, createPassword, newPasswordConfirm;
    Button passwordChangeButton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        bilID= findViewById(R.id.event_title);
        createPassword= findViewById(R.id.event_date);
        newPasswordConfirm= findViewById(R.id.event_location);
        passwordChangeButton=findViewById(R.id.add_button);
        DB = new DBHelper(this);

        ImageView b1 = findViewById(R.id.comeback1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(changePassword.this, loginPage.class);
                startActivity(intent);
            }
        });


        passwordChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bilkentIDChagePassword = bilID.getText().toString();
                String createPass= createPassword.getText().toString();
                String newPass= newPasswordConfirm.getText().toString();
                if (createPass.equals(newPass)) {
                    Boolean checkUser = DB.checkbilkentID(bilkentIDChagePassword);
                    Boolean checkPasswordUpdate = DB.updatepassword(bilkentIDChagePassword, newPass);
                    if (checkPasswordUpdate == true) {
                        Intent intent = new Intent(getApplicationContext(), loginPage.class);
                        startActivity(intent);
                        Toast.makeText(changePassword.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(changePassword.this, "Password Not Updated", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(changePassword.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                }
            }

        });




    }

}