package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btn;
    EditText ev1 , ev2;
    String p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ev1 = findViewById(R.id.editText2);
        ev2 = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        Intent intent1 = getIntent();
        final int nop = intent1.getIntExtra("nop",2);
        if(nop==1){
            ev2.setVisibility(View.INVISIBLE);
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) btn.getLayoutParams();
            params.topMargin = -500;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = ev1.getText().toString().trim();
                if(nop==2) {
                    p2 = ev2.getText().toString().trim();
                }
                if(!TextUtils.isEmpty(p1) && !TextUtils.isEmpty(p1) && nop==2){
                    Intent intent = new Intent(Main2Activity.this , MainActivity.class);
                    intent.putExtra("p1" , p1 );
                    intent.putExtra("p2" , p2 );
                    intent.putExtra("nop" , nop);
                    finish();
                    startActivity(intent);
                }
                else if(!TextUtils.isEmpty(p1) && nop==1){
                    Intent intent = new Intent(Main2Activity.this , MainActivity.class);
                    intent.putExtra("p1" , p1 );
                    intent.putExtra("nop" , nop);
                    finish();
                    startActivity(intent);
                }
                else{
                    Toast t = Toast.makeText(Main2Activity.this , "Enter the Required Fields!!" , Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                    t.show();
                }
            }
        });

    }

}
