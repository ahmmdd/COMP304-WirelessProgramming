package com.cc.mja.layoutandmenusample;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.frame_layout_lab);
        //setContentView(R.layout.linear_layout_lab);
        //setContentView(R.layout.relative_layout_lab);
        setContentView(R.layout.table_layout_lab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.app.FragmentManager fm = getFragmentManager();
        switch (item.getItemId()) {

            case R.id.option1:
                Toast.makeText(this.getBaseContext(), "Selected First Option!", Toast.LENGTH_LONG).show();
                return true;

            case R.id.option2:
                Toast.makeText(this.getBaseContext(), "Selected Second Option!", Toast.LENGTH_LONG).show();
                return true;

            case R.id.option3:
                Toast.makeText(this.getBaseContext(), "Selected Third Option!", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
