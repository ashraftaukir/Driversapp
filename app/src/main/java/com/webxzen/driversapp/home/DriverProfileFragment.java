package com.webxzen.driversapp.home;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


import com.webxzen.driversapp.R;
import com.webxzen.driversapp.base.BaseFragment;


public class DriverProfileFragment extends BaseFragment {

    View view;
    RecyclerView driverProfileRecylerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.driverprofile, container, false);
        String tittle = "DRIVER PROFILE";
        actionbarSetup(tittle);
        initialization();
        return view;
    }

    private void initialization() {
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(R.color.colorBlack),
                PorterDuff.Mode.SRC_ATOP);
    }
}
