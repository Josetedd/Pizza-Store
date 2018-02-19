package com.example.android.pizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    int[] IMAGES ={R.drawable.pizaa1, R.drawable.pizza2, R.drawable.pizza3, R.drawable.pizaa4,
            R.drawable.pizaa5, R.drawable.pizza6,R.drawable.pizza7};
    String [] NAMES = {"Pizza1", "Pizza2", "Pizza3", "Pizaa4", "Pizaa5", "Pizza6", "Pizza7"};
    String [] INDREGDIENTS = {"Tomatoes,Beef,Garlic", "Oninons,Chicken,Tomatoes", "Bacon,pineapple,Tomatoes",
            "Cheese,Spring Onions,Black Pepper","Cheese,Onions,Tomatoes","Garlic,Cheese,Pork","Garlic,Onions,Tomatoes"};

    //declare FirebaseAuth instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.pizzalistview);

        CustomAdapter customAdapter=new CustomAdapter();

        listView.setAdapter(customAdapter);

        //initialize firebaseAuth instance
        mAuth = FirebaseAuth.getInstance();
        //check if user is already logged in using getCurrentUser()
        if (mAuth.getCurrentUser() == null) {
            //if user is not logged in, close this activity
            finish();
            // and open the login activity
            startActivity(new Intent(getApplicationContext(), loginActivity.class));
        }

        class CustomAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return IMAGES.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.customlayout, null);

                ImageView imageView =(ImageView)view.findViewById(R.id.imageView);
                TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
                TextView textView_ingredients = (TextView)view.findViewById(R.id.textView_ingredients);

                imageView.setImageResource(IMAGES[position]);
                textView_name.setText(NAMES[position]);
                textView_ingredients.setText(INDREGDIENTS[position]);
                return view;
            }


        }

    }
}
