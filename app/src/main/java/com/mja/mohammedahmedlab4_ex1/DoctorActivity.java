package com.mja.mohammedahmedlab4_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DoctorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Button btnAddTest = (Button) findViewById(R.id.btnAddTest);
        Button btnDiplayTest=(Button) findViewById(R.id.btnViewPatients);
        Button btnLogout=(Button)findViewById(R.id.btnDoctorLogout);
        btnAddTest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent=new Intent(DoctorActivity.this,AddTestActivity.class);
                startActivity(intent);
            }
        });
        btnDiplayTest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent=new Intent(DoctorActivity.this,DisplayPatientAndTestInfo.class);
                startActivity(intent);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DoctorActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
