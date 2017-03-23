package com.mja.mohammedahmedlab4_ex1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayPatientAndTestInfo extends AppCompatActivity {
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_and_test_info);
        DBAdapter db=new DBAdapter(this);
        ListView patients=(ListView)findViewById(R.id.patientListView);
        String []items={""};
        arrayList=new ArrayList<>(Arrays.asList(items));
        db.open();
        Cursor c = db.getAllUsers();
        if (c.moveToFirst())
        {
            do {
                arrayList.add((c.getString(c.getColumnIndex("patientid")))+" "+(c.getString(c.getColumnIndex("firstname")))+" "+(c.getString(c.getColumnIndex("lastname"))));
            } while (c.moveToNext());
        }
        db.close();
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,arrayList);
        patients.setAdapter(adapter);



        final ListView lvSettings=(ListView)findViewById(R.id.patientListView);
        //handle the item click event
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent=null;
                String selectedSetting =((String)lvSettings.getItemAtPosition(position)).substring(0,((String)lvSettings.getItemAtPosition(position)).indexOf(" "));
                //Toast.makeText(getApplicationContext(),selectedSetting,Toast.LENGTH_LONG).show();

                intent = new Intent(DisplayPatientAndTestInfo.this,ShowTest.class);
                intent.putExtra("selectedPatient",selectedSetting );
                startActivity(intent);
            }
        });



        //arrayList.add("Something");
        //adapter.notifyDataSetChanged();
    }
}
