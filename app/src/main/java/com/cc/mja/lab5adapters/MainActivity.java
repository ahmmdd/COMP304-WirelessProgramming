package com.cc.mja.lab5adapters;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.cc.lab5.lab5adapters.R;

public class MainActivity extends AppCompatActivity {
    private static final String[] FROM_COLUMNS = {ContactsContract.Contacts.DISPLAY_NAME_PRIMARY };
    // private static final int[] TO_IDS = {android.R.id.text1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example 1: ArrayAdapter
        String[] programs = {
                "Software Engineering Technology",
                "Interactive Gaming",
                "Health Informatics Technology",
                "Software Systems Design"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, programs);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.txtPrograms);
        textView.setThreshold(3); // must type three characters
        textView.setAdapter(adapter);
    }

    // Example 2: SimpleCursorAdapter
    public void displayContacts(View view) {
        // make sure you have this in Android manifest file:
        // <uses-permission android:name="android.permission.READ_CONTACTS" />

        try {
            // queries the local contact database
            // if you run this on your actual phone it will read all your contacts
            // if you run it in the emulator, make sure you add a few contacts first otherwise the list will be empty
            Cursor names = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

            ListAdapter adapter = new SimpleCursorAdapter(
                    this,
                    R.layout.phone_list_entry,
                    names,
                    new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
                    new int[]{R.id.contact_name},
                    0);

            ListView list = (ListView) findViewById(R.id.phoneList);
            list.setAdapter(adapter);

            // we add a listener so that when the user clicks on a contact in the list something happens
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                // when the user clicks on a contact the onItemClick method is executed
                public void onItemClick(
                        AdapterView<?> parent, View view,
                        int position, long id) {

                    Toast.makeText(getBaseContext(), "You clicked on item " + id + " in the list", Toast.LENGTH_SHORT).show();
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
