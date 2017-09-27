package com.webxzen.driversapp.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import com.webxzen.driversapp.R;
import com.webxzen.driversapp.model.LoginModel;
import com.webxzen.driversapp.util.DBHelper;
import com.webxzen.driversapp.util.DialogUtil;
import com.webxzen.driversapp.util.PreferenceHelper;


public class BaseFragment extends Fragment {

    public DialogUtil dialogUtil;
    public LoginModel loginModel;
    protected PreferenceHelper preferenceHelper;

    private Context context;

    public BaseFragment thisFrag = this;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialogUtil = new DialogUtil(getActivity());
        preferenceHelper = new PreferenceHelper(getActivity());
       // loginModel = DBHelper.getSavedLogin();


        context = getActivity();
//        thisFrag = this;


    }

    public boolean isNetworkAvailable() {
        if (getActivity() != null) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        } else
            return false;
    }

    public void showLoadingDialog(final boolean isLoad) {
        final ProgressDialog prog = new ProgressDialog(getActivity());//Assuming that you are using fragments.
        prog.setTitle(getString(R.string.please_wait));
        prog.setMessage(getString(R.string.loading));
        prog.setCancelable(false);
        prog.setIndeterminate(true);
        prog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        if (isLoad) {
            prog.show();
        } else {
            prog.hide();
        }
    }

    protected boolean isEmpty(EditText editText) {

        String value = editText.getText().toString();

        if (value.trim().length() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public void addFragment(Fragment fragment, String id, String oldId, int resId) {
       getFragmentManager()
                .beginTransaction()
                .add(resId, fragment, id)
                .addToBackStack(oldId)
                .commit();
    }

    public void replaceFragment(Fragment fragment, String id, String oldId, int resId) {
        getFragmentManager()

                .beginTransaction()
                .replace(resId, fragment, id)
                .addToBackStack(oldId)
                .commit();
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
