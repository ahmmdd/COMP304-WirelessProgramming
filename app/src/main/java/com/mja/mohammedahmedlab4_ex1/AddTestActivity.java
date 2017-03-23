package com.mja.mohammedahmedlab4_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test);
        final DBAdapter db = new DBAdapter(this);
        db.open();

        Button btnAddTest=(Button)findViewById(R.id.btnAddTestFinal);
        btnAddTest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String TestID=((EditText)findViewById(R.id.tvTestId)).getText().toString();
                String PatientID=((EditText)findViewById(R.id.tvPatientId)).getText().toString();
                String BPH=((EditText)findViewById(R.id.tvBPH)).getText().toString();
                String BPL=((EditText)findViewById(R.id.tvBPL)).getText().toString();
                String temp=((EditText)findViewById(R.id.tvTemprature)).getText().toString();

                if(TestID.equals(null)||PatientID.equals(null)||BPH.equals(null)||BPL.equals(null)||temp.equals(null))
                {
                    Toast.makeText(getApplicationContext(),"All FIELDS Are Mandetory",Toast.LENGTH_LONG).show();
                }
                else
                {
                    long id=db.insertTest((Integer.parseInt(TestID)),(Integer.parseInt(PatientID)),BPH,BPL,temp);
                    if(id>0)
                    {
                        Toast.makeText(getApplicationContext(),"TEST ADDED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                    }
                }
                db.close();
            }
        });

    }
}
