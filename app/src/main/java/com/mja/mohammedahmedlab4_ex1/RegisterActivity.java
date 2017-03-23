package com.mja.mohammedahmedlab4_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final DBAdapter db = new DBAdapter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button registerbutton = (Button) findViewById(R.id.btnregisterRegister);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String id=((EditText)findViewById(R.id.tvID)).getText().toString();
                String username= ((EditText)findViewById(R.id.tvregisterUsername)).getText().toString();
                String firstname=((EditText)findViewById(R.id.tvFirstname)).getText().toString();
                String lastname=((EditText)findViewById(R.id.tvLastName)).getText().toString();
                String dept=((EditText)findViewById(R.id.tvDepartment)).getText().toString();
                String password=((EditText)findViewById(R.id.tvregisterPassword)).getText().toString();
                String cpassword=((EditText)findViewById(R.id.registerCpassword)).getText().toString();
                String profession=((Spinner)findViewById(R.id.spinner)).getSelectedItem().toString();
                Intent intentdoctor=new Intent(RegisterActivity.this,DoctorActivity.class);
                Intent intentstaff=new Intent(RegisterActivity.this,StaffActivity.class);
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                db.open();

                if(password.equals(cpassword))
                {

                    //if(profession.equals("Doctor"))
                    //{
                    long flag1 = db.insertUser(username, password, profession) ;
                    long flag2 = db.insertDoctor((Integer.parseInt(id)),firstname, lastname, dept);
                    if(flag1!=-1 && flag2!=-1)
                    {
                        Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                    }
                    startActivity(intent);
                    //}
                    /*else
                    {
                        flag = db.insertNurse((Integer.parseInt(id)),firstname, lastname, dept);
                        if(flag>0)
                        {
                            Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                        }
                        startActivity(intentstaff);

                    }*/
                    db.close();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Passwords Do Not Match",Toast.LENGTH_LONG).show();
                }



            }
        });

    }

}
