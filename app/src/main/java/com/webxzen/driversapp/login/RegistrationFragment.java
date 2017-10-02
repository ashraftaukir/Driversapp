package com.webxzen.driversapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.webxzen.driversapp.api.AuthAPI;
import com.webxzen.driversapp.api.RetrofitService;
import com.webxzen.driversapp.base.BaseFragment;
import com.webxzen.driversapp.R;
import com.webxzen.driversapp.model.AuthModel;
import com.webxzen.driversapp.util.Appinfo;
import com.webxzen.driversapp.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends BaseFragment implements View.OnClickListener {

    View view;
    Button signupbtn;
    EditText fullname, email, phonenumber, password;
    TextInputLayout textInputLayoutfullname, textInputLayoutemailaddress,
            textInputLayoutphonenumber, textInputLayoutpassword;

    private AuthAPI authAPI;

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

        ApiCalling();
        //gotoHomeScreenActivity();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authAPI = RetrofitService.createService(AuthAPI.class, getString(R.string.api_server_url),
                false);

    }

    private void ApiCalling() {

        if (isNetworkAvailable()) {

            String driverfullname=fullname.getText().toString();
            String driveremailaddress=email.getText().toString();
            String driverpassword=password.getText().toString();
            String driverphonenumber=phonenumber.getText().toString();

            dialogUtil.showProgressDialog();
            String deviceToken = Utils.getDeviceId(getActivity());
            Call<AuthModel> register = authAPI.register(driverfullname, driveremailaddress,
                    driverpassword, driverphonenumber, deviceToken);

            register.enqueue(new Callback<AuthModel>() {
                @Override
                public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {

                    if (dialogUtil != null) {

                        dialogUtil.dismissProgress();

                    }
                    if (response.isSuccessful()) {

                        if (response.body().success) {
                            if (response.body().message != null) {
                                Toast.makeText(getContext(),
                                        response.body().message, Toast.LENGTH_SHORT).show();
                                gotoLoginFragment();

                            }

                        }

                    }
                }

                @Override
                public void onFailure(Call<AuthModel> call, Throwable t) {
                    if (dialogUtil != null) {
                        dialogUtil.dismissProgress();
                    }
                    Toast.makeText(getActivity(),getString(R.string.tryagain), Toast.LENGTH_SHORT).show();
                }
            });
        } else {

            dialogUtil.showDialogOk(getString(R.string.no_internet));
        }
    }

    private void gotoLoginFragment() {

        replaceFragment(new LoginWithEmailFragment(),
                Appinfo.REGISTER_FRAGMENT,
                Appinfo.LOGIN_WITH_EMAIL_FRAGMENT, R.id.fragment_container

        );

    }

    private boolean validateName() {

        boolean driverfullname = fullname.getText().toString().trim().isEmpty();
        if (driverfullname) {
           // textInputLayoutfullname.setHintTextAppearance(R.style.Active);
            Toast.makeText(getActivity(), "Please select your full name", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validateEmail() {

        String driveremailaddress = email.getText().toString();
        if (driveremailaddress.isEmpty() || !isValidEmail(driveremailaddress)) {
           // textInputLayoutemailaddress.setHintTextAppearance(R.style.Active);
            Toast.makeText(getActivity(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePhoneNumber() {

        int driverphonenumber = phonenumber.getText().toString().trim().length();
        if (driverphonenumber<1) {
            //textInputLayoutphonenumber.setHintTextAppearance(R.style.Active);
            Toast.makeText(getActivity(), "Please select your phonenumber", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private boolean validatePassword() {

        int driverpassword = password.getText().toString().length();
        if (driverpassword < 4) {
           // textInputLayoutpassword.setHintTextAppearance(R.style.Active);
            Toast.makeText(getActivity(), "Atleast 4 character", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

//    private void gotologinPage() {
//
//        getFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                new LoginWithEmailFragment()).addToBackStack(null).commit();
//    }


    @Override
    public void onResume() {
        super.onResume();
        fullname.setText("");
        email.setText("");
        phonenumber.setText("");
        password.setText("");

    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
