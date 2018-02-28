package com.example.android.pizzaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    EditText emailEdit;
    Button resetBtn;
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);
        // Initialize views
        emailEdit = findViewById(R.id.inputemailReset);
        resetBtn = findViewById(R.id.ResetBtn);
        backBtn = findViewById(R.id.backBtn);


        mAuth = FirebaseAuth.getInstance();
    }
    public void resetPass(){
        String email = emailEdit.getText().toString().trim();
        // progressdialog initialize
        progressDialog = new ProgressDialog(ResetPassActivity.this);
        progressDialog.setMessage("Resetting..."); // Setting Message
        progressDialog.setTitle("Reset"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"No email entered", Toast.LENGTH_LONG);
            return;
        }

        //Reset password
        progressDialog.show();// display progress dialog
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPassActivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetPassActivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }

                        progressDialog.dismiss();
                    }
                });
    }
    public void onClick(View view){
        if(view == resetBtn){
           resetPass();
        }
        if (view == backBtn){
           finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

    }

}
