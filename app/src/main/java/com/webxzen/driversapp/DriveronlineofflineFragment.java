package com.webxzen.driversapp;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DriveronlineofflineFragment extends Fragment implements View.OnClickListener {

    View view;
    Button goonlinebtn, myprofilebutton;
    TextView driverstatustv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.driveronlineoffline, container, false);
        initialization();
        initListeners();
        return view;
    }

    private void initListeners() {
        goonlinebtn.setOnClickListener(this);
        myprofilebutton.setOnClickListener(this);
    }

    private void initialization() {

        goonlinebtn = (Button) view.findViewById(R.id.goonlinebtn);
        myprofilebutton = (Button) view.findViewById(R.id.myprofilebtn);
        goonlinebtn.setBackgroundColor(Color.RED);
        driverstatustv = (TextView) view.findViewById(R.id.driverstatustv);
        driverstatustv.setText("You are now offline");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.goonlinebtn:
                goonlinebtn.setBackgroundColor(Color.RED);
                driverstatustv.setText("You are now online");
                break;
            case R.id.myprofilebtn:
                getFragmentManager().beginTransaction().replace(R.id.homescreen_fragment_container,
                        new DriverProfileFragment()).addToBackStack(null).commit();

                break;

            default:
                break;
        }
    }
}
