package com.example.mrrobot.owner.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrrobot.owner.Owner;
import com.example.mrrobot.owner.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr Robot on 10/19/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewholder> {

    private List<Owner> list = new ArrayList<>();

    public RecyclerAdapter(List<Owner> list){
        this.list = list;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {

//        holder.Id.setText(Integer.toString(list.get(position).getID()));
//        holder.salonName.setText(list.get(position).getSALON_NAME());
//        holder.salonAddress.setText(list.get(position).getSALON_ADDRESS());
//        holder.managerName.setText(list.get(position).getMANAGER_NAME());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {


        TextView Id,salonName,salonAddress,managerName;

        public MyViewholder(View itemView) {
            super(itemView);
//            Id = (TextView)itemView.findViewById(R.id.id);
//            salonName = (TextView)itemView.findViewById(R.id.sName);
//            salonAddress = (TextView)itemView.findViewById(R.id.sAddress);
//            managerName = (TextView)itemView.findViewById(R.id.mUser);
        }
    }
}
