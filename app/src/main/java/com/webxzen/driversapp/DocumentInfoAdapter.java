package com.webxzen.driversapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DocumentInfoAdapter extends RecyclerView.Adapter<DocumentInfoAdapter.MyViewHolder> {

    private ArrayList<String> documnetlist;
    private CustomItemClickListener listener;


    public DocumentInfoAdapter(ArrayList<String> documnetlist, CustomItemClickListener listener) {
        this.documnetlist = documnetlist;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.documents_list, parent, false);
        final MyViewHolder mViewHolder = new MyViewHolder(itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getPosition());
            }
        });
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
