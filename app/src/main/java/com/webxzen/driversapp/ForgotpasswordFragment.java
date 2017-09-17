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

import com.facebook.login.LoginManager;

import java.util.Arrays;


public class ForgotpasswordFragment extends Fragment implements View.OnClickListener{

    View view;
    EditText emailorphonenumber;
    Button sendbutton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.forgotpassword, container, false);
        initialization();
        return view;

    }

    private void initialization() {

        emailorphonenumber=(EditText)view.findViewById(R.id.emailorphoneet);
        sendbutton=(Button) view.findViewById(R.id.sendbtn);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sendbtn:
                gotoValidationProcess();
                break;

            default:
                break;
        }

    }

    private void gotoValidationProcess() {

        String emailorphone=emailorphonenumber.getText().toString();
      if(isValidEmail(emailorphone)||(emailorphone.length()==11)){

          Toast.makeText(getContext(), "Sending u message", Toast.LENGTH_SHORT).show();

      }else{
          Toast.makeText(getContext(), "Check your email or phonenumber", Toast.LENGTH_SHORT).show();
      }

    }

    public  static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
