package com.example.a2050531200317_trananhtuan_giaodien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2050531200317_trananhtuan_giaodien.Service.AccountService;

public class login_ac extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.signup_activity);

        AccountService accountService = new AccountService();
        TextView textView1 = (TextView) findViewById(R.id.textv1);
        TextView textView2 =  (TextView)  findViewById(R.id.editPassword);
        Button signIn = (Button) findViewById(R.id.button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "admin";
                String pass = "admin";

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText( login_ac.this,"Tài khoản hoặc mật khẩu không được để trống" , Toast.LENGTH_SHORT).show();
                }
                else {
                    if ((textView1.getText().toString().equals(user)) && (textView2.getText().toString().equals(pass))){
                        Toast.makeText( login_ac.this,"Thành Công" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_ac.this, main.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText( login_ac.this,"Tài khoản hoặc mật khẩu không đúng" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}