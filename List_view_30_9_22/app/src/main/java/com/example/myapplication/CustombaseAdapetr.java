package com.example.myapplication;

import android.companion.WifiDeviceFilter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;


import java.util.ArrayList;
import java.util.List;

public class CustombaseAdapetr extends BaseAdapter {

    Context context;
    private List<DienThoai> listDT;
    private int latout;


    public CustombaseAdapetr() {
    }

    public CustombaseAdapetr(Context context, List<DienThoai> listDT, int latout) {
        this.context = context;
        this.listDT = listDT;
        this.latout = latout;
    }

    @Override
    public int getCount() {
        return listDT.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView img;
        TextView ten;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
            if (view == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(latout, null);
                viewHolder = new ViewHolder();
                viewHolder.ten = (TextView) view.findViewById(R.id.textView);
                viewHolder.img = (ImageView) view.findViewById(R.id.image);

               view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
        DienThoai dienThoai = listDT.get(i);
        viewHolder.ten.setText(dienThoai.getTenMay());
        viewHolder.img.setImageResource(dienThoai.getImg());
         return view   ;
    }
}
