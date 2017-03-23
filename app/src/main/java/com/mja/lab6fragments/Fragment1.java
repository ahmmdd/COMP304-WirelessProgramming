package com.mja.lab6fragments;

/**
 * Created by MohammedJuned on 2016-10-24.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_fragment1, container, false);
        Button submitButton = (Button) view.findViewById(R.id.submitFragment1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox option1 = (CheckBox) getActivity().findViewById(R.id.option1);
                Toast.makeText(getActivity(), "Checkbox one isChecked=" + option1.isChecked(), Toast.LENGTH_LONG).show();
                // here you may start the next activity

                Intent intent = new Intent(getActivity().getApplicationContext(), Activity2.class);
                //add whatever data you want to pass to Activity2
                //intent.putExtra(...);
                startActivity(intent);
            }
        });
        return view;
    }
}
