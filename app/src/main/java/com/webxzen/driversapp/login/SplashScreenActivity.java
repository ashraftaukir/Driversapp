package com.webxzen.driversapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseActivity;
import com.webxzen.driversapp.home.HomeScreenActivity;
import com.webxzen.driversapp.util.DBHelper;


public class SplashScreenActivity extends BaseActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        DBHelper.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                starOurApp();
            }
        }, 3000);

    }

    private void starOurApp() {
        if (DBHelper.getSavedLogin() != null) {
            startActivity(new Intent(this, HomeScreenActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }



    }
}
