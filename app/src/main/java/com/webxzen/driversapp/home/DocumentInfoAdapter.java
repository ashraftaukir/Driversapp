package com.webxzen.driversapp.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webxzen.driversapp.R;

import java.util.ArrayList;


public class DocumentInfoAdapter extends RecyclerView.Adapter<DocumentInfoAdapter.MyViewHolder> {

    private ArrayList<String> documnetlist;


    public DocumentInfoAdapter(ArrayList<String> documnetlist) {
        this.documnetlist = documnetlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.documents_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.documentlistItem.setText(documnetlist.get(position));
    }

    @Override
    public int getItemCount() {
        return documnetlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView documentlistItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            documentlistItem = (TextView) itemView.findViewById(R.id.documentlistItem);
        }


    }
}
