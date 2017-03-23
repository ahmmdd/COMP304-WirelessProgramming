package com.mja.ahmedkhairalab5_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mja.ahmedkhairalab5_ex1.RestaurantActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        list = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Indian",
                "Greek",
                "Middle Eastern",
                "Chinese"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        list.setAdapter(adapter);

        // ListView Item Click Listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // List Clicked item index
                int itemPosition     = position;

                // List Clicked item value
                String  itemValue    = (String) list.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "You selected:  " +itemValue + " Cuisine." , Toast.LENGTH_LONG)
                        .show();

                switch(position){
                    case 0:
                        final String[] items = {" Adrak "," Ambiyan "," The Bombay Grill "," India's Taste "};
                        // arraylist to keep the selected items
                        final ArrayList selectedItems=new ArrayList();
                        for (int i=0; i < items.length; i++){
                            selectedItems.add(items[i]);
                        }
                        Intent in = new Intent(MainActivity.this, RestaurantActivity.class);
                        in.putExtra("restaurants_list", selectedItems);
                        startActivity(in);
                        break;

                    case 1:
                        final CharSequence[] items1 = {" Esquire "," Ithaca "," Jimmy The Greek "," Greek's Point "};
                        // arraylist to keep the selected items
                        final ArrayList selectedItems1=new ArrayList();
                        for (int i=0; i < items1.length; i++){
                            selectedItems1.add(items1[i]);
                        }
                        Intent in1 = new Intent(MainActivity.this, RestaurantActivity.class);
                        in1.putExtra("restaurants_list", selectedItems1);
                        startActivity(in1);
                        break;

                    case 2:
                        final CharSequence[] items2 = {" Paramount "," Bamiyan Kabob "," Pitalicious "," Tabule "};
                        // arraylist to keep the selected items
                        final ArrayList selectedItems2=new ArrayList();
                        for (int i=0; i < items2.length; i++){
                            selectedItems2.add(items2[i]);
                        }
                        Intent in2 = new Intent(MainActivity.this, RestaurantActivity.class);
                        in2.putExtra("restaurants_list", selectedItems2);
                        startActivity(in2);
                        break;

                    case 3:
                        final CharSequence[] items3 = {" Federick "," Congee Queen "," Dragon Legend "," Mandarin Restaurant "};
                        // arraylist to keep the selected items
                        final ArrayList selectedItems3=new ArrayList();
                        for (int i=0; i < items3.length; i++){
                            selectedItems3.add(items3[i]);
                        }
                        Intent in3 = new Intent(MainActivity.this, RestaurantActivity.class);
                        in3.putExtra("restaurants_list", selectedItems3);
                        startActivity(in3);
                        break;
                }

            }

        });
    }
}
