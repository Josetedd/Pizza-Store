package com.example.android.pizzaapp;

/**
 * Created by joseph on 2/25/18.
 */

public class Pizza {
    //declare variables for image,Title, Description and Rating
    public int pizzaImage;
    public String title;
    public String description;
    public float rating;

    //constructor
    public Pizza(){
        super();
    }
    public Pizza(int pizzaImage, String title, String description, float rating) {
        super();
        this.pizzaImage = pizzaImage;
        this.title = title;
        this. description = description;
        this. rating = rating;
    }
}
