package com.example.fire_base_317;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fire_base_317.Dao.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fire_base_317.Dao.SinhVien;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateSV extends AppCompatActivity {
    private EditText updateMSV , updateTSV , updateLop , updateNganh , updateKhoa;
    private Button btnBack , btnCancel , btnUpdate;
    private  SinhVien sinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sv);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sinhVien != null) {
                    updateMSV.setText(sinhVien.getMSV()+"");
                    updateTSV.setText(sinhVien.getTSV());
                    updateLop.setText(sinhVien.getLop());
                    updateNganh.setText(sinhVien.getNganh());
                    updateKhoa.setText(sinhVien.getKhoa());
                } else {
                    Toast.makeText(getApplicationContext(), "Lỗi Khi load dữ liệu", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msv = updateMSV.getText().toString();
                String tsv = updateTSV.getText().toString();
                String lop = updateLop.getText().toString();
                String nganh = updateNganh.getText().toString();
                String khoa = updateKhoa.getText().toString();
                String id = sinhVien.getId();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("QuanLySinhVien/SinhVien");
                myRef.child(id).child("MSV").setValue(msv);
                myRef.child(id).child("TSV").setValue(tsv);
                myRef.child(id).child("Lop").setValue(lop);
                myRef.child(id).child("Nganh").setValue(nganh);
                myRef.child(id).child("Khoa").setValue(khoa);
                finish();
                Toast.makeText(getApplicationContext(), "Update Success", Toast.LENGTH_LONG).show();
            }
        });

    }
    private void addControls(){
        updateMSV = (EditText) findViewById(R.id.editTextUpdateMSV);
        updateTSV = (EditText) findViewById(R.id.editTextUpdateTSV);
        updateLop = (EditText) findViewById(R.id.editTextUpdateLop);
        updateNganh = (EditText) findViewById(R.id.editTextUpdateNganh);
        updateKhoa = (EditText) findViewById(R.id.editTextUpdateKhoa);
        btnUpdate = (Button) findViewById(R.id.btn_update_Add);
        btnCancel = (Button) findViewById(R.id.btn_update_Cancel);
        btnBack = (Button) findViewById(R.id.btn_update_back);
        Intent intent = getIntent();
        //truyền khóa vừa nãy vào
        sinhVien = (SinhVien) intent.getSerializableExtra("SINHVIEN");
        if(sinhVien!= null){
            //đưa thông tin sinh viên lên editText
            updateMSV.setText(sinhVien.getMSV());
            updateTSV.setText(sinhVien.getTSV());
            updateLop.setText(sinhVien.getLop());
            updateNganh.setText(sinhVien.getNganh());
            updateKhoa.setText(sinhVien.getKhoa());
        }
        else{
            Toast.makeText(this,"Lỗi khi load dữ liệu sinh viên",Toast.LENGTH_LONG).show();
        }
    }
}