package com.mja.mohammedahmedlab4_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        Button btnAddPatient=(Button)findViewById(R.id.btnStaffAddPatient);
        final Intent addPatient=new Intent(StaffActivity.this,AddPatientActivity.class);
        Button btnAddTest=(Button)findViewById(R.id.btnStaffAddTest);
        final Intent addTest=new Intent(StaffActivity.this,AddTestActivity.class);
        Button btnDisplayTestInfo=(Button)findViewById(R.id.btnStaffDisplayTestInfo);
        final Intent displayTestInfo=new Intent(StaffActivity.this,DisplayPatientAndTestInfo.class);
        Button btnLogout=(Button)findViewById(R.id.btnStaffLogout);
        final Intent logout=new Intent(StaffActivity.this,MainActivity.class);
        btnAddPatient.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(addPatient);
            }
        });
        btnAddTest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(addTest);
            }
        });
        btnDisplayTestInfo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(displayTestInfo);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(logout);
            }
        });
    }
}

