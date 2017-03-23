package com.mja.ahmedkhairalab5_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    ArrayList<String> getRes;
    ListView restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Intent intent = getIntent();
        getRes = (ArrayList<String>) getIntent().getSerializableExtra("restaurants_list");

        // Get ListView object from xml
        restaurantList = (ListView) findViewById(R.id.resList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, getRes);

        // Assign adapter to ListView
        restaurantList.setAdapter(adapter);

        // ListView Item Click Listener
        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // List Clicked item index
                int itemPosition = position;

                // List Clicked item value
                String  itemValue    = (String) restaurantList.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),"You selected:  "+itemValue+" Restaurant.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
