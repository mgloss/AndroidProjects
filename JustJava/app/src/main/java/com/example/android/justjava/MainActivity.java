package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream);
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate);
        EditText name = (EditText) findViewById(R.id.name);
        String customerName = name.getText().toString();

        //check current state of a check boxes (true or false)
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        boolean hasChocolate = chocolateCheckbox.isChecked();
        // calculate the total price
        int price = calculatePrice(hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "udacitydemojustjavaapp@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, customerName));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(price, hasWhippedCream, hasChocolate, customerName));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * @return the total price of the order.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int totalPrice = 0;
        if (hasWhippedCream) {
            totalPrice = totalPrice + quantity * 1;
        }
        if (hasChocolate) {
            totalPrice = totalPrice + quantity * 2;
        }
        totalPrice = totalPrice + quantity * 5;
        return totalPrice;
    }

    /**
     * Create summary of the order.
     *
     * @param customerName    is the name entered by customer
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate    is whether or not the user wants chocolate topping
     * @param price           of the order
     * @return text summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String customerName) {

        String summaryMessage = getString(R.string.order_summary_name, customerName);
        //summaryMessage += customerName;
        summaryMessage += "\n";
        summaryMessage += getString(R.string.order_whipped_cream, checkTopping(hasWhippedCream));

        summaryMessage += "\n";
        summaryMessage = summaryMessage + getString(R.string.order_chocolate, checkTopping(hasChocolate));

        summaryMessage += "\n";
        summaryMessage += getResources().getString(R.string.order_summary_quantity, quantity);

        summaryMessage += "\n";
        summaryMessage += getString(R.string.order_summary_total, price);

        summaryMessage += "\n" + getString(R.string.thank_you);
        return summaryMessage;
    }


    private String checkTopping(boolean topping) {
        if (topping) {
            return getString(R.string.trueText);
        } else {
            return getString(R.string.falseText);
        }

    }


    /* This method is called when the + button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, getString(R.string.toast_max_order), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /* This method is called when the + button is clicked.
    */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, getString(R.string.toast_min_order), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int something) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + something);
    }


}
