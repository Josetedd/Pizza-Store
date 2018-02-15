package com.example.android.pizzaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    EditText emailEdit;
    EditText passwordEdit;
    Button loginBtn;
    TextView resetLink;
    TextView signupLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Initialize firebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        // if user is already logged in start main activity
        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        // initialize views
        emailEdit = findViewById(R.id.inputemail);
        passwordEdit = findViewById(R.id.inputpassword);
        loginBtn = findViewById(R.id.loginbutton);
        resetLink = findViewById(R.id.resetLink);
        signupLink = findViewById(R.id.signinlink);

    }

    //
    public void login() {
        //getting email and password from edit texts
        String email = emailEdit.getText().toString().trim();
        String password = passwordEdit.getText().toString().trim();
        // progressdialog initialize
        progressDialog = new ProgressDialog(loginActivity.this);
        progressDialog.setMessage("logging in..."); // Setting Message
        progressDialog.setTitle("log in"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        // if not empty
        progressDialog.show(); // Display Progress Dialog
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            //display some message here
                            Toast.makeText(loginActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    //
    public void onClick(View view) {
        if(view ==loginBtn) {
            login();
        }
        if(view == resetLink){
            startActivity(new Intent(getApplicationContext(), ResetPassActivity.class));

        }
        if(view == signupLink){
            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        }

    }
}
