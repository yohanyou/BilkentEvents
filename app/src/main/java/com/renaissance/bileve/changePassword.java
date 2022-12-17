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
<<<<<<< Updated upstream
    EditText oldPassword, createPassword, newPasswordConfirm;
    ImageButton backButton;
=======
    EditText bilID, createPassword, newPasswordConfirm;
>>>>>>> Stashed changes
    Button passwordChangeButton;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        bilID= findViewById(R.id.bilIDChangePassword);
        createPassword= findViewById(R.id.createPassword);
        newPasswordConfirm= findViewById(R.id.newPasswordConfirm);
        passwordChangeButton=findViewById(R.id.passwordChangeButton);
        backButton=findViewById(R.id.settingsBack);
        DB = new DBHelper(this);

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
<<<<<<< Updated upstream
                if (createPass.equals(newPass) && !createPass.isEmpty() && !newPass.isEmpty()){
                    Toast.makeText(changePassword.this, "Your password changed",Toast.LENGTH_SHORT).show();
                }
//                if ()
            }
=======

>>>>>>> Stashed changes
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