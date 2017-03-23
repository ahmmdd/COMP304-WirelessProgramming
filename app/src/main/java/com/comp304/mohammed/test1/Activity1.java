package com.comp304.mohammed.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
    }

    public void submit(View view) {

        // extract first name and last name from EditText
        EditText editFirstName = (EditText) findViewById(R.id.editFirstName);
        String firstName = editFirstName.getText().toString();
        EditText editLastName = (EditText) findViewById(R.id.editLastName);
        String lastName = editLastName.getText().toString();
        EditText editPhoneNumber = (EditText) findViewById(R.id.editPhoneNumber);
        String phoneNumber = editPhoneNumber.getText().toString();
        EditText editStreet = (EditText) findViewById(R.id.editStreet);
        String street = editStreet.getText().toString();
        EditText editPostalCode = (EditText) findViewById(R.id.editPostalCode);
        String postalCode = editPostalCode.getText().toString();
        EditText editCity = (EditText) findViewById(R.id.editCity);
        String city = editCity.getText().toString();

        editFirstName.setTextColor(getResources().getColor(R.color.text_color1));
        editLastName.setTextColor(getResources().getColor(R.color.text_color1));
        editPhoneNumber.setTextColor(getResources().getColor(R.color.text_color1));
        editStreet.setTextColor(getResources().getColor(R.color.text_color1));
        editPostalCode.setTextColor(getResources().getColor(R.color.text_color1));
        editCity.setTextColor(getResources().getColor(R.color.text_color1));

        // create intent specifying the target class
        Intent intent = new Intent(Activity1.this, Activity2.class);

        // put first name and last name in intent

        intent.putExtra(Constants.key_first_name, firstName);
        intent.putExtra(Constants.key_last_name, lastName);
        intent.putExtra(Constants.key_phone_number, phoneNumber);
        intent.putExtra(Constants.key_street, street);
        intent.putExtra(Constants.key_postal_code, postalCode);
        intent.putExtra(Constants.key_city, city);

        startActivity(intent);
    }
}
