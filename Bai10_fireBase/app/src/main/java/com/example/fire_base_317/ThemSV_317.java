package com.example.fire_base_317;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fire_base_317.Dao.*;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemSV_317 extends AppCompatActivity {
    private EditText editMSV , editTSV , editLop , editNganh , editKhoa;
    private Button btnBack , btnCancel , btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sv317);
        addControls();
        addEvents();
    }

    private void addEvents(){
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });


            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editMSV.setText("");
                    editTSV.setText("");
                    editLop.setText("");
                    editNganh.setText("");
                    editKhoa.setText("");
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String MSV = editMSV.getText().toString();
                    String TSV = editTSV.getText().toString();
                    String Lop = editLop.getText().toString();
                    String Nganh = editNganh.getText().toString();
                    String Khoa = editKhoa.getText().toString();
                    SinhVien sinhVien = new SinhVien(MSV,TSV,Lop,Nganh,Khoa);

                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("QuanLySinhVien/SinhVien");
                    String id = myRef.push().getKey();
                    myRef.child(id).setValue(sinhVien).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(getApplicationContext(), "Add Success" ,Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Add Failed"  + e.toString() ,Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
    }

    private void addControls(){
        editMSV = (EditText) findViewById(R.id.editTextUpdateMSV);
        editTSV = (EditText) findViewById(R.id.editTextUpdateTSV);
        editLop = (EditText) findViewById(R.id.editTextUpdateLop);
        editKhoa = (EditText) findViewById(R.id.editTextUpdateKhoa);
        editNganh = (EditText) findViewById(R.id.editTextUpdateNganh);
        btnAdd = (Button) findViewById(R.id.btn_update_Add);
        btnCancel = (Button) findViewById(R.id.btn_update_Cancel);
        btnBack = (Button) findViewById(R.id.btn_update_back);
    }
}