package com.webxzen.driversapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.webxzen.driversapp.api.AuthAPI;
import com.webxzen.driversapp.api.RetrofitService;
import com.webxzen.driversapp.home.HomeScreenActivity;
import com.webxzen.driversapp.R;
import com.webxzen.driversapp.model.AuthModel;
import com.webxzen.driversapp.base.BaseFragment;
import com.webxzen.driversapp.model.LoginModel;
import com.webxzen.driversapp.util.Appinfo;
import com.webxzen.driversapp.util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginwithemailFragment extends BaseFragment implements View.OnClickListener {


    View view;
    TextView forgotpass;
    Button applicationlogin;
    EditText emailaddress,loginpassword;
    TextInputLayout textInputemailLayout,textInputpasswordLayout;
    private AuthAPI authAPI;

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
        emailaddress = (EditText) view.findViewById(R.id.emailedittext);
        loginpassword = (EditText) view.findViewById(R.id.passwordedittext);
        textInputemailLayout = (TextInputLayout) view.findViewById(R.id.emailet);
        textInputpasswordLayout = (TextInputLayout) view.findViewById(R.id.passwordet);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authAPI = RetrofitService.createService(AuthAPI.class, getString(R.string.api_server_url),
                false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgotpassword:
                gotoForgotpasswordPage();
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
            gotohomePage(email);
        }else{
            Toast.makeText(getContext(), "Incorrect email or password", Toast.LENGTH_SHORT).show();
        }

    }

    private void gotohomePage(String emailAddress) {

        String password = loginpassword.getText().toString();

        if (emailAddress.isEmpty()) {
            Toast.makeText(getActivity(), "Empty email or password", Toast.LENGTH_SHORT).show();

        } else if (password.isEmpty() || (password.length()) < 4) {
            Toast.makeText(getActivity(), "Empty password!!! Password should be 4 character atleast",
                    Toast.LENGTH_SHORT).show();

        } else {

            if (isNetworkAvailable()) {

                dialogUtil.showProgressDialog();
                String deviceToken = Utils.getDeviceId(getActivity());
                Call<AuthModel> emailLogin = authAPI.emaillogin(Appinfo.CLIENT_ID, Appinfo.CLIENT_SECRET,
                        Appinfo.SCOPE, Appinfo.PLATFORM, deviceToken, emailAddress, password);

                emailLogin.enqueue(new Callback<AuthModel>() {
                    @Override
                    public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {

                        if (dialogUtil != null) {

                            dialogUtil.dismissProgress();

                        }
                        if (response.isSuccessful()) {
                            if (response.body().success) {
                                LoginModel loginModel = response.body().data.login;
                                if (loginModel != null) {
//                                    if (DBHelper.saveLogin(loginModel)) {
                                        startActivity(new Intent(getActivity(), HomeScreenActivity.class));
                                        getActivity().finish();
//                                    }
                                }
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<AuthModel> call, Throwable t) {
                        if (dialogUtil != null) {
                            dialogUtil.dismissProgress();
                        }
                        Toast.makeText(getActivity(), "Testing error", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {

                dialogUtil.showDialogOk(getString(R.string.no_internet));
            }
        }


    }

    private void gotoForgotpasswordPage() {

        replaceFragment(new ForgotpasswordFragment(), Appinfo.FORGOTPASSWORD_FRAGMENT,Appinfo.LOGIN_WITH_EMAIL_FRAGMENT,R.id.fragment_container);
    }

    public  static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


}
