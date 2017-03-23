package com.mja.mohammedahmedlab4_ex1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ShowTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_test);
        Bundle extras = getIntent().getExtras();
        //extract the variable values from bundle object
        String pid = extras.getString("selectedPatient");
        //Toast.makeText(getApplicationContext(),pid,Toast.LENGTH_LONG).show();
        DBAdapter db=new DBAdapter(this);
        TextView testdata=(TextView)findViewById(R.id.tDetails);
        db.open();
        Cursor c = db.getTest(Integer.parseInt(pid));
        String tests="";
        if (c.moveToFirst())
        {
            do {
                tests=tests.concat("\n TEST ID: "+(c.getString(c.getColumnIndex("testid")))+"\n PatientID: "+(c.getString(c.getColumnIndex("patientid")))+"\n BPH: "+(c.getString(c.getColumnIndex("BPH")))+"\n BPL: "+(c.getString(c.getColumnIndex("BPL")))+"\n Temprature: "+(c.getString(c.getColumnIndex("temprature")))+"\n");

            } while (c.moveToNext());
            testdata.setText(tests);
        }
        db.close();
    }
}
