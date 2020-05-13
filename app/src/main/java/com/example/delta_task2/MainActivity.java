package com.example.delta_task2;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;



   public static int c=0;
   public static int r=0;
   public static int py=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mediaPlayer=MediaPlayer.create(this,R.raw.music);
       mediaPlayer.start();









    }

    public void play(View view)
    {
        EditText editText=(EditText)findViewById(R.id.editText);
        EditText editText1=(EditText)findViewById(R.id.editText2);
        EditText editText2=(EditText)findViewById(R.id.editText3);
        try {
        String c1=editText.getText().toString();
        String r1=editText1.getText().toString();
        String players=editText2.getText().toString();

            c = Integer.parseInt(c1);
            r = Integer.parseInt(r1);
            py = Integer.parseInt(players);
            if(py>=2&&py<=4&&c>=2&&c<=5&&r>=2&&r<=7) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("columns", c);
                intent.putExtra("rows", r);
                intent.putExtra("players", py);
                startActivity(intent);
            }else{
                if(py<2||py>4)
                Toast.makeText(this,"Minimum no. of players = 2 and Maximum = 4",Toast.LENGTH_SHORT).show();
                if(c<2||c>5)
                    Toast.makeText(this,"Minimum no. of columns = 2 and Maximum = 5",Toast.LENGTH_SHORT).show();
                if(r<2||r>7)
                    Toast.makeText(this,"Minimum no. of rows = 2 and Maximum = 7",Toast.LENGTH_SHORT).show();


            }
        }catch (Exception e){
            Toast.makeText(this,"Enter valid limits i.e 2<=Columns<=5 and 2<=Rows<=7 and 2>=Players<=4",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
        mediaPlayer = null;
        finish();
    }


}

