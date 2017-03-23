package com.mja.intercontenentalhotel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by MohammedJuned on 2016-10-22.
 */

public class Checkout extends AppCompatActivity {
    String name, addr, postal, payment, card, fcuisine;
    ArrayList<String[]> orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Intent intent =  getIntent();

        name = intent.getStringExtra("name");
        addr = intent.getStringExtra("address");
        postal = intent.getStringExtra("postal_code");
        payment = intent.getStringExtra("Payment");
        card = intent.getStringExtra("credit_card");
        fcuisine = intent.getStringExtra("fav_cuisine");
        orderItems = (ArrayList<String[]>) getIntent().getSerializableExtra("order_items");

        if(name.isEmpty() || addr.isEmpty() || postal.isEmpty() || payment.isEmpty() ||
                card.isEmpty() || fcuisine.isEmpty() || orderItems.isEmpty()) {
        }else{

            TextView fullName = (TextView) findViewById(R.id.enterNameTxt);
            fullName.setText(name);

            TextView address = (TextView) findViewById(R.id.enterAddressTxt);
            address.setText(addr);

            TextView postalCode = (TextView) findViewById(R.id.enterPostalTxt);
            postalCode.setText(postal);

            TextView paymnentInfo = (TextView) findViewById(R.id.enterPayTxt);
            paymnentInfo.setText(payment);

            TextView creditCard = (TextView) findViewById(R.id.enterCardTxt);
            creditCard.setText(card);

            TextView favCuisine = (TextView) findViewById(R.id.enterFavTxt);
            favCuisine.setText(fcuisine);

            TextView orderedItems = (TextView) findViewById(R.id.enterOrdrItmTxt);

            for (int i = 0; i< orderItems.size(); i++){
                orderedItems.setText("" + orderItems);
            }
        }
    }

    public void checkoutClick(View view){
        setContentView(R.layout.exit);
    }
}
