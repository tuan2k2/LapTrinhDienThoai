package com.example.fire_base_317;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fire_base_317.Adapter.*;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.fire_base_317.Dao.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DanhSachSinhVien extends AppCompatActivity {
    private  ArrayList<SinhVien> sinhVienArrayList;
    private ListView listView;
    private SinhVienAdapter sinhVienAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_sinh_vien);
        ListView listView = (ListView) findViewById(R.id.listV);
       sinhVienArrayList = new ArrayList<>();
       getData();
        sinhVienArrayList.add(new SinhVien("1","2050531200111","Nguyễn Văn Thọ" , "20T1" , "Công nghệ Thông tin","Công nghệ số"));
        sinhVienArrayList.add(new SinhVien("2","2050531200222","Nguyễn Văn Hùng" , "20T2" , "Công nghệ Thông tin","Công nghệ số"));
        sinhVienArrayList.add(new SinhVien("3","2050531200333","Nguyễn Văn Huy" , "20T3" , "Công nghệ Thông tin","Công nghệ số"));
        sinhVienArrayList.add(new SinhVien("4","2050531200320","Trần Anh Tân" , "20T3" , "Công nghệ Thông tin","Công nghệ số"));
        sinhVienArrayList.add(new SinhVien("5","2050531200321","Trần Anh Tủn" , "20T3" , "Công nghệ Thông tin","Công nghệ số"));
       sinhVienAdapter = new SinhVienAdapter(this,R.layout.activity_danh_sach_sinh_vien_item,sinhVienArrayList);
        listView.setAdapter(sinhVienAdapter);
    }

    private  void getData(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("SinhVien");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sinhVienAdapter.clear();
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    SinhVien sinhVien = dataSnapshot.getValue(SinhVien.class);
                   sinhVien.setId(dataSnapshot.getKey());
                   sinhVienAdapter.add(sinhVien);
                    Log.d("MYTAG" , "onDataChange : " + sinhVien.getTSV());
                }
                Toast.makeText(getApplicationContext(), "Load Data Success" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Load Data failed" + error.toString() ,Toast.LENGTH_SHORT).show();
                Log.d("MYTAG" , "onCancelled : " + error.toString());
            }
        });
    }
}