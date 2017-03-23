package com.cc.mja.intentusesamplelab1;

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

        // create intent specifying the target class
        Intent intent = new Intent(Activity1.this, Activity2.class);

        // put first name and last name in intent

        // method 1: add each value individually with its own key
        intent.putExtra(Constants.key_first_name, firstName);
        intent.putExtra(Constants.key_last_name, lastName);

        // method 2: encapsulate all values inside an object of type Student then put the object inside the intent
        // make sure class Student implements Serializable
/*
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        intent.putExtra(Constants.key_student, student);
*/
        // note that I created class Constants to hold te keys for data stored in intent
        // they which are visible across all classes,
        // this way I do not need to copy/paste them when I code

        // start Activity2

        startActivity(intent);
    }
}
