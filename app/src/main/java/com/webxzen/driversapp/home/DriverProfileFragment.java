package com.webxzen.driversapp.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webxzen.driversapp.R;


public class DriverProfileFragment extends Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.driverprofile, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("PROFILE");
        return view;
    }
}
