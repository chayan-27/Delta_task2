package com.example.delta_task2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mediaPlayer= MediaPlayer.create(this,R.raw.gameover);
        mediaPlayer.start();
        Intent intent = getIntent();
        int players=intent.getIntExtra("players", 0);

        if(players==2) {


            int a = intent.getIntExtra("score1", 0);
            int b = intent.getIntExtra("score2", 0);
            TextView textView = (TextView) findViewById(R.id.textView);
            TextView textView1 = (TextView) findViewById(R.id.textView2);
            textView.setText("Player1=" + a);
            textView1.setText("Player2=" + b);
        }else if(players==3){
            int a = intent.getIntExtra("score1", 0);
            int b = intent.getIntExtra("score2", 0);
            int c = intent.getIntExtra("score3",0);
            TextView textView = (TextView) findViewById(R.id.textView);
            TextView textView1 = (TextView) findViewById(R.id.textView2);
            TextView textView2 = (TextView) findViewById(R.id.textView3);
            textView2.setVisibility(View.VISIBLE);
            textView.setText("Player1=" + a);
            textView1.setText("Player2=" + b);
            textView2.setText("Player3=" + c);
        }else if(players==4){
            int a = intent.getIntExtra("score1", 0);
            int b = intent.getIntExtra("score2", 0);
            int c = intent.getIntExtra("score3",0);
            int d = intent.getIntExtra("score4",0);
            TextView textView = (TextView) findViewById(R.id.textView);
            TextView textView1 = (TextView) findViewById(R.id.textView2);
            TextView textView2 = (TextView) findViewById(R.id.textView3);
            TextView textView3 = (TextView) findViewById(R.id.textView4);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView.setText("Player1 = " + a);
            textView1.setText("Player2 = " + b);
            textView2.setText("Player3 = " + c);
            textView3.setText("Player4 = "+d);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Result.this,MainActivity.class);
        startActivity(intent);
        mediaPlayer.release();
        mediaPlayer = null;

        finish();
    }
}
