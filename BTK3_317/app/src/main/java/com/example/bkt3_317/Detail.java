package com.example.bkt3_317;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    ListView lv;
    ArrayList<String> ls;
    EditText x,y;
    Button kq;
    TextView kqq , pheptinhDeatil , kqtrave;;
    ImageView imgdetail;
    int imgdetaill;
    String pheptinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        kq = (Button) findViewById(R.id.btnKetQua);
        x = (EditText) findViewById(R.id.nhapX);
        lv = (ListView) findViewById(R.id.list);
        pheptinhDeatil = (TextView) findViewById(R.id.phepTinhD);
        imgdetail = (ImageView) findViewById(R.id.detail_img);
        kqtrave = (TextView) findViewById(R.id.kqTraVe);
        getData();
        pheptinhDeatil.setText(pheptinh);
        imgdetail.setImageResource(imgdetaill);

        kq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pheptinhDeatil.getText().toString()){
                    case "VIỆT NAM":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapter = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                       lv.setAdapter(arrayAdapter);
                        break;
                    case "PHÁP":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterP = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterP);
                        break;
                    case "NGA":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterN = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterN);
                        break;
                    case "ANH":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterA = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterA);
                        break;
                    case "BỒ ĐÀO NHA":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterB = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterB);
                        break;
                    case "BRAZIL":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterBR = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterBR);
                        break;
                    case "TÂY BAN NHA":
                        kqtrave.setText(x.getText());
                        ls  = new ArrayList<>();
                        ls.add(kqtrave.getText().toString());
                        ArrayAdapter arrayAdapterT = new ArrayAdapter( Detail.this , android.R.layout.simple_list_item_1 , ls);
                        lv.setAdapter(arrayAdapterT);
                        break;
                }
            }
        });

    }

    private void  getData(){
        if (getIntent().hasExtra("phepTinh") && getIntent().hasExtra("images")){
            pheptinh = getIntent().getStringExtra("phepTinh");
            imgdetaill = getIntent().getIntExtra("images",1);
        }
        else    {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }

}