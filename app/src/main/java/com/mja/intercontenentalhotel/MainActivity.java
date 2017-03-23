package com.mja.intercontenentalhotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterButton = (Button) findViewById(R.id.btnEnter);

        //Onclick listener for enter button
        enterButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //click button code here
                Intent i = new Intent(getApplicationContext(),Cuisine.class);
                startActivity(i);
            }
        });

    }
}
