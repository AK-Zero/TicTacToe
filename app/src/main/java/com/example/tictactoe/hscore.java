package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;

public class hscore extends AppCompatActivity {

    String[] names = new String[40];
    int[] score = new int[40];
    int n;
    Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hscore);
        btn = findViewById(R.id.button4);
        btn1 = findViewById(R.id.button11);
        Intent intent = getIntent();
        final String p1 = intent.getStringExtra("p1");
        final String p2 = intent.getStringExtra("p2");
        final int nop = intent.getIntExtra("nop",2);
        SharedPreferences pref = getSharedPreferences("hscore" , Context.MODE_PRIVATE);
        n = pref.getInt("n" , 0);
        for(int i=0;i<n;i++){
            names[i] = pref.getString("name" + i, " ");
            score[i] = pref.getInt("score" + i, 0);
        }

        final RecyclerView hscore = (RecyclerView) findViewById(R.id.hscore);
        hscore.setLayoutManager(new LinearLayoutManager(this));
        hscore.setAdapter(new myadapter(names,score,n));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(com.example.tictactoe.hscore.this , MainActivity.class);
                intent1.putExtra("p1" , p1);
                intent1.putExtra("p2" , p2);
                intent1.putExtra("nop" , nop);
                finish();
                startActivity(intent1);
            }
        });
    }
}
