package com.webxzen.driversapp;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class DocumentsFragment extends Fragment {

    RecyclerView docrecylerview;

    DocumentInfoAdapter docadpater;
    View view;
    ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.documents, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DOCUMENTS");
        addingdocumentsinfo();
        initialization();
        return view;

    }

    private void addingdocumentsinfo() {

        list = new ArrayList<String>();
        list.add("Driver's License");
        list.add("NID Front Side");
        list.add("Vehicle Certification of Fitness");
        list.add("Vehicle Tax Token");
        list.add("Vehicle Registration");

    }

    private void initialization() {
        docrecylerview = (RecyclerView) view.findViewById(R.id.docrecylerView);

        docrecylerview.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        // Log.d("position", list.get(position) );
                        gotoDocumentItemFragment(position);
                    }


                }));

        docadpater = new DocumentInfoAdapter(list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        docrecylerview.setLayoutManager(mLayoutManager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(docrecylerview.getContext(),
                mLayoutManager.getOrientation());
        docrecylerview.addItemDecoration(mDividerItemDecoration);
        docrecylerview.setAdapter(docadpater);


    }

    private void gotoDocumentItemFragment(int position) {
        DocumentItemFragment documentitemfragment = new DocumentItemFragment();
        Bundle args = new Bundle();
        args.putString("adapterValue", list.get(position));
        documentitemfragment.setArguments(args);
        getFragmentManager().beginTransaction().replace(R.id.homescreen_fragment_container, documentitemfragment).addToBackStack(null).commit();

    }


}
