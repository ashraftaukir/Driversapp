package com.webxzen.driversapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RegistrationFragment extends Fragment implements View.OnClickListener {

    View view;
    Button signupbtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.registrationscreen, container, false);
        initialization();
        initiaLizeListener();
        return view;
    }

    private void initiaLizeListener() {
    signupbtn.setOnClickListener(this);

    }

    private void initialization() {
    signupbtn=(Button)view.findViewById(R.id.signup);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.signup:
                gotologinPage();
                break;

            default:
                break;
        }

    }

    private void gotologinPage() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginwithemailFragment()).addToBackStack(null).commit();


    }
}
