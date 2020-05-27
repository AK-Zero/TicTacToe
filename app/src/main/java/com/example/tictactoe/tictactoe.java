package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Random;
import java.util.logging.Handler;

public class tictactoe extends View {

    Paint px , po , pline , pe;
    boolean stat=true;
    int player=1 , nop=2 , winner=0 ,winner1=0;
    int[] tim = new int[9];
    int[] a1 = new int[9];
    String name1 , name2;
    MediaPlayer p1,p2,draw;
    Random rand;
    String[] names = new String[40];
    int[] score = new int[40];
    public tictactoe(Context context) {
        super(context);
        init(null);
    }
    public tictactoe(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public tictactoe(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        pline = new Paint();
        pline.setAntiAlias(true);
        pline.setColor(Color.BLACK);
        pline.setStrokeWidth(10);
        pe = new Paint();
        pe.setAntiAlias(true);
        pe.setColor(Color.MAGENTA);
        pe.setStrokeWidth(20);
        px = new Paint();
        px.setAntiAlias(true);
        px.setColor(Color.RED);
        px.setStrokeWidth(13);
        po = new Paint();
        po.setStyle(Paint.Style.STROKE);
        po.setAntiAlias(true);
        po.setColor(Color.BLUE);
        po.setStrokeWidth(13);
        for(int i=0 ; i<9 ; i++){
            tim[i]=0;
            a1[i]=0;
        }
        rand = new Random();
        p1 = MediaPlayer.create(getContext(),R.raw.p1);
        p2 = MediaPlayer.create(getContext(),R.raw.p2);
        draw = MediaPlayer.create(getContext(),R.raw.draw);

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        float wx,hy;
        wx = (float)getWidth()/3;
        hy = (float)getHeight()/3;
        for(int i= 0 ; i<3 ; i++){
            if(tim[i*3]==1 && tim[i*3+1]==1 && tim[i*3+2]==1 &&stat){
                canvas.drawLine( (i*wx+(i+1)*wx)/2 , hy/2 , (i*wx+(i+1)*wx)/2 , 5*hy/2 , pe);
                p1.start();
                Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                t.show();
                stat=false;
                winner=1;
            }
            else if(tim[i*3]==2 && tim[i*3+1]==2 && tim[i*3+2]==2 &&stat){
                canvas.drawLine( (i*wx+(i+1)*wx)/2 , hy/2 , (i*wx+(i+1)*wx)/2 , 5*hy/2 , pe);
                stat=false;
                p2.start();
                if(nop==2) {
                    Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                winner=2;
            }
            if(tim[i]==1 && tim[i+3]==1 && tim[i+6]==1 &&stat){
                canvas.drawLine(wx/2 , (i*hy+(i+1)*hy)/2 , 5*wx/2 , (i*hy+(i+1)*hy)/2 , pe);
                p1.start();
                stat=false;
                Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                t.show();
                winner=1;
            }
            else if(tim[i]==2 && tim[i+3]==2 && tim[i+6]==2 &&stat){
                canvas.drawLine(wx/2 , (i*hy+(i+1)*hy)/2 , 5*wx/2 , (i*hy+(i+1)*hy)/2 , pe);
                stat=false;
                p2.start();
                if(nop==2) {
                    Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                winner=2;
            }
        }
        if(tim[0]==1 && tim[4]==1 && tim[8]==1 &&stat){
            canvas.drawLine(wx/2 , hy/2 , 5*wx/2 , 5*hy/2 , pe);
            stat=false;
            p1.start();
            Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            winner=1;
        }
        else if(tim[0]==2 && tim[4]==2 && tim[8]==2 &&stat){
            canvas.drawLine(wx/2 , hy/2 , 5*wx/2 , 5*hy/2 , pe);
            stat=false;
            p2.start();
            if(nop==2) {
                Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            else{
                Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            winner=2;
        }
        if(tim[2]==1 && tim[4]==1 && tim[6]==1 && stat){
            canvas.drawLine(5*wx/2 , hy/2 , wx/2 , 5*hy/2 , pe);
            stat=false;
            p1.start();
            Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            winner=1;
        }
        else if(tim[2]==2 && tim[4]==2 && tim[6]==2 &&stat){
            canvas.drawLine(5*wx/2 , hy/2 , wx/2 , 5*hy/2 , pe);
            stat=false;
            p2.start();
            if(nop==2) {
                Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            else{
                Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            winner=2;
        }
        if(tim[0]!=0 && tim[1]!=0 && tim[2]!=0 && tim[3]!=0 && tim[4]!=0 && tim[5]!=0 && tim[6]!=0 && tim[7]!=0 && tim[8]!=0 && stat){
            draw.start();
            Toast t = Toast.makeText(getContext() , "It's a Draw!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            stat=false;
        }
        if(nop==1 && player==0 && stat ){

            int best = Integer.MIN_VALUE;
            int move=0;
            for(int i=0 ; i<9;i++){
                if(tim[i]==0){
                    tim[i]=2;
                    int score = minimax(tim , 0 , false);
                    tim[i]=0;
                    if(score>best){
                        best = score;
                        move = i;
                    }
                }
            }
            tim[move]=2;
            player=1;

            }




        for(int i=0;i<4;i++){
            canvas.drawLine(i*wx , 0 , i*wx , getHeight() , pline);
            canvas.drawLine(0, i*hy , getWidth(), i*hy , pline);
        }
        for(int i = 0 ; i<3 ; i++)
            for(int j = 0 ; j<3 ; j++){
                if(tim[i*3+j]==1){
                    canvas.drawLine((i*wx+(i+1)*wx)/2-60 , (j*hy+(j+1)*hy)/2-60 ,(i*wx+(i+1)*wx)/2+60 , (j*hy+(j+1)*hy)/2+60 , px);
                    canvas.drawLine((i*wx+(i+1)*wx)/2+60 , (j*hy+(j+1)*hy)/2-60 ,(i*wx+(i+1)*wx)/2-60 , (j*hy+(j+1)*hy)/2+60 , px);
                }
                else if(tim[i*3+j]==2){
                    canvas.drawCircle((i*wx+(i+1)*wx)/2 , (j*hy+(j+1)*hy)/2 , 80 , po);
                }
            }

        for(int i= 0 ; i<3 ; i++){
            if(tim[i*3]==1 && tim[i*3+1]==1 && tim[i*3+2]==1 &&stat){
                canvas.drawLine( (i*wx+(i+1)*wx)/2 , hy/2 , (i*wx+(i+1)*wx)/2 , 5*hy/2 , pe);
                p1.start();
                Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                t.show();
                winner=1;
                stat=false;
            }
            else if(tim[i*3]==2 && tim[i*3+1]==2 && tim[i*3+2]==2 &&stat){
                canvas.drawLine( (i*wx+(i+1)*wx)/2 , hy/2 , (i*wx+(i+1)*wx)/2 , 5*hy/2 , pe);
                stat=false;
                p2.start();
                if(nop==2) {
                    Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                winner=2;
            }
            if(tim[i]==1 && tim[i+3]==1 && tim[i+6]==1 &&stat){
                canvas.drawLine(wx/2 , (i*hy+(i+1)*hy)/2 , 5*wx/2 , (i*hy+(i+1)*hy)/2 , pe);
                p1.start();
                stat=false;
                Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
                t.show();
                winner=1;
            }
            else if(tim[i]==2 && tim[i+3]==2 && tim[i+6]==2 &&stat){
                canvas.drawLine(wx/2 , (i*hy+(i+1)*hy)/2 , 5*wx/2 , (i*hy+(i+1)*hy)/2 , pe);
                stat=false;
                p2.start();
                if(nop==2) {
                    Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                    t.show();
                }
                winner=2;
            }
        }
        if(tim[0]==1 && tim[4]==1 && tim[8]==1 &&stat){
            canvas.drawLine(wx/2 , hy/2 , 5*wx/2 , 5*hy/2 , pe);
            stat=false;
            p1.start();
            Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            winner=1;
        }
        else if(tim[0]==2 && tim[4]==2 && tim[8]==2 &&stat){
            canvas.drawLine(wx/2 , hy/2 , 5*wx/2 , 5*hy/2 , pe);
            stat=false;
            p2.start();
            if(nop==2) {
                Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            else{
                Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            winner=2;
        }
        if(tim[2]==1 && tim[4]==1 && tim[6]==1 && stat){
            canvas.drawLine(5*wx/2 , hy/2 , wx/2 , 5*hy/2 , pe);
            stat=false;
            p1.start();
            Toast t = Toast.makeText(getContext() , name1 + " Wins!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            winner=1;
        }
        else if(tim[2]==2 && tim[4]==2 && tim[6]==2 &&stat){
            canvas.drawLine(5*wx/2 , hy/2 , wx/2 , 5*hy/2 , pe);
            stat=false;
            p2.start();
            if(nop==2) {
                Toast t = Toast.makeText(getContext(), name2 + " Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            else{
                Toast t = Toast.makeText(getContext(), "Device Wins!!", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                t.show();
            }
            winner=2;
        }
        if(tim[0]!=0 && tim[1]!=0 && tim[2]!=0 && tim[3]!=0 && tim[4]!=0 && tim[5]!=0 && tim[6]!=0 && tim[7]!=0 && tim[8]!=0 && stat){
            draw.start();
            Toast t = Toast.makeText(getContext() , "It's a Draw!!" , Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER | Gravity.BOTTOM , 0 , 0);
            t.show();
            stat=false;
        }

        if(!stat) {
            SharedPreferences pref = getContext().getSharedPreferences("hscore", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = pref.edit();
            int n;
            int k = 0, k1 = 0;
            n = pref.getInt("n", 0);
            if(n>37){
                n-=2;
            }
            for (int i = 0; i < n; i++) {
                names[i] = pref.getString("name" + i, " ");
                score[i] = pref.getInt("score" + i, 0);
            }
            for (int i = 0; i < n; i++) {
                if (names[i].equals(name1)) {
                    if(winner==1){
                    score[i]++;
                    }
                    k++;
                }
                if (names[i].equals(name2) && nop == 2) {
                    if(winner==2){
                        score[i]++;
                    }
                    k1++;
                }
            }
            if (k == 0) {
                names[n] = name1;
                if(winner==1){
                    score[n] = 1;
                }
                else {
                    score[n]=0;
                }
                n++;
            }
            if (k1 == 0 && nop == 2) {
                names[n] = name2;
                if(winner==2){
                    score[n] = 1;
                }
                else {
                    score[n]=0;
                }
                n++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (score[j - 1] < score[j]) {
                        int temp = score[j - 1];
                        score[j - 1] = score[j];
                        score[j] = temp;
                        String temp1 = names[j - 1];
                        names[j - 1] = names[j];
                        names[j] = temp1;
                    }

                }
            }
            for(int i=0 ; i<n ; i++){
                edit.putString("name"+i , names[i] );
                edit.putInt("score"+i , score[i]);
            }
            edit.putInt("n",n);
            edit.apply();



        }


    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN : {
                float x = event.getX();
                float y = event.getY();
                float wx = (float)getWidth()/3;
                float hy = (float)getHeight()/3;
                if(stat) {
                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++) {
                            if (x > i * wx && x < (i + 1) * wx && y > j * hy && y < (j + 1) * hy && tim[i * 3 + j] == 0) {
                                if(nop==2) {
                                    if (player == 1) {
                                        tim[i * 3 + j] = 1;
                                        player = 2;
                                    } else {
                                        tim[i * 3 + j] = 2;
                                        player = 1;
                                    }
                                }
                                else{
                                    tim[i * 3 + j] = 1;
                                    player = 0;
                                }
                            }
                        }
                    postInvalidate();
                }
                return true;
            }
            case MotionEvent.ACTION_MOVE : {
                return true;
            }
            case MotionEvent.ACTION_UP : {
                return value;
            }
        }
    return value;
    }
    public void setname( String p1 , String p2 , int a){
        name1 = p1;
        name2 = p2;
        nop = a;
    }
    public void stopmusic(){
        p1.stop();
        p2.stop();
        draw.stop();
    }

    private int minimax(int[] tim , int depth , boolean isMaximizing) {
        winner1=0;
        for (int i = 0; i < 3; i++) {
            if (tim[i * 3] == 1 && tim[i * 3 + 1] == 1 && tim[i * 3 + 2] == 1) {
                winner1 = 1;
            } else if (tim[i * 3] == 2 && tim[i * 3 + 1] == 2 && tim[i * 3 + 2] == 2) {
                winner1 = 2;
            }
            if (tim[i] == 1 && tim[i + 3] == 1 && tim[i + 6] == 1) {
                winner1 = 1;
            } else if (tim[i] == 2 && tim[i + 3] == 2 && tim[i + 6] == 2) {
                winner1 = 2;
            }
        }
        if (tim[0] == 1 && tim[4] == 1 && tim[8] == 1) {
            winner1 = 1;
        } else if (tim[0] == 2 && tim[4] == 2 && tim[8] == 2) {
            winner1 = 2;
        }
        if (tim[2] == 1 && tim[4] == 1 && tim[6] == 1) {
            winner1 = 1;
        } else if (tim[2] == 2 && tim[4] == 2 && tim[6] == 2) {
            winner1 = 2;
        }
        if (tim[0] != 0 && tim[1] != 0 && tim[2] != 0 && tim[3] != 0 && tim[4] != 0 && tim[5] != 0 && tim[6] != 0 && tim[7] != 0 && tim[8] != 0 && winner1==0) {
            winner1 = 3;
        }
        if (winner1 != 0) {
            if (winner1 == 1) {
                return -10;
            } else if (winner1 == 2) {
                return 10;
            } else {
                return 0;
            }
        }

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (tim[i] == 0) {
                    tim[i] = 2;
                    int score = minimax(tim, depth + 1, false);
                    tim[i] = 0;
                    if (score > best) {
                        best = score;
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (tim[i] == 0) {
                    tim[i] = 1;
                    int score = minimax(tim, depth + 1, true);
                    tim[i] = 0;
                    if (score < best) {
                        best = score;
                    }
                }
            }
            return best;
        }
    }


}
