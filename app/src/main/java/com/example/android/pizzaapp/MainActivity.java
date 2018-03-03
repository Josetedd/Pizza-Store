package com.example.android.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private ListView homeList;
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
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        // Temporary data. list of pizzas will be from firebase realtime database
        final Pizza pizza_data[]= new Pizza[]{
                new Pizza(R.drawable.pizza1,"BBQ Chicken", "BBQ SAUCE, CORN, GRILLED CHICKEN, ONION",5),
                new Pizza(R.drawable.pizza2,"BBQ Steak", "BBQ SAUCE, CORN, ONION, BEEF STEAK",4),
                new Pizza(R.drawable.pizza3,"BEEF SUPREME", "PIZZA SAUCE, BBQ SAUCE, ONION, TOMATO, BEEF MINCE",2),
                new Pizza(R.drawable.pizza44,"CHICKEN BALI", "PIZZA SAUCE, GRILLED CHICKEN, MUSHROOM, PINEAPPLE, RED CHILI",5),
                new Pizza(R.drawable.pizza5,"CHICKEN SUPREME", "PIZZA SAUCE, GRILLED CHICKEN, MIX PEPPERS, ONION, TOMATO",3),
                new Pizza(R.drawable.pizza6,"SWAHILI CHICKEN", "PIZZA SAUCE, CORN, PINEAPPLE, RED CHILI, SWAHILI CHICKEN",2),
                new Pizza(R.drawable.pizza7,"CHICKEN TIKKA", "PIZZA SAUCE, MIX PEPPERS, MUSHROOM, ONION, RED CHILI, TIKKA CHICKEN",4),

        };
        //CONNECT DATA TO LIST
        final PizzaViewAdapter adapter = new PizzaViewAdapter(this,R.layout.home_items_activity,pizza_data);

        //home listview initialize
        homeList= (ListView) findViewById(R.id.HomeList);

        //set adapter to the home list
        homeList.setAdapter(adapter);
        //set
        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
               Pizza pizza = (Pizza) parent.getItemAtPosition(position);
                Intent i = new Intent(MainActivity.this, SelectedPizza.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ImageId", pizza.getPizzaImage());
                bundle.putString("Title", pizza.getTitle());
                bundle.putString("Description", pizza.getDescription());
                i.putExtras(bundle);
                startActivity(i);

            }
        });

    }
}
