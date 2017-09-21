package com.webxzen.driversapp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;

import com.webxzen.driversapp.R;
import com.webxzen.driversapp.home.DocumentsFragment;


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
