package com.webxzen.driversapp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseFragment;


public class LandingPageFragment extends BaseFragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.landingpage, container, false);
        String tittle = "THANK YOU";
        actionbarSetup(tittle);
        return view;


    }
}
