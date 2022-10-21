package com.example.btgk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhimAdapter extends RecyclerView.Adapter<PhimAdapter.myviewholder> {
    ArrayList<Phim> dataholder;

    public PhimAdapter(ArrayList<Phim> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public PhimAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.desgin_row_phim,parent,false);
        return new myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PhimAdapter.myviewholder holder, int position) {
        holder.img.setImageResource(dataholder.get(position).getImg());
        holder.tenPhim.setText(dataholder.get(position).getTenPhim());
        holder.gthPhim.setText(dataholder.get(position).getGthPhim());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView tenPhim,gthPhim;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.img1);
            tenPhim=itemView.findViewById(R.id.t1);
            gthPhim=itemView.findViewById(R.id.t2);
        }
    }
}
