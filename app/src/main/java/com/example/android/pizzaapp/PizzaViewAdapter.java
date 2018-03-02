package com.example.android.pizzaapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by joseph on 2/25/18.
 */

public class PizzaViewAdapter extends ArrayAdapter<Pizza> {
    //declarition
    Context context;
    int layoutResourceId;
    Pizza data[] = null;

    // Constructor
    public PizzaViewAdapter(Context context, int layoutResourceId, Pizza[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemHolder();
            holder.imgPizza = (ImageView)row.findViewById(R.id.PizzaImage);
            holder.txtTitle = (TextView)row.findViewById(R.id.PizzaTitle);
            holder.txtDescription =(TextView) row.findViewById(R.id.PizzaDesc);
            holder.ratingBar =(RatingBar) row.findViewById(R.id.PizzaRating);

            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
        }

        Pizza pizza = data[position];
        holder.imgPizza.setImageResource(pizza.pizzaImage);
        holder.txtTitle.setText(pizza.title);
        holder.txtDescription.setText(pizza.description);
        holder.ratingBar.setRating(pizza.rating);

        return row;
    }
    static class ItemHolder
    {
        ImageView imgPizza;
        TextView txtTitle;
        TextView txtDescription;
        RatingBar ratingBar;
    }

}
