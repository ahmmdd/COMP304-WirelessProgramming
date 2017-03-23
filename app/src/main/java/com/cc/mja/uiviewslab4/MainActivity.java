package com.cc.mja.uiviewslab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Single CheckBox
        CheckBox checkBox = (CheckBox) findViewById(R.id.singleCheckbox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            //implement the event handler method
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getBaseContext(), "Single CheckBox Checked", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Single CheckBox Unchecked", Toast.LENGTH_LONG).show();
                }
            }
        });


        //RadioGroups
        //create the radio group reference
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup01);
        //register the radio group reference with a click listener
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            //implement the event handler method
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = (RadioButton) findViewById(R.id.RadioButton01);
                if (rb1.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 1 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb2 = (RadioButton) findViewById(R.id.RadioButton01);
                if (rb2.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 2 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb3 = (RadioButton) findViewById(R.id.RadioButton01);
                if (rb3.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 3 checked", Toast.LENGTH_LONG).show();
                }
                RadioButton rb4 = (RadioButton) findViewById(R.id.RadioButton01);
                if (rb4.isChecked()) {
                    Toast.makeText(getBaseContext(), "Radio Button 4 checked", Toast.LENGTH_LONG).show();
                }

            }
        });

        // ToggleButton
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            //implement the event handler method
            public void onClick(View v) {
                if (((ToggleButton) v).isChecked())
                    Toast.makeText(getBaseContext(), "Toggle Button On", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Toggle Button Off", Toast.LENGTH_LONG).show();
            }
        });


        // input validation
        // the layout limits us to 10 characters
        // the filter turns everything in uppercase
        final EditText text_filtered = (EditText) findViewById(R.id.validated_input);
        text_filtered.setFilters(new InputFilter[]{
                new InputFilter.AllCaps(), new InputFilter.LengthFilter(10)
        });



    }
}
