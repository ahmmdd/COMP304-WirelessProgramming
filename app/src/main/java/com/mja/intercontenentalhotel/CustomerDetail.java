package com.mja.intercontenentalhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by MohammedJuned on 2016-10-22.
 */

public class CustomerDetail extends AppCompatActivity {

    String fname, add, pcode, fcuisine, payment, card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

    }

    public void orderClick(View view){

        Intent intent = getIntent();

        ArrayList<String[]> menu_items = (ArrayList<String[]>) getIntent().getSerializableExtra("menu_items");

        EditText name = (EditText) findViewById(R.id.name);
        fname = name.getText().toString();

        EditText address = (EditText) findViewById(R.id.address);
        add = address.getText().toString();

        EditText postalCode = (EditText) findViewById(R.id.postalCode);
        pcode = postalCode.getText().toString();

        EditText favCuisine = (EditText) findViewById(R.id.favCuisine);
        fcuisine = favCuisine.getText().toString();

        RadioGroup paymentInfo = (RadioGroup) findViewById(R.id.paymentInfo);
        RadioButton rb = (RadioButton) findViewById(paymentInfo.getCheckedRadioButtonId());
        String payment = rb.getText().toString();

        EditText creditCard = (EditText) findViewById(R.id.creditCard);
        card = creditCard.getText().toString();

        Intent checkoutIntent = new Intent(this, Checkout.class);
        checkoutIntent.putExtra("name", fname);
        checkoutIntent.putExtra("address", add);
        checkoutIntent.putExtra("postal_code", pcode);
        checkoutIntent.putExtra("fav_cuisine", fcuisine);
        checkoutIntent.putExtra("Payment", payment);
        checkoutIntent.putExtra("credit_card", card);
        checkoutIntent.putExtra("order_items", menu_items);
        startActivity(checkoutIntent);
    }
}
