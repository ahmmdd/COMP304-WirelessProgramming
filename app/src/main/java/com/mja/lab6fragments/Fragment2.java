package com.mja.lab6fragments;

/**
 * Created by MohammedJuned on 2016-10-24.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Fragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_fragment2, container, false);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.RadioGroup01);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //implement the event handler method
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = (RadioButton) group.findViewById(checkedId);
                Toast.makeText(getActivity(), "Radio button selected is: " + selectedButton.getText(), Toast.LENGTH_LONG).show();

                // here you can create an intent and start activity 3
            }
        });

        return view;
    }
}
