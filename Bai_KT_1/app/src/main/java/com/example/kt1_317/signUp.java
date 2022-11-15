package com.example.kt1_317;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        TextView textView  = (TextView) findViewById(R.id.textView6);
        TextView textView1 = (TextView) findViewById(R.id.textv1);
        TextView textView2 = (TextView) findViewById(R.id.editPassword);
        TextView textView3 = (TextView) findViewById(R.id.editPassword2);
        Button button = (Button) findViewById(R.id.back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signUp.this, Sign_In.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView1.getText() == "" || textView2.getText() == "" || textView3.getText().equals("")){
                    Toast.makeText( signUp.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                } else
                if (textView2.getText().toString().equals(textView3.getText().toString())){
                    Toast.makeText( signUp.this,"Đăng Kí Thành Công" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signUp.this, Sign_In.class);
                    startActivity(intent);
                }else {
                    Toast.makeText( signUp.this,"Mật khẩu Không trùng" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}