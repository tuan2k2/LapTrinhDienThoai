package com.example.btgk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_register_app extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_app);
        setContentView(R.layout.activity_register_app);
        TextView textView  = (TextView) findViewById(R.id.textView6);
        TextView textView1 = (TextView) findViewById(R.id.textv1);
        TextView textView2 = (TextView) findViewById(R.id.editPassword);
        TextView textView3 = (TextView) findViewById(R.id.editPassword2);
        Button button = (Button) findViewById(R.id.xemVideo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_register_app.this, login.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView1.getText() == "" || textView2.getText() == "" || textView3.getText().equals("")){
                    Toast.makeText( activity_register_app.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                } else
                if (textView2.getText().toString().equals(textView3.getText().toString())){
                    Toast.makeText( activity_register_app.this,"Đăng Kí Thành Công" , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_register_app.this, login.class);
                    startActivity(intent);
                }else {
                    Toast.makeText( activity_register_app.this,"Mật khẩu Không trùng" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}