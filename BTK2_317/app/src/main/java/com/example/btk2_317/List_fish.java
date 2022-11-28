package com.example.btk2_317;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class List_fish extends AppCompatActivity {
    RecyclerView recview;
    fishAdapter adapter;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fish);

        recview=(RecyclerView)findViewById(R.id.rv);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<fishModel> options =
                new FirebaseRecyclerOptions.Builder<fishModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("fishManagement"), fishModel.class)
                        .build();

        adapter=new fishAdapter(options);
        recview.setAdapter(adapter);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , AddActivity.class));
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}