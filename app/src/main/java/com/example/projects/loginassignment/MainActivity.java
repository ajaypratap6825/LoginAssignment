package com.example.projects.loginassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    Button login, create;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        logo = findViewById(R.id.logo);
        login = findViewById(R.id.login);
        create = findViewById(R.id.create);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        logo.setImageDrawable(getDrawable(R.drawable.circle));

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Create new account.", Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() || !validatePassword()){
                    return;
                }
                Toast.makeText(MainActivity.this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validateUsername(){
        String user = username.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(user.isEmpty()){
            Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!user.matches(emailPattern)){
            Toast.makeText(this, "Username is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePassword(){
        String pass = password.getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                ".{4,}" +               //at least 4 characters
                "$";
        if(pass.isEmpty()){
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!pass.matches(passwordVal)){
            Toast.makeText(this, "Password is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

}