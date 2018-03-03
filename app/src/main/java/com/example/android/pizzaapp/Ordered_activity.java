package com.example.android.pizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ordered_activity extends AppCompatActivity {

    //Tracks the quantity for items One ,Two and Three
    int qtyItemOne , qtyItemTwo , qtyItemThree= 0; // declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_activity);
    }
    /**
     * Decrease the quantity for Item One by 1.
     */
    public void minusOneforItemOne(View v){
        if (qtyItemOne == 1){
            //show an error message as a toast
            Toast.makeText(this,"You can't have less than 1 pizza",Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        qtyItemOne = qtyItemOne - 1;
        displayForItemOne(qtyItemOne);
    }
    /**
     * Increase the quantity for Item One by 1.
     */
    public void addOneforItemOne(View v){
        qtyItemOne = qtyItemOne + 1;
        displayForItemOne(qtyItemOne);
    }
    /**
     * Displays the quantity for item One.
     */
    private void displayForItemOne(int quantity) {
        TextView quantityView = (TextView) findViewById(R.id.qty1);
        quantityView.setText(String.valueOf(quantity));
    }
    /**
     * Decrease the quantity for Item Two by 1.
     */
    public void minusOneforItemTwo(View v){
        if (qtyItemTwo == 1){
            //show an error message as a toast
            Toast.makeText(this,"You can't have less than 1 pizza",Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        qtyItemTwo = qtyItemTwo - 1;
        displayForItemTwo(qtyItemTwo);
    }
    /**
     * Increase the quantity for Item One by 1.
     */
    public void addOneforItemTwo(View v){
        qtyItemTwo = qtyItemTwo + 1;
        displayForItemTwo(qtyItemTwo);
    }
    /**
     * Displays the quantity for item Two.
     */
    private void displayForItemTwo(int quantity) {
        TextView quantityView = (TextView) findViewById(R.id.qty2);
        quantityView.setText(String.valueOf(quantity));
    }
    /**
     * Decrease the quantity for Item Three by 1.
     */
    public void minusOneforItemThree(View v){
        if (qtyItemThree == 1){
            //show an error message as a toast
            Toast.makeText(this,"You can't have less than 1 pizza",Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        qtyItemThree = qtyItemThree - 1;
        displayForItemThree(qtyItemThree);
    }
    /**
     * Increase the quantity for Item One by 1.
     */
    public void addOneforItemThree(View v){
        qtyItemThree = qtyItemThree + 1;
        displayForItemThree(qtyItemThree);
    }
    /**
     * Displays the quantity for item Three.
     */
    private void displayForItemThree(int quantity) {
        TextView quantityView = (TextView) findViewById(R.id.qty3);
        quantityView.setText(String.valueOf(quantity));
    }
//    /**
//     * update the price for Item one.
//     */
//    public void priceforItemOne(View v){
//        priceItemOne = 355;
//        priceItemOne = 355 * ;
//        displayForPriceOne(priceforItemOne);
//    }
//    /**
//     * Displays the price for item one.
//     */
//    private void displayForPriceOne(int price) {
//        TextView priceView = (TextView) findViewById(R.id.firstprice);
//        priceView.setText(String.valueOf(price));
//    }
    // Figure out if the user has cancelled item one
//    CheckBox item_one_Checkbox = findViewById(R.id.firstcheckbox);
//    boolean hasFive_a = item_one_Checkbox.isChecked();

    /**
     * Resets the quantity for all items back to 0.
     */
//    public void resetScore(View v){
//        qtyItemOne = 0;
//        qtyItemTwo = 0;
//        qtyItemThree = 0;
//        displayForItemOne(qtyItemOne);
//        displayForItemTwo(qtyItemTwo);
//        displayForItemThree(qtyItemThree);
//    }
}