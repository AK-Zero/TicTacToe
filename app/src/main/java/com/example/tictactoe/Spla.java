package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Spla extends AppCompatActivity {
    Animation splash,splash1;
    TextView tv;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spla);
        tv = findViewById(R.id.textView2);
        img = findViewById(R.id.imageView);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        splash = AnimationUtils.loadAnimation(this,R.anim.anim);
        splash1 = AnimationUtils.loadAnimation(this,R.anim.anim1);
        img.setAnimation(splash);
        tv.setAnimation(splash1);
        final MediaPlayer star= MediaPlayer.create(Spla.this , R.raw.start);
        star.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Spla.this , Main3Activity.class);
                finish();
                star.stop();
                startActivity(intent);
            }
        },4500);
    }
}
