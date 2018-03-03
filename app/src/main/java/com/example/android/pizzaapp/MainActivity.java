package com.example.android.pizzaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  {//implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ListView homeList;
    //declare FirebaseAuth instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /**   ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);**/
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
        Pizza pizza_data[]= new Pizza[]{
                new Pizza(R.drawable.pizzaicon,"BBQ Chicken", "BBQ SAUCE, CORN, GRILLED CHICKEN, ONION",5),
                new Pizza(R.drawable.pizzaicon,"BBQ Steak", "BBQ SAUCE, CORN, ONION, BEEF STEAK",4),
                new Pizza(R.drawable.pizzaicon,"BEEF SUPREME", "PIZZA SAUCE, BBQ SAUCE, ONION, TOMATO, BEEF MINCE",2),
                new Pizza(R.drawable.pizzaicon,"CHICKEN BALI", "PIZZA SAUCE, GRILLED CHICKEN, MUSHROOM, PINEAPPLE, RED CHILI",5),
                new Pizza(R.drawable.pizzaicon,"CHICKEN SUPREME", "PIZZA SAUCE, GRILLED CHICKEN, MIX PEPPERS, ONION, TOMATO",3),
                new Pizza(R.drawable.pizzaicon,"SWAHILI CHICKEN", "PIZZA SAUCE, CORN, PINEAPPLE, RED CHILI, SWAHILI CHICKEN",2),
                new Pizza(R.drawable.pizzaicon,"CHICKEN TIKKA", "PIZZA SAUCE, MIX PEPPERS, MUSHROOM, ONION, RED CHILI, TIKKA CHICKEN",4),

        };
        //CONNECT DATA TO LIST
        PizzaViewAdapter adapter = new PizzaViewAdapter(this,R.layout.home_items_activity,pizza_data);

        //home listview initialize
        homeList= (ListView) findViewById(R.id.HomeList);

        //set adapter to the home list
        homeList.setAdapter(adapter);
        //set
        homeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView)view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

            }
        });

    }
    /**
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
         //Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
            return true;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }**/

}
