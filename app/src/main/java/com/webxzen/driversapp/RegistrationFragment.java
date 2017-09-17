package com.webxzen.driversapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationFragment extends Fragment implements View.OnClickListener {

    View view;
    Button signupbtn;
    EditText fullname, email, phonenumber, password;


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
        signupbtn = (Button) view.findViewById(R.id.signup);
        fullname = (EditText) view.findViewById(R.id.fullnameet);
        email = (EditText) view.findViewById(R.id.emailaddresset);
        phonenumber = (EditText) view.findViewById(R.id.phoneinfoet);
        password = (EditText) view.findViewById(R.id.passwordet);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.signup:
                gotoValidationProcess();
                break;

            default:
                break;
        }

    }

    private void gotoValidationProcess() {

        String driverfullname = fullname.getText().toString();
        String driveremailaddress = email.getText().toString();
        int driverphonenumber = phonenumber.getText().toString().length();
        int driverpassword = password.getText().toString().length();

        if (driverfullname.length() > 2) {
            if (isValidEmail(driveremailaddress)) {
                if (driverphonenumber == 11) {
                    if (driverpassword > 3) {
                        gotologinPage();

                    } else {
                        password.setError("At least 4 character");
                    }

                } else {
                    phonenumber.setError("Use 11 character");

                }

            } else {
                email.setError("Invalid email address");
            }
        } else {

            fullname.setError("atleast 3 character");
        }


    }

    private void gotologinPage() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginwithemailFragment()).addToBackStack(null).commit();


    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
