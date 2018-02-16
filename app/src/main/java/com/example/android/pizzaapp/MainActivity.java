package com.example.android.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    //declare FirebaseAuth instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize firebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        //check if user is already logged in using getCurrentUser()
        if (mAuth.getCurrentUser() == null) {
            //if user is not logged in, close this activity
            finish();
            // and open the login activity
            startActivity(new Intent(getApplicationContext(), loginActivity.class));
        }

    }
}
