package com.example.kt1_317;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CaSiApdater extends BaseAdapter {
    Context context;
    private List<Casi> listCaSi;
    private int layout;

    public CaSiApdater(Context context, List<Casi> listCaSi, int layout) {
        this.context = context;
        this.listCaSi = listCaSi;
        this.layout = layout;
    }

    public CaSiApdater() {
    }

    @Override
    public int getCount() {
        return listCaSi.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tenCaSi = (TextView) view.findViewById(R.id.tenThat);
            viewHolder.tenNgheDanh = (TextView) view.findViewById(R.id.TenNgheDanh);
            viewHolder.img = (ImageView) view.findViewById(R.id.imgCasi);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Casi casi = listCaSi.get(i);
        viewHolder.tenCaSi.setText(casi.getTenCaSi());
        viewHolder.tenNgheDanh.setText(casi.getTenNgheDanh());
        viewHolder.img.setImageResource(casi.getImg());
        return view  ;
    }

    private class ViewHolder{
        ImageView img;
        TextView tenCaSi;
        TextView tenNgheDanh;
    }
}
