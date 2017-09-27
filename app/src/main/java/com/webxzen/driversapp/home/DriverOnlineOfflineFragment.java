package com.webxzen.driversapp.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;
import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseFragment;
import com.webxzen.driversapp.util.Appinfo;


public class DriverOnlineOfflineFragment extends BaseFragment implements View.OnClickListener {

    View view;
    Button myprofilebutton;
    TextView driverstatustv;
    SwipeButton swipeButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.driveronlineoffline, container, false);
        String tittle = "DRIVER STATUS";
        actionbarSetup(tittle);
        initialization();
        initListeners();
        return view;
    }

    private void initListeners() {
        myprofilebutton.setOnClickListener(this);
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {

                if (active) {
                    driverstatustv.setText(getString(R.string.online));

                } else {
                    driverstatustv.setText(getString(R.string.offline));

                }
            }
        });
    }

    private void initialization() {

        swipeButton = (SwipeButton) view.findViewById(R.id.goOnlineBtn);
        myprofilebutton = (Button) view.findViewById(R.id.myprofilebtn);
        driverstatustv = (TextView) view.findViewById(R.id.driverstatustv);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.myprofilebtn:
                replaceFragment(new DriverProfileFragment(), Appinfo.DRIVER_ONLINE_OFFLINE_FRAGMENT
                        , Appinfo.DRIVER_PROFILE_FRAGMENT, R.id.homescreen_fragment_container);
                break;

            default:
                break;
        }
    }
}
