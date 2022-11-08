package com.example.fire_base_317;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_317 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signIn = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_317.this , Signup_317.class);
                startActivity(intent);
            }
        });
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private void   login(){
        String taiKhoan , pass;
        TextView textView1 = (TextView) findViewById(R.id.textv1);
        TextView textView2 =  (TextView)  findViewById(R.id.editPassword);
        taiKhoan = textView1.getText().toString();
        pass = textView2.getText().toString();
        if (TextUtils.isEmpty(taiKhoan) || TextUtils.isEmpty(pass)){
            Toast.makeText( login_317.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
        }
        FirebaseAuth  authException = FirebaseAuth.getInstance();
        authException.signInWithEmailAndPassword(taiKhoan,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Toast.makeText( login_317.this,"Đăng nhập thành công" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login_317.this , DanhSachSinhVien.class);
                    startActivity(intent);
                } else{
                    Toast.makeText( login_317.this,"Tài khoản hoặc mật khẩu không đúng" , Toast.LENGTH_SHORT).show();
                }
            }
        });
}
}