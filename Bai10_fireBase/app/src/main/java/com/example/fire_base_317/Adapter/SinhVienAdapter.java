package com.example.fire_base_317.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fire_base_317.Dao.*;
import com.example.fire_base_317.*;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;



public class SinhVienAdapter extends ArrayAdapter<SinhVien> {

    private Activity activity;
    private int resource;
    private List<SinhVien> objects;
    public SinhVienAdapter(@NonNull Activity activity, int resource, @NonNull List<SinhVien> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.activity.getLayoutInflater();
        View view = layoutInflater.inflate(this.resource , null);
        TextView txtMSV = view.findViewById(R.id.tv_maSV2);
        TextView txtTSV = view.findViewById(R.id.tv_tenSV2);
        TextView txtLop = view.findViewById(R.id.tvLop2);
        TextView txtNganh = view.findViewById(R.id.tvNganh2);
        TextView txtKhoa = view.findViewById(R.id.tvKhoa2);

        SinhVien  sinhVien = this.objects.get(position);

        txtMSV.setText(sinhVien.getMSV());
        txtTSV.setText(sinhVien.getTSV());
        txtLop.setText(sinhVien.getLop());
        txtNganh.setText(sinhVien.getNganh());
        txtKhoa.setText(sinhVien.getKhoa());

        ImageView btnMenu = view.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(activity,view);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId()==R.id.themSV){
                            Intent intent = new Intent(activity,ThemSV_317.class);
                            activity.startActivity(intent);
                        } else if (menuItem.getItemId()==R.id.suaThongTin){
                            Intent intent = new Intent(activity,UpdateSV.class);
                             intent.putExtra("SINHVIEN", sinhVien);
                            activity.startActivity(intent);
                        } else if (menuItem.getItemId()==R.id.Xoa){
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("QuanLySinhVien/SinhVien");
                            myRef.child(sinhVien.getId()).removeValue(new DatabaseReference.CompletionListener() {
                                @Override
                                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                    Toast.makeText(activity, "Delete Success "  ,Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        return false;
                    }
                });
                popupMenu.getMenuInflater().inflate(R.menu.my_menu,popupMenu.getMenu());

                try {
                    Field field = popupMenu.getClass().getDeclaredField("mPopup");
                    field.setAccessible(true);
                    Object popupMenuHelper = field.get(popupMenu);
                    Class<?> cls = Class.forName("com.android.internal.view.menu.menuPopupHelper");
                    Method method = cls.getDeclaredMethod("setForceShowIcon",new Class[]{boolean.class});
                    method.setAccessible(true);
                    method.invoke(popupMenuHelper,new Object[]{true});
                } catch (Exception e){
                    Log.d("MYTAG" , "onClick: " + e.toString());
                }
                popupMenu.show();
            }
        });
        return view;
    }
}
