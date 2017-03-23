package com.comp304.mohammed.test1;

/**
 * Created by MohammedJuned on 2016-10-15.
 */

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        switch (item.getItemId()) {

            case R.id.option1:
                Toast.makeText(this.getBaseContext(), "English", Toast.LENGTH_LONG).show();
                return true;

            case R.id.option2:
                Toast.makeText(this.getBaseContext(), "French", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();

        // method 1: retrieve values individually
        String firstName = intent.getStringExtra(Constants.key_first_name);
        String lastName = intent.getStringExtra(Constants.key_last_name);
        String phoneNumber = intent.getStringExtra(Constants.key_phone_number);
        String street = intent.getStringExtra(Constants.key_street);
        String postalCode = intent.getStringExtra(Constants.key_postal_code);
        String city = intent.getStringExtra(Constants.key_city);


        TextView viewFirstName = (TextView) findViewById(R.id.viewFirstName);
        TextView viewLastName = (TextView) findViewById(R.id.viewLastName);
        TextView viewPhoneNumber = (TextView) findViewById(R.id.viewPhoneNumber);
        TextView viewStreet = (TextView) findViewById(R.id.viewStreet);
        TextView viewPostalCode = (TextView) findViewById(R.id.viewPostalCode);
        TextView viewCity = (TextView) findViewById(R.id.viewCity);

        viewFirstName.setTextColor(getResources().getColor(R.color.text_color));
        viewLastName.setTextColor(getResources().getColor(R.color.text_color));
        viewPhoneNumber.setTextColor(getResources().getColor(R.color.text_color));
        viewStreet.setTextColor(getResources().getColor(R.color.text_color));
        viewPostalCode.setTextColor(getResources().getColor(R.color.text_color));
        viewCity.setTextColor(getResources().getColor(R.color.text_color));

        viewFirstName.setText(firstName);
        viewLastName.setText(lastName);
        viewPhoneNumber.setText(phoneNumber);
        viewStreet.setText(street);
        viewPostalCode.setText(postalCode);
        viewCity.setText(city);
    }


}
