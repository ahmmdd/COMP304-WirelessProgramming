package com.mja.mohammedahmedlab4_ex1;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registerbutton = (Button) findViewById(R.id.btnRegister);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        final DBAdapter db=new DBAdapter(this);
        final EditText username=(EditText)findViewById(R.id.tvUsername);
        final EditText password=(EditText) findViewById(R.id.tvPassword);

        Button loginbutton = (Button) findViewById(R.id.btnLogin);
        final Intent doctorintent=new Intent(MainActivity.this,DoctorActivity.class);
        final Intent staffintent=new Intent(MainActivity.this,StaffActivity.class);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if((username.getText().toString()).equals(null)||(password.getText().toString()).equals(null))
                {
                    Toast.makeText(getApplicationContext(),"CANNOT LEAVE MANDATORY FIELDS EMPTY",Toast.LENGTH_LONG).show();
                }
                else
                {
                    db.open();
                    // Toast.makeText(getApplicationContext(),user+"\n"+pass,Toast.LENGTH_LONG).show();
                    Cursor c=db.getUser(user,pass);
                    if (c.moveToFirst())
                    {
                        do {
                            String pos=(c.getString(c.getColumnIndex("position")));
                            switch (pos)
                            {
                                case "Doctor":
                                    startActivity(doctorintent);
                                    break;
                                case "Staff":
                                    startActivity(staffintent);
                                    break;
                            }
                        } while (c.moveToNext());
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"WRONG USERNAME/PASSWORD",Toast.LENGTH_LONG).show();
                    }
                }
                db.close();

            }
        });

    }
}
