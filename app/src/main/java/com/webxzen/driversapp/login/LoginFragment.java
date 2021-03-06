package com.webxzen.driversapp.login;

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
import com.webxzen.driversapp.api.AuthAPI;
import com.webxzen.driversapp.api.RetrofitService;
import com.webxzen.driversapp.home.HomeScreenActivity;
import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseFragment;
import com.webxzen.driversapp.util.Appinfo;


import java.util.Arrays;


public class LoginFragment extends BaseFragment implements View.OnClickListener {


    Button loginwithfbbtn, loginwitheamilbtn;
    TextView registrationtv;
    CallbackManager callbackManager;
    private AuthAPI authAPI;



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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authAPI = RetrofitService.createService(AuthAPI.class, getString(R.string.api_server_url),
                false);

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
                gotoLoginwithEmailPage();
                break;

            case R.id.loginwithfb:
                LoginManager.getInstance().logInWithReadPermissions(getActivity(), Arrays.asList("public_profile"));
                break;

            case R.id.register:
                gotoRegisterPage();
                break;

            default:
                break;
        }
    }

    private void gotoRegisterPage() {

        replaceFragment(new RegistrationFragment(),
                Appinfo.REGISTER_FRAGMENT,Appinfo.LOGIN_FRAGMENT,R.id.fragment_container);
    }

    private void gotoLoginwithEmailPage() {
        replaceFragment(new LoginWithEmailFragment(),
                Appinfo.LOGIN_WITH_EMAIL_FRAGMENT,Appinfo.LOGIN_FRAGMENT,R.id.fragment_container);


    }


}