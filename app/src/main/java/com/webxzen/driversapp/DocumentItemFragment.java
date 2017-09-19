package com.webxzen.driversapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DocumentItemFragment extends Fragment {


    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.documentsitem, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DOCUMENTS");
       // initialization();

        return view;
    }
}
