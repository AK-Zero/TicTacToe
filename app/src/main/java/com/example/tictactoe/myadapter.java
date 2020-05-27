package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    String[] hscorelist = new String[40];
    int[] score = new int[40];
    int n;
    public myadapter(String[] names , int[] scores , int n1){
        hscorelist=names;
        score = scores;
        n=n1;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item , parent , false);

        return new myviewholder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        if(hscorelist[position]!=null) {
            String pos = hscorelist[position] + " : " + score[position];
            holder.tv2.setText(pos);
        }
        else{
            String pos = " ";
            holder.tv2.setText(pos);
        }
        int b = position + 1;
        holder.tv1.setText(" " + b);
    }

    @Override
    public int getItemCount() {
        return n;
    }

    public class myviewholder extends RecyclerView.ViewHolder{

        TextView tv1,tv2;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.textView6);
            tv2 = itemView.findViewById(R.id.textView7);
        }
    }
}
