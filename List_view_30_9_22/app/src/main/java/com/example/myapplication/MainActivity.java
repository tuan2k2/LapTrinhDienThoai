package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<DienThoai> arrayList;
    CustombaseAdapetr couCustombaseAdapetr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        couCustombaseAdapetr  = new CustombaseAdapetr(this , arrayList, R.layout.activity_food_list_view);
        listView.setAdapter(couCustombaseAdapetr);
        listView = (ListView) findViewById(R.id.list_view_317);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final  int which_item = i;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("Bạn Muốn Xoá không ???")
                        .setMessage("Bạn muốn xoá chứ ??")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            arrayList.remove(which_item);
                            couCustombaseAdapetr.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("no" , null)
                        .show();
                return true;
            }
        });
    }

    private void anhXa(){
        listView = (ListView) findViewById(R.id.list_view_317);
        arrayList = new ArrayList<>();
        arrayList.add(new DienThoai("Nokia",R.drawable.nokia));
        arrayList.add(new DienThoai("Samsung",R.drawable.samsung));
        arrayList.add(new DienThoai("Vivo",R.drawable.vivo));
        arrayList.add(new DienThoai("Iphone",R.drawable.iphone ));
        arrayList.add(new DienThoai("Xiaomi",R.drawable.xiaomi));
        arrayList.add(new DienThoai("Nokia",R.drawable.nokia));
        arrayList.add(new DienThoai("Nokia",R.drawable.nokia));
    }


}