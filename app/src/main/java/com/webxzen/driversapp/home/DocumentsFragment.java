package com.webxzen.driversapp.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.webxzen.driversapp.R;

import java.util.ArrayList;


public class DocumentsFragment extends Fragment implements View.OnClickListener {

    RecyclerView docrecylerview;

    DocumentInfoAdapter docadpater;
    View view;
    ArrayList<String> list;
    Button continuebtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.documents, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("DOCUMENTS");
        addingDocumentsinfo();
        initialization();
        initListeners();
        addOnItemTouchListener();
        return view;

    }

    private void initListeners() {

        continuebtn.setOnClickListener(this);
    }

    private void addOnItemTouchListener() {

        docrecylerview.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        gotoDocumentItemFragment(position);
                    }

                }));
    }

    private void addingDocumentsinfo() {

        list = new ArrayList<String>();
        list.add("Driver's License");
        list.add("NID Front Side");
        list.add("Vehicle Certification of Fitness");
        list.add("Vehicle Tax Token");
        list.add("Vehicle Registration");

    }

    private void initialization() {

        continuebtn=(Button)view.findViewById(R.id.continuebtn);
        docrecylerview = (RecyclerView) view.findViewById(R.id.docrecylerView);
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


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.continuebtn:
                getFragmentManager().beginTransaction().replace(R.id.homescreen_fragment_container,
                        new DriveronlineofflineFragment()).addToBackStack(null).commit();


                break;


            default:
                break;



        }

    }
}
