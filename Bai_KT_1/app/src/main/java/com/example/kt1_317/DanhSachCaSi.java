package com.example.kt1_317;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DanhSachCaSi extends AppCompatActivity {
    ListView listView;
    ArrayList<Casi> arrayList;
    CaSiApdater caSiApdater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_ca_si);
        anhXa();
        CaSiApdater caSiApdater  = new CaSiApdater(this , arrayList, R.layout.item_casi);
        listView.setAdapter(caSiApdater);
        listView = (ListView) findViewById(R.id.listView);
    }

    private void anhXa(){
        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add(new Casi("Nguyễn Thanh Tùng","Sơn Tùng MTP",R.drawable.st));
        arrayList.add(new Casi("Bùi Anh Tuấn","Bùi Anh Tuấn",R.drawable.bat));
        arrayList.add(new Casi("Lê Trung Thành","Erik",R.drawable.erik));
        arrayList.add(new Casi("Nguyễn Minh Hằng","Min",R.drawable.min));
    }
}