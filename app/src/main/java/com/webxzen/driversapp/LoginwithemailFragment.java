package com.webxzen.driversapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginwithemailFragment extends Fragment implements View.OnClickListener {


    View view;
    TextView forgotpass;
    Button applicationlogin;
    EditText emailaddress,loginpassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.loginwithemail, container, false);
        initialization();
        initializeListener();
        return view;
    }

    private void initializeListener() {

        forgotpass.setOnClickListener(this);
        applicationlogin.setOnClickListener(this);
    }

    private void initialization() {
        applicationlogin = (Button) view.findViewById(R.id.apploginbtn);
        forgotpass = (TextView) view.findViewById(R.id.forgotpassword);
        emailaddress = (EditText) view.findViewById(R.id.emailet);
        loginpassword = (EditText) view.findViewById(R.id.passwordet);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgotpassword:
                gotoforgotpasswordPage();
                break;
            case R.id.apploginbtn:
               gotoValidationProcess();
               break;
            default:
                break;
        }
    }

    private void gotoValidationProcess() {

        String email=emailaddress.getText().toString();
        int password=loginpassword.getText().toString().length();
        if(isValidEmail(email)&&password>3){
            gotohomePage();
        }else{
            Toast.makeText(getContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }

    }

    private void gotohomePage() {

        Intent i = new Intent(getActivity(), HomeScreenActivity.class);
        startActivity(i);
    }

    private void gotoforgotpasswordPage() {

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ForgotpasswordFragment()).addToBackStack(null).commit();

    }

    public  static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


}
