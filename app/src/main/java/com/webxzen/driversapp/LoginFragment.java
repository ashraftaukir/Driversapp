package com.webxzen.driversapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;


import java.util.Arrays;


public class LoginFragment extends Fragment implements View.OnClickListener {


    Button loginwithfbbtn, loginwitheamilbtn;
    TextView registrationtv;
    CallbackManager callbackManager;


    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        view = inflater.inflate(R.layout.loginscreen, container, false);
        initialization();
        listeners();
        fbloginprocess();
        return view;
    }

    private void fbloginprocess() {

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent i = new Intent(getActivity(), HomeScreenActivity.class);
                startActivity(i);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void listeners() {
        loginwitheamilbtn.setOnClickListener(this);
        loginwithfbbtn.setOnClickListener(this);
        registrationtv.setOnClickListener(this);
    }

    private void initialization() {
        loginwitheamilbtn = (Button) view.findViewById(R.id.loginwithemail);
        loginwithfbbtn = (Button) view.findViewById(R.id.loginwithfb);
        registrationtv = (TextView) view.findViewById(R.id.register);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginwithemail:
                gotologinwithEmailPage();
                break;

            case R.id.loginwithfb:
                LoginManager.getInstance().logInWithReadPermissions(getActivity(), Arrays.asList("public_profile"));
                break;

            case R.id.register:
                gotoregisterPage();
                break;

            default:
                break;
        }
    }

    private void gotoregisterPage() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegistrationFragment()).addToBackStack(null).commit();

    }

    private void gotologinwithEmailPage() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginwithemailFragment()).addToBackStack(null).commit();

    }


}