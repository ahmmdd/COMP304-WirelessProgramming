package com.mja.mohammedahmedlab4_ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        final DBAdapter db = new DBAdapter(this);


        Button btnAddPatient=(Button)findViewById(R.id.btnaddPPatient);
        btnAddPatient.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                String pID=((EditText)findViewById(R.id.tvAddPatientID)).getText().toString();
                String firstname=((EditText)findViewById(R.id.tvAddPfname)).getText().toString();
                String lastname=((EditText)findViewById(R.id.tvAddPlname)).getText().toString();
                String dept=((EditText)findViewById(R.id.tvaddPdept)).getText().toString();
                String dID=((EditText)findViewById(R.id.tvaddPdoctorid)).getText().toString();
                String room=((EditText)findViewById(R.id.tvaddProom)).getText().toString();
                db.open();
                long flag=db.insertPatient((Integer.parseInt(pID)),firstname,lastname,(Integer.parseInt(dID)),dept,room);
                if(flag>0)
                    Toast.makeText(getApplicationContext(),"PATIENT ADDED SUCCESSFULLY",Toast.LENGTH_LONG).show();
                db.close();
            }
        });
    }
}
