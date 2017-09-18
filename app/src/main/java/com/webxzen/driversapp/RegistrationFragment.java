package com.webxzen.driversapp;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
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
    TextInputLayout textInputLayoutfullname, textInputLayoutemailaddress,
            textInputLayoutphonenumber, textInputLayoutpassword;
    ;


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
        textInputLayoutfullname = (TextInputLayout) view.findViewById(R.id.fullnameet);
        textInputLayoutemailaddress = (TextInputLayout) view.findViewById(R.id.emailaddresset);
        textInputLayoutphonenumber = (TextInputLayout) view.findViewById(R.id.phoneinfoet);
        textInputLayoutpassword = (TextInputLayout) view.findViewById(R.id.passwordet);
        fullname = (EditText) view.findViewById(R.id.fullnameedittext);
        email = (EditText) view.findViewById(R.id.emailaddressedittext);
        phonenumber = (EditText) view.findViewById(R.id.phoneinfoedittext);
        password = (EditText) view.findViewById(R.id.passwordedittext);

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

        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }
        if (!validatePhoneNumber()) {
            return;
        }

        gotologinPage();

    }

    private boolean validateName() {

        boolean driverfullname = fullname.getText().toString().trim().isEmpty();
        if (driverfullname) {
            textInputLayoutfullname.setHintTextAppearance(R.style.Active);
            Toast.makeText(getContext(), "Please select your full name", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateEmail() {

        String driveremailaddress = email.getText().toString();
        if (driveremailaddress.isEmpty() || !isValidEmail(driveremailaddress)) {
            textInputLayoutemailaddress.setHintTextAppearance(R.style.Active);
            Toast.makeText(getContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber() {

        boolean driverphonenumber = phonenumber.getText().toString().trim().isEmpty();
        if (driverphonenumber) {
            textInputLayoutphonenumber.setHintTextAppearance(R.style.Active);
            Toast.makeText(getContext(), "Please select your phonenumber", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validatePassword() {

        int driverpassword = password.getText().toString().length();
        if (driverpassword < 4) {
            textInputLayoutpassword.setHintTextAppearance(R.style.Active);
            Toast.makeText(getContext(), "Atleast 4 character", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void gotologinPage() {

        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new LoginwithemailFragment()).addToBackStack(null).commit();
    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
