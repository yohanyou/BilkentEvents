package com.renaissance.bileve;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class createAccount extends AppCompatActivity {
    TextInputEditText textInputEditTextEmail, textInputEditTextPassword, textInputEditTextID;
    Button buttonlogin, buttoncreate;
    TextView welcome;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        textInputEditTextEmail =findViewById(R.id.email);
        textInputEditTextID =findViewById(R.id.bilkentID);
        textInputEditTextPassword =findViewById(R.id.password);
        buttonlogin = findViewById(R.id.buttonlogin);
        buttoncreate = findViewById(R.id.buttoncreate);
        welcome = findViewById(R.id.welcome);
        buttoncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start ProgressBar first (Set visibility VISIBLE)
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "id";
                        field[1] = "email";
                        //Creating array for data
                        String[] data = new String[2];
                        data[0] = "data-1";
                        data[1] = "data-2";
                        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                //End ProgressBar (Set visibility to GONE)
                            }
                        }
                        //End Write and Read data with URL
                    }
                });
            }
        });





    }
}