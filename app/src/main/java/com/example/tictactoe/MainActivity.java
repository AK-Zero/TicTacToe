package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    tictactoe ttt;
    Button btn;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView4);
        tv2 = findViewById(R.id.textView3);
        ttt = findViewById(R.id.tictactoe);
        btn = findViewById(R.id.button2);
        final Intent intent = getIntent();
        final String p1 = intent.getStringExtra("p1");
        final String p2 = intent.getStringExtra("p2");
        final int nop = intent.getIntExtra("nop",2);
        tv1.setText("Player 1 : " + p1);
        if(nop==2) {
            tv2.setText("Player 2 : " + p2);
        }
        else {
            tv2.setVisibility(View.INVISIBLE);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btn.getLayoutParams();
            params.topMargin = -300;
        }
        ttt.setname(p1,p2,nop);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ttt.stat){
                    Intent intent1 = new Intent(MainActivity.this,hscore.class);
                    ttt.stopmusic();
                    intent1.putExtra("p1" , p1);
                    intent1.putExtra("p2" , p2);
                    intent1.putExtra("nop" , nop);
                    finish();
                    startActivity(intent1);
                }
                else{
                    Toast t = Toast.makeText(MainActivity.this , "Game is not yet over!!!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ttt.stopmusic();
    }


}
