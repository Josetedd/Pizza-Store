package com.example.android.pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedPizza extends AppCompatActivity {
    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_pizza);

        Bundle bundle = getIntent().getExtras();
        String myTitle = bundle.getString("Title");
        String myDesc = bundle.getString("Description");
        int myImageId = bundle.getInt("ImageId");
        title = findViewById(R.id.SelectedPizzaTittle);
        description = findViewById(R.id.SelectedPizzaDesc);
        title.setText(myTitle);
        description.setText(myDesc);


    }
}
