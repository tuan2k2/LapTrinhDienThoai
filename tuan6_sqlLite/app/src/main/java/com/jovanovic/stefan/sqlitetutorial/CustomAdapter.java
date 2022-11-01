package com.jovanovic.stefan.sqlitetutorial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList computer_id, tenMay, giaTien;

    public CustomAdapter(Context context, Activity activity, ArrayList computer_id, ArrayList tenMay, ArrayList giaTien) {
        this.context = context;
        this.activity = activity;
        this.computer_id = computer_id;
        this.tenMay = tenMay;
        this.giaTien = giaTien;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.computer_id.setText(String.valueOf(computer_id.get(position)));
        holder.tenMay.setText(String.valueOf(tenMay.get(position)));
        holder.soTien.setText(String.valueOf(giaTien.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("computer_id", String.valueOf(computer_id.get(position)));
                intent.putExtra("tenMay", String.valueOf(tenMay.get(position)));
                intent.putExtra("giaTien", String.valueOf(giaTien.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return computer_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView computer_id, tenMay, soTien;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            computer_id = itemView.findViewById(R.id.phim_id_txt);
            tenMay = itemView.findViewById(R.id.may_name_txt);
            soTien = itemView.findViewById(R.id.gia_tien_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
