package com.webxzen.driversapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;

import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseActivity;
import com.webxzen.driversapp.util.Appinfo;

public class MainActivity extends BaseActivity {

    FrameLayout fragmentcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentcontainer = (FrameLayout) findViewById(R.id.fragment_container);
        initFragment(new LoginFragment(), Appinfo.LOGIN_FRAGMENT,fragmentcontainer.getId());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentById(fragmentcontainer.getId());
        fragment.onActivityResult(requestCode, resultCode, data);


    }
}
