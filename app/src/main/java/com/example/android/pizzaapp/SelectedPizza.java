package com.example.android.pizzaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectedPizza extends AppCompatActivity {
    //Declare views
    TextView titleTxt;
    ImageView imageImgView;
    TextView descTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_pizza);
        // Initialize views
        titleTxt = (TextView) findViewById(R.id.SelectedPizzaTittle);
        imageImgView = findViewById(R.id.SelectedPizzaImage);
        descTxt = findViewById(R.id.SelectedPizzaDesc);
        // get intent
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if(!bundle.isEmpty()){
            titleTxt.setText(bundle.getString("Title"));
            descTxt.setText(bundle.getString("Description"));
            imageImgView.setImageResource(bundle.getInt("ImageId"));
        }
    }
    public void goToorderSummary(View view){
        Intent i = new Intent(SelectedPizza.this, Ordered_activity.class);
        startActivity(i);
    }
}
