package com.example.android.pizzaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText emailInputEdit;
    EditText passInputEdit;
    EditText confirmEdit;
    TextView warningText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // FirebaseAuth instance initialization
        mAuth = FirebaseAuth.getInstance();
        // Initialize viewa
        emailInputEdit = findViewById(R.id.inputEmail);
        passInputEdit = findViewById(R.id.inputPassword);
        confirmEdit = findViewById(R.id.inputPassConfirm);
        warningText = findViewById(R.id.WarningText);

    }
    public void registerUser(){
        String email = emailInputEdit.getText().toString().toLowerCase().trim();
        String password = passInputEdit.getText().toString().toLowerCase().trim();
        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty

        //creating a new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            // close signup activity
                            finish();
                            //Go to Main Screen
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            // show registration success
                            Toast.makeText(SignUpActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            //todo : enable user to access main activity

                        }else{
                            //display some message here
                            Toast.makeText(SignUpActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void onClick(View view) {

        String password = passInputEdit.getText().toString().trim().toLowerCase();
       String passConfirm = confirmEdit.getText().toString().trim().toLowerCase();
       // todo :add check email and password
       if(password.equals(passConfirm)) {
           //calling register method on click
           registerUser();
       }
       else {
           warningText.setText("Password Mismatch!");
       }


    }
}
