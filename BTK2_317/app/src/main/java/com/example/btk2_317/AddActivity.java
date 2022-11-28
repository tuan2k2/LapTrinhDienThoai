package com.example.btk2_317;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText tenkhoahoc , tenthuonggoi , dactinh , mausac , hinhanh , hinhanhchichitiet ;
    Button add , back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        tenkhoahoc = (EditText) findViewById(R.id.tenkhoahocadd);
        tenthuonggoi = (EditText) findViewById(R.id.tenthuonggoiadd);
        dactinh = (EditText) findViewById(R.id.dactinhadd);
        mausac = (EditText) findViewById(R.id.mausacadd);
        hinhanh = (EditText) findViewById(R.id.hinhanhadd);
        hinhanhchichitiet = (EditText) findViewById(R.id.hinhanhchichitietadd);
        add = (Button) findViewById(R.id.btnSave);
        back = (Button) findViewById(R.id.btnBack);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void add(){
        Map<String ,Object> map = new HashMap<>();
        map.put("tenkhoahoc",tenkhoahoc.getText().toString());
        map.put("tenthuonggoi",tenthuonggoi.getText().toString());
        map.put("mausac",mausac.getText().toString());
        map.put("dactinh",dactinh.getText().toString());
        map.put("hinhanh",hinhanh.getText().toString());
        map.put("hinhanhchichitiet",hinhanhchichitiet.getText().toString());



        FirebaseDatabase.getInstance().getReference().child("fishManagement").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Add Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}