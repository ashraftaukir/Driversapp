package com.webxzen.driversapp;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class HomeScreenActivity extends AppCompatActivity/* implements OnMapReadyCallback, LocationListener*/ {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homescreenactivity);


    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//
//
//        //  Toast.makeText(getApplicationContext(), "onmap", Toast.LENGTH_SHORT).show();
//
//        LatLng sydney = new LatLng(-33.852, 151.211);
//        googleMap.addMarker(new MarkerOptions().position(sydney)
//                //        .title("Marker in Sydney")
//
//
//        );
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
//
//
//        // Log.d("onLocationChanged", "onLocationChanged: ");
//        //double lat = location.getLatitude();
//        //double lng = location.getLongitude();
//
//    }
}
