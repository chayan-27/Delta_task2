package com.example.delta_task2;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    Animation animation1;
    Animation animation2;
    Animation animation3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView=(TextView)findViewById(R.id.dots);
        TextView textView1=(TextView)findViewById(R.id.and);
        TextView textView2=(TextView)findViewById(R.id.boxes);
        animation1= AnimationUtils.loadAnimation(this,R.anim.dot);
        animation2= AnimationUtils.loadAnimation(this,R.anim.and);
        animation3= AnimationUtils.loadAnimation(this,R.anim.boxes);
        textView.setAnimation(animation1);
        textView1.setAnimation(animation2);
        textView2.setAnimation(animation3);

        final Intent intent=new Intent(Main3Activity.this,MainActivity.class);
        Thread timer=new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void run(){
                try {
                    sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {


                    startActivity(intent);



                    finish();

                }
            }
        };
        timer.start();
    }
}
