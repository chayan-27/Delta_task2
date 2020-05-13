package com.example.delta_task2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class Main2Activity extends AppCompatActivity{




    public static int c,r,pl;


MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mediaPlayer= MediaPlayer.create(this,R.raw.musicgame);
        mediaPlayer.start();

        final View game=new Game(this);

        final com.example.delta_task2.Game xy=(com.example.delta_task2.Game)findViewById(R.id.test);


        Intent intent=getIntent();
        c=intent.getIntExtra("columns",0);
        r=intent.getIntExtra("rows",0);
        pl=intent.getIntExtra("players",0);

        Button button=(Button)findViewById(R.id.undo);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                xy.undo();

            }
        });
}

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        mediaPlayer = null;
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }






}
