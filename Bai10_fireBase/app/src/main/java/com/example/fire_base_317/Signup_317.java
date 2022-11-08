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

public class Signup_317 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup317);
        TextView textView  = (TextView) findViewById(R.id.textView6);
        Button button = (Button) findViewById(R.id.xemVideo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup_317.this, login_317.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();


            }
        });
//            if (textView2.getText().toString().equals(textView3.getText().toString())){
//                Toast.makeText( activity_register_app.this,"Đăng Kí Thành Công" , Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(activity_register_app.this, login.class);
//                startActivity(intent);
//            }else {
//                Toast.makeText( activity_register_app.this,"Mật khẩu Không trùng" , Toast.LENGTH_SHORT).show();
//            }
//        }
    }


    private void   signup() {
        String taiKhoan, pass;
        TextView textView1 = (TextView) findViewById(R.id.textv1);
        TextView textView2 = (TextView) findViewById(R.id.editPassword);
        TextView textView3 = (TextView) findViewById(R.id.editPassword2);
        taiKhoan = textView1.getText().toString();
        pass = textView2.getText().toString();
        if (textView1.getText() == "" || textView2.getText() == "" || textView3.getText().equals("")){
            Toast.makeText( Signup_317.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
        }
        FirebaseAuth authException = FirebaseAuth.getInstance();
        authException.createUserWithEmailAndPassword(taiKhoan, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Đăng Kí thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Signup_317.this, login_317.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Signup_317.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}