package com.webxzen.driversapp;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class HomeScreenActivity extends AppCompatActivity {


    FrameLayout fragmentcontainer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homescreenactivity);
        fragmentcontainer = (FrameLayout) findViewById(R.id.homescreen_fragment_container);
        fragmenttransition();

    }

    private void fragmenttransition() {

        getFragmentManager().beginTransaction().replace(R.id.homescreen_fragment_container, new DocumentsFragment()).addToBackStack(null).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;

    }
}
