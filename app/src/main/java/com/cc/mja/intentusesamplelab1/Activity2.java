package com.cc.mja.intentusesamplelab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();

        // method 1: retrieve values individually
        String firstName = intent.getStringExtra(Constants.key_first_name);
        String lastName = intent.getStringExtra(Constants.key_last_name);

        // method 2: retrieve the student object then get the attributes first name and last name
        //Student student = (Student) getIntent().getSerializableExtra(Constants.key_student);
        //String firstName = student.getFirstName();
        //String lastName = student.getLastName();

        TextView viewFirstName = (TextView) findViewById(R.id.viewFirstName);
        TextView viewLastName = (TextView) findViewById(R.id.viewLastName);

        viewFirstName.setText(firstName);
        viewLastName.setText(lastName);


    }
}
