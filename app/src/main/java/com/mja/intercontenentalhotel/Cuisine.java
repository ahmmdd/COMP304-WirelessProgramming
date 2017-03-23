package com.mja.intercontenentalhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by MohammedJuned on 2016-10-22.
 */

public class Cuisine extends AppCompatActivity {
    int cuisineId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.cuisineRadioGrp);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup radioGroup, int checkId){
                RadioButton btnAmerican = (RadioButton) findViewById(R.id.btnAmerican);
                RadioButton btnItalian = (RadioButton) findViewById(R.id.btnItalian);
                RadioButton btnChinese = (RadioButton) findViewById(R.id.btnChinese);

                if (btnAmerican.isChecked()) {
                    cuisineId = 1;
                    Toast.makeText(getBaseContext(), "American Cuisine is selected.", Toast.LENGTH_SHORT).show();
                }
                if (btnItalian.isChecked()){
                    cuisineId = 3;
                    Toast.makeText(getBaseContext(), "Italian Cuisine is selected.", Toast.LENGTH_SHORT).show();
                }
                if (btnChinese.isChecked()){
                    cuisineId = 2;
                    Toast.makeText(getBaseContext(), "Chinese Cuisine is selected.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void nextResPage(View view){
        switch (cuisineId){
            case 1:
                Intent american = new Intent(getApplicationContext(),resAmerican.class);
                american.putExtra("cuisine", "American");
                startActivity(american);
                break;
            case 2:
                Intent chinese = new Intent(getApplicationContext(),resChinese.class);
                chinese.putExtra("cuisine", "Chinese");
                startActivity(chinese);
                break;
            case 3:
                Intent italian = new Intent(getApplicationContext(),resItalian.class);
                italian.putExtra("cuisine", "Italian");
                startActivity(italian);
                break;
        }
    }
}
