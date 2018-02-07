package com.example.android.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // method to open SignUpActivity
    public void openSignupActivity(View view) {

        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));

    }
}
