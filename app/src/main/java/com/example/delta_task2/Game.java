package com.example.delta_task2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import android.graphics.Rect;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;


import static android.content.Context.VIBRATOR_SERVICE;


public class Game extends View {
    Paint paint2 ;
    boolean overlap=false;
    Paint paint4;
    int count=0;
    int count2=0;
    int undo=0;
    int un=0;
    HashMap<Integer,Path> getMap;
    HashMap<Integer,Rect> getRect;
    Vibrator vibrator;

    public Game(Context context) {
        super(context);

        init(null);




    }

    public Game(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);init(attrs);
    }

    public Game(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Game(Context context,  @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(@Nullable AttributeSet set)
    {
        vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        getMap=new HashMap<Integer, Path>();
        getRect=new HashMap<Integer, Rect>();
        paint2=new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(12f);

        paint4=new Paint();
        paint4.setColor(Color.RED);
        paint4.setStrokeJoin(Paint.Join.ROUND);
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(12f);
        paint11=new Paint();
        paint11.setColor(Color.GREEN);
        paint11.setStrokeJoin(Paint.Join.ROUND);
        paint11.setStyle(Paint.Style.STROKE);
        paint11.setStrokeWidth(12f);

         x1=new ArrayList<>();
         y1=new ArrayList<>();
         x2=new ArrayList<>();
         y2=new ArrayList<>();


        paint5=new Paint();
         paint5.setColor(Color.RED);
         rect=new Rect();

        paint6=new Paint();
        paint6.setColor(Color.RED);
        rect1=new Rect();

        paint7=new Paint();
        paint7.setColor(Color.RED);
        rect2=new Rect();

        paint8=new Paint();
        paint8.setColor(Color.RED);
        rect3=new Rect();

        paint3 = new Paint();
        paint3.setColor(Color.parseColor("#D3D3D3"));
        paint3.setStrokeWidth(8);

        paint9=new Paint();
        paint9.setColor(Color.parseColor("#D3D3D3"));
        paint9.setStrokeJoin(Paint.Join.ROUND);
        paint9.setStyle(Paint.Style.STROKE);
        paint9.setStrokeWidth(12f);

        paint10=new Paint();
        paint10.setColor(Color.parseColor("#D3D3D3"));

        paint12=new Paint();
        paint12.setColor(Color.YELLOW);
        paint12.setStrokeJoin(Paint.Join.ROUND);
        paint12.setStyle(Paint.Style.STROKE);
        paint12.setStrokeWidth(12f);


    }
    Bitmap myBitmap;
    int score1=0;
    int score2=0;
    int a;
    int b;
    int c;
    int d;
    Path path=new Path();
    Path path1=new Path();
    int z=0;
    int swtch=0;
    ArrayList<Integer> x1;
    ArrayList<Integer> y1;
    ArrayList<Integer> x2;
    ArrayList<Integer> y2;
    Rect rect;
    Rect rect1;
    Rect rect2;
    Rect rect3;
    Paint paint6;
    Paint paint7;
    Paint paint8;
    Bitmap mDrawBitmap;
    Canvas mBitmapCanvas;
    Paint mDrawPaint = new Paint();
    int row=MainActivity.r;
    int column=MainActivity.c;
    boolean pressed=false;
    Paint paint3;
    Paint paint9;
    Paint paint10;
    boolean box1;
    boolean box2;
    int p=MainActivity.py;
    int play1=0;
    int play2;
    Path path2=new Path();
    Paint paint11;
    int flag=0;
    int flag2=0;
    int score3=0;
    boolean box3;
    Paint paint12;
    boolean box4;
    int score4;
    Path path3=new Path();
    Paint painttext=new Paint();







    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        if (mDrawBitmap == null) {
            mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mDrawBitmap);
        }
        @SuppressLint("DrawAllocation") Paint paint=new Paint();
        paint.setColor(Color.BLACK);
        if(p==2){
        if(undo==1&&count>=1&&flag==1){
           // System.out.println("Undo called"+count);
            //un++;
            flag2=1;

            undo=0;

            Path path;

            path=getMap.get(count - 1);





            mBitmapCanvas.drawPath(path,paint9);
           path.reset();


           if(box1){
               Rect rect=getRect.get(count2-1);
               if(swtch==0){

                 paint10.setColor(Color.parseColor("#d4ebf2"));



               }else{

                  paint10.setColor(Color.parseColor("#f2d4dc"));


               }
               mBitmapCanvas.drawRect(rect,paint10);
              // System.out.println("Box1 called");

               score1--;

               count2--;
           }
           if(box2){
               Rect rect=getRect.get(count2-1);
               if(swtch==0){

                   paint10.setColor(Color.parseColor("#d4ebf2"));


               }else{

                   paint10.setColor(Color.parseColor("#f2d4dc"));

               }
               mBitmapCanvas.drawRect(rect,paint10);
             //  System.out.println("Box2 called");

               score2--;

               count2--;
           }

           x1.remove(count-1);
            y1.remove(count-1);
            x2.remove(count-1);
            y2.remove(count-1);
            pressed=true;
            count--;
            for(int i=1;i<=Main2Activity.c;i++)
            {
                for(int j=1;j<=Main2Activity.r;j++)
                {
                    mBitmapCanvas.drawCircle(i*200,j*200,25,paint);
                }
            }

        }else{undo=0;}}
        if(p==3){
            if(undo==1&&count>=1&&flag==1){
                flag2=1;
               // System.out.println("Undo called"+count);
              //  un++;

                undo=0;

                Path path;

                path=getMap.get(count - 1);




                mBitmapCanvas.drawPath(path,paint9);
                path.reset();


                if(box1){
                    Rect rect=getRect.get(count2-1);
                    if(play1==0){
                        paint10.setColor(Color.parseColor("#d4ebf2"));


                    }else if(play1==1){
                        paint10.setColor(Color.parseColor("#f2d4dc"));

                    }else if(play1==2){

                        paint10.setColor(Color.parseColor("#90EE90"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                   // System.out.println("Box1 called");

                    score1--;

                    count2--;

                }
                if(box2){
                    Rect rect=getRect.get(count2-1);
                    if(play1==0){
                         paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play1==1){
                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play1==2){

                        paint10.setColor(Color.parseColor("#90EE90"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                    //System.out.println("Box2 called");

                    score2--;

                    count2--;

                }
                if(box3){
                    Rect rect=getRect.get(count2-1);
                    if(play1==0){
                         paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play1==1){
                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play1==2){

                        paint10.setColor(Color.parseColor("#90EE90"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                   // System.out.println("Box2 called");

                    score3--;

                    count2--;
                }

                x1.remove(count-1);
                y1.remove(count-1);
                x2.remove(count-1);
                y2.remove(count-1);
                pressed=true;
                count--;
                for(int i=1;i<=Main2Activity.c;i++)
                {
                    for(int j=1;j<=Main2Activity.r;j++)
                    {
                        mBitmapCanvas.drawCircle(i*200,j*200,25,paint);
                    }
                }

            }else{undo=0;}
        }        if(p==4){
            if(undo==1&&count>=1&&flag==1){
                flag2=1;
                //System.out.println("Undo called"+count);
                //un++;

                undo=0;

                Path path;

                path=getMap.get(count - 1);



                mBitmapCanvas.drawPath(path,paint9);
                path.reset();

                if(box1){
                    Rect rect=getRect.get(count2-1);
                    if(play2==0){

                        paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play2==1){

                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play2==2){
                        paint10.setColor(Color.parseColor("#90EE90"));
                    }else if(play2==3){
                        paint10.setColor(Color.parseColor("#FFFFE0"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
               //     System.out.println("Box1 called");

                    score1--;

                    count2--;

                }
                if(box2){
                    Rect rect=getRect.get(count2-1);
                    if(play2==0){

                        paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play2==1){

                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play2==2){
                        paint10.setColor(Color.parseColor("#90EE90"));
                    }else if(play2==3){
                        paint10.setColor(Color.parseColor("#FFFFE0"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                 //   System.out.println("Box2 called");

                    score2--;

                    count2--;

                }
                if(box3){
                    Rect rect=getRect.get(count2-1);
                    if(play2==0){

                        paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play2==1){

                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play2==2){
                        paint10.setColor(Color.parseColor("#90EE90"));
                    }else if(play2==3){
                        paint10.setColor(Color.parseColor("#FFFFE0"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                  //  System.out.println("Box3 called");

                    score3--;

                    count2--;
                } if(box4){
                    Rect rect=getRect.get(count2-1);
                    if(play2==0){

                        paint10.setColor(Color.parseColor("#d4ebf2"));

                    }else if(play2==1){

                        paint10.setColor(Color.parseColor("#f2d4dc"));
                    }else if(play2==2){
                        paint10.setColor(Color.parseColor("#90EE90"));
                    }else if(play2==3){
                        paint10.setColor(Color.parseColor("#FFFFE0"));

                    }
                    mBitmapCanvas.drawRect(rect,paint10);
                  //  System.out.println("Box4 called");

                    score4--;

                    count2--;
                }

                x1.remove(count-1);
                y1.remove(count-1);
                x2.remove(count-1);
                y2.remove(count-1);
                pressed=true;
                count--;
                for(int i=1;i<=Main2Activity.c;i++)
                {
                    for(int j=1;j<=Main2Activity.r;j++)
                    {
                        mBitmapCanvas.drawCircle(i*200,j*200,25,paint);
                    }
                }

            }else{undo=0;}
        }

        for(int i=0;i<=2000;i+=200)
        {
            for(int j=0;j<=1000;j+=200)
            {
                canvas.drawLine(i,j,i,(j+2000),paint3);
            }

        }
        for(int i=0;i<=3000;i+=200)
        {
            for(int j=0;j<=1000;j+=200)
            {
                canvas.drawLine(j,i,j+2000,i,paint3);
            }



        }
        for(int i=1;i<=Main2Activity.c;i++)
        {
            for(int j=1;j<=Main2Activity.r;j++)
            {
                canvas.drawCircle(i*200,j*200,25,paint);
            }
        }
        if(p==4) {
            for (int i = 0; i < x1.size() - 1; i++){
                if((tmpx1==x1.get(i)&&tmpy1==y1.get(i)&&tmpx2==x2.get(i)&&tmpy2==y2.get(i))||(tmpx1==x2.get(i)&&tmpy1==y2.get(i)&&tmpx2==x1.get(i)&&tmpy2==y1.get(i))){
                    overlap=true;
                }
            }
                if(z==1&&((Math.abs(tmpx2-tmpx1)==200&&Math.abs(tmpy2-tmpy1)==0)||(Math.abs(tmpy2-tmpy1)==200&&Math.abs(tmpx2-tmpx1)==0))&&tmpx1%200==0&&tmpx2%200==0&&tmpy1%200==0&&tmpy2%200==0&&tmpx1<=Main2Activity.c*200&&tmpx2<=Main2Activity.c*200&&tmpy1<=Main2Activity.r*200&&tmpy2<=Main2Activity.r*200&&overlap==false&&tmpx1>=200&&tmpx2>=200&&tmpy1>=200&&tmpy2>=200) {
                if (pressed == false) {
                    box1=false;
                    box2=false;
                    box3=false;
                    box4=false;
                    flag=1;




                    if (play2 == 0) {
                        path = new Path();
                        getMap.put(count, path);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path, paint2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path2, paint11);
                        play2= 1;
                        count++;

                    } else if(play2==1) {
                        path1 = new Path();
                        getMap.put(count, path1);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);
                        mBitmapCanvas.drawPath(path2, paint11);
                        play2 = 2;
                        count++;

                    }else if(play2==2){
                        path2 = new Path();
                        getMap.put(count, path2);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path2, paint11);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);

                        play2 = 3;
                        count++;

                    }else if(play2==3){
                        path3 = new Path();
                        getMap.put(count, path3);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path3, paint12);
                        mBitmapCanvas.drawPath(path2, paint11);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);

                        play2= 0;
                        count++;

                    }

                    if(a==1)
                    {
                        System.out.println("A called");
                        rect=new Rect();
                        getRect.put(count2,rect);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1-200;
                        getRect.get(count2).right=tmpx2;
                        getRect.get(count2).bottom=tmpy1;
                        vibrator.vibrate(300);

               /* rect.left=tmpx1;
                rect.top=tmpy1-200;
                rect.right=tmpx2;
                rect.bottom=tmpy1;*/
                        if(play2==1) {
                            paint5.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play2==2){
                            paint5.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play2==3){
                            paint5.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }else if(play2==0){
                            paint5.setColor(Color.YELLOW);
                            box4=true;
                            score4++;
                        }
                        mBitmapCanvas.drawRect(rect,paint5);
                        count2++;
                        // mBitmapCanvas.saveLayer(tmpx1,tmpy1-200,tmpx2,tmpy1,paint5);
                        // canvas.restore();

                    }
                    if(b==1)
                    {
                        System.out.println("B called");
                        rect1=new Rect();
                        getRect.put(count2,rect1);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1;

                        getRect.get(count2).right=tmpx2;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play2==1) {
                            paint6.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play2==2){
                            paint6.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play2==3){
                            paint6.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }else if(play2==0){
                            paint6.setColor(Color.YELLOW);
                            box4=true;
                            score4++;
                        }
                        mBitmapCanvas.drawRect(rect1,paint6);
                        count2++;
                        // canvas.saveLayer(tmpx1,tmpy1,tmpx2,tmpy1+200,paint6);
                        // canvas.restore();

                    }
                    if(c==1)
                    {
                        System.out.println("C called");
                        rect2=new Rect();
                        getRect.put(count2,rect2);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1;

                        getRect.get(count2).right=tmpx1+200;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play2==1) {
                            paint7.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play2==2){
                            paint7.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play2==3){
                            paint7.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }else if(play2==0){
                            paint7.setColor(Color.YELLOW);
                            box4=true;
                            score4++;
                        }
                        mBitmapCanvas.drawRect(rect2,paint7);
                        count2++;
                        //  canvas.saveLayer(tmpx1,tmpy1,tmpx1+200,tmpy1+200,paint7);


                    }
                    if(d==1)
                    {
                        System.out.println("D called");
                        rect3=new Rect();
                        getRect.put(count2,rect3);
                        getRect.get(count2).left=tmpx1-200;
                        getRect.get(count2).top=tmpy1;
                        getRect.get(count2).right=tmpx1;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play2==1) {
                            paint8.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play2==2){
                            paint8.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play2==3){
                            paint8.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }else if(play2==0){
                            paint8.setColor(Color.YELLOW);
                            box4=true;
                            score4++;
                        }
                        mBitmapCanvas.drawRect(rect3,paint8);
                        count2++;

                    }
                    if(a==1||b==1||c==1||d==1){
                    if(play2==0){
                        play2=3;
                    }else if(play2==1){
                        play2=0;
                    }else if(play2==2){
                        play2=1;
                    }else if(play2==3){
                        play2=2;

                    }}
                }else{
                    pressed=false;
                    if(box1==false&&box2==false&&box3==false&&box4==false){
                    if(play2==0){
                        play2=3;
                    }else if(play2==1){
                        play2=0;
                    }else if(play2==2){
                        play2=1;
                    }else if(play2==3){
                        play2=2;

                    }}
                    box1=false;
                    box2=false;
                    box3=false;
                    box4=false;
                    flag=0;
                }
            }}
        if(p==3) {
            for (int i = 0; i < x1.size() - 1; i++) {
                if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i) && tmpx2 == x2.get(i) && tmpy2 == y2.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i) && tmpx2 == x1.get(i) && tmpy2 == y1.get(i))) {
                    overlap = true;
                }
            }
            if(z==1&&((Math.abs(tmpx2-tmpx1)==200&&Math.abs(tmpy2-tmpy1)==0)||(Math.abs(tmpy2-tmpy1)==200&&Math.abs(tmpx2-tmpx1)==0))&&tmpx1%200==0&&tmpx2%200==0&&tmpy1%200==0&&tmpy2%200==0&&tmpx1<=Main2Activity.c*200&&tmpx2<=Main2Activity.c*200&&tmpy1<=Main2Activity.r*200&&tmpy2<=Main2Activity.r*200&&overlap==false&&tmpx1>=200&&tmpx2>=200&&tmpy1>=200&&tmpy2>=200) {
                if (pressed == false) {
                    box1=false;
                    box2=false;
                    box3=false;
                    flag=1;



                    if (play1 == 0) {
                        path = new Path();
                        getMap.put(count, path);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path, paint2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path2, paint11);
                        play1 = 1;
                        count++;

                    } else if(play1==1) {
                        path1 = new Path();
                        getMap.put(count, path1);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);
                        mBitmapCanvas.drawPath(path2, paint11);
                        play1 = 2;
                        count++;

                    }else if(play1==2){
                        path2 = new Path();
                        getMap.put(count, path2);
                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path2, paint11);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);

                        play1 = 0;
                        count++;

                    }

                    if(a==1)
                    {
                        System.out.println("A called");
                        rect=new Rect();
                        getRect.put(count2,rect);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1-200;
                        getRect.get(count2).right=tmpx2;
                        getRect.get(count2).bottom=tmpy1;
                        vibrator.vibrate(300);


                        if(play1==1) {
                            paint5.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play1==2){
                            paint5.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play1==0){
                            paint5.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }
                        mBitmapCanvas.drawRect(rect,paint5);
                        count2++;


                    }
                    if(b==1)
                    {
                        System.out.println("B called");
                        rect1=new Rect();
                        getRect.put(count2,rect1);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1;

                        getRect.get(count2).right=tmpx2;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play1==1) {
                            paint6.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play1==2){
                            paint6.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play1==0){
                            paint6.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }
                        mBitmapCanvas.drawRect(rect1,paint6);
                        count2++;


                    }
                    if(c==1)
                    {
                        System.out.println("C called");
                        rect2=new Rect();
                        getRect.put(count2,rect2);
                        getRect.get(count2).left=tmpx1;
                        getRect.get(count2).top=tmpy1;

                        getRect.get(count2).right=tmpx1+200;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play1==1) {
                            paint7.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play1==2){
                            paint7.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play1==0){
                            paint7.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }
                        mBitmapCanvas.drawRect(rect2,paint7);
                        count2++;



                    }
                    if(d==1)
                    {
                        System.out.println("D called");
                        rect3=new Rect();
                        getRect.put(count2,rect3);
                        getRect.get(count2).left=tmpx1-200;
                        getRect.get(count2).top=tmpy1;
                        getRect.get(count2).right=tmpx1;
                        getRect.get(count2).bottom=tmpy1+200;
                        vibrator.vibrate(300);
                        if(play1==1) {
                            paint8.setColor(Color.BLUE);
                            box1=true;
                            score1++;
                        }

                        else if(play1==2){
                            paint8.setColor(Color.RED);
                            box2=true;
                            score2++;
                        }else if(play1==0){
                            paint8.setColor(Color.GREEN);
                            box3=true;
                            score3++;
                        }
                        mBitmapCanvas.drawRect(rect3,paint8);
                        count2++;



                    }
                    if(a==1||b==1||c==1||d==1){
                        if(play1==0){
                            play1=2;
                        }else if(play1==1){
                            play1=0;
                        }else if(play1==2){
                            play1=1;
                        }}
                }else{
                    pressed=false;
                    if(box1==false&&box2==false&&box3==false){
                    if(play1==0){
                        play1=2;
                    }else if(play1==1){
                        play1=0;
                    }else if(play1==2){
                        play1=1;
                    }}
                    box1=false;
                    box2=false;
                    box3=false;
                    flag=0;
                }
            }}


        if(p==2) {
            for (int i = 0; i < x1.size() - 1; i++) {
                if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i) && tmpx2 == x2.get(i) && tmpy2 == y2.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i) && tmpx2 == x1.get(i) && tmpy2 == y1.get(i))) {
                    overlap = true;
                }
            }
            if (z == 1 && ((Math.abs(tmpx2 - tmpx1) == 200 && Math.abs(tmpy2 - tmpy1) == 0) || (Math.abs(tmpy2 - tmpy1) == 200 && Math.abs(tmpx2 - tmpx1) == 0)) && tmpx1 % 200 == 0 && tmpx2 % 200 == 0 && tmpy1 % 200 == 0 && tmpy2 % 200 == 0&&tmpx1<=Main2Activity.c*200&&tmpx2<=Main2Activity.c*200&&tmpy1<=Main2Activity.r*200&&tmpy2<=Main2Activity.r*200&&overlap==false&&tmpx1>=200&&tmpx2>=200&&tmpy1>=200&&tmpy2>=200) {


                if (pressed == false) {
                    box1=false;
                    box2=false;
                    flag=1;
                    if (swtch == 0) {
                        path = new Path();
                        getMap.put(count, path);


                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path, paint2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        swtch = 1;
                        count++;

                    } else {
                        path1 = new Path();
                        getMap.put(count, path1);

                        getMap.get(count).moveTo(tmpx1, tmpy1);
                        getMap.get(count).lineTo(tmpx2, tmpy2);
                        mBitmapCanvas.drawPath(path1, paint4);
                        mBitmapCanvas.drawPath(path, paint2);
                        swtch = 0;
                        count++;

                    }

                    if (a == 1) {
                        System.out.println("A called");
                        rect = new Rect();
                        getRect.put(count2, rect);
                        getRect.get(count2).left = tmpx1;
                        getRect.get(count2).top = tmpy1 - 200;
                        getRect.get(count2).right = tmpx2;
                        getRect.get(count2).bottom = tmpy1;
                        vibrator.vibrate(300);


                        if (swtch == 1) {
                            paint5.setColor(Color.BLUE);
                            box1 = true;
                            score1++;

                        } else {
                            paint5.setColor(Color.RED);
                            box2 = true;
                            score2++;

                        }
                        mBitmapCanvas.drawRect(rect, paint5);
                        count2++;



                    }
                    if (b == 1) {
                        System.out.println("B called");
                        rect1 = new Rect();
                        getRect.put(count2, rect1);
                        getRect.get(count2).left = tmpx1;
                        getRect.get(count2).top = tmpy1;

                        getRect.get(count2).right = tmpx2;
                        getRect.get(count2).bottom = tmpy1 + 200;
                        vibrator.vibrate(300);
                        if (swtch == 1) {
                            paint6.setColor(Color.BLUE);
                            score1++;
                            box1 = true;

                        } else {
                            paint6.setColor(Color.RED);
                            score2++;
                            box2 = true;

                        }
                        mBitmapCanvas.drawRect(rect1, paint6);
                        count2++;



                    }
                    if (c == 1) {
                        System.out.println("C called");
                        rect2 = new Rect();
                        getRect.put(count2, rect2);
                        getRect.get(count2).left = tmpx1;
                        getRect.get(count2).top = tmpy1;

                        getRect.get(count2).right = tmpx1 + 200;
                        getRect.get(count2).bottom = tmpy1 + 200;
                        vibrator.vibrate(300);
                        if (swtch == 1) {
                            paint7.setColor(Color.BLUE);
                            score1++;
                            box1 = true;

                        } else {
                            paint7.setColor(Color.RED);
                            score2++;
                            box2 = true;

                        }
                        mBitmapCanvas.drawRect(rect2, paint7);
                        count2++;




                    }
                    if (d == 1) {
                        System.out.println("D called");
                        rect3 = new Rect();
                        getRect.put(count2, rect3);
                        getRect.get(count2).left = tmpx1 - 200;
                        getRect.get(count2).top = tmpy1;
                        getRect.get(count2).right = tmpx1;
                        getRect.get(count2).bottom = tmpy1 + 200;
                        vibrator.vibrate(300);
                        if (swtch == 1) {
                            paint8.setColor(Color.BLUE);
                            score1++;
                            box1 = true;

                        } else {
                            paint8.setColor(Color.RED);
                            score2++;
                            box2 = true;

                        }
                        mBitmapCanvas.drawRect(rect3, paint8);
                        count2++;



                    }
                    if(a==1||b==1||c==1||d==1){
                        if (swtch == 0) {
                            swtch = 1;
                        } else {
                            swtch = 0;
                        }
                    }
                } else {
                    pressed = false;
                    if(box1==false&&box2==false){
                    if (swtch == 0) {
                        swtch = 1;
                    } else {
                        swtch = 0;
                    }}
                    box1=false;
                    box2=false;
                    flag=0;
                }
            }
        }

        if(z==0){
            canvas.drawColor(Color.parseColor("#d4ebf2"));
            painttext.setColor(Color.BLUE);
            painttext.setAntiAlias(true);
            painttext.setTextSize(100f);
            canvas.drawText("PLAYER 1",400,100,painttext);
        }else{
            if(p==2){

                if(swtch==0){

                    canvas.drawColor(Color.parseColor("#d4ebf2"));



                    painttext.setColor(Color.BLUE);
                    painttext.setAntiAlias(true);
                    painttext.setTextSize(100f);
                    canvas.drawText("PLAYER 1",400,100,painttext);








                }else{

                     canvas.drawColor(Color.parseColor("#f2d4dc"));
                    painttext.setColor(Color.RED);
                    painttext.setAntiAlias(true);
                    painttext.setTextSize(100f);
                    canvas.drawText("PLAYER 2",400,100,painttext);

                }
            }
            if(p==3) {

                    if (play1 == 1) {
                        canvas.drawColor(Color.parseColor("#f2d4dc"));

                        painttext = new Paint();
                        painttext.setColor(Color.RED);
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 2", 400, 100, painttext);




                    } else if (play1 == 2) {
                        canvas.drawColor(Color.parseColor("#90EE90"));
                        painttext = new Paint();
                        painttext.setColor(Color.parseColor("#32CD32"));
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 3", 400, 100, painttext);


                    } else if (play1 == 0) {
                        canvas.drawColor(Color.parseColor("#d4ebf2"));
                        painttext = new Paint();
                        painttext.setColor(Color.BLUE);
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 1", 400, 100, painttext);

                    }


            }            if(p==4) {

                    if (play2 == 1) {
                        canvas.drawColor(Color.parseColor("#f2d4dc"));
                        painttext=new Paint();
                        painttext.setColor(Color.RED);
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 2",400,100,painttext);



                    } else if (play2 == 2) {
                        canvas.drawColor(Color.parseColor("#90EE90"));
                        painttext=new Paint();
                        painttext.setColor(Color.parseColor("#32CD32"));
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 3",400,100,painttext);

                    } else if (play2 == 3) {
                        canvas.drawColor(Color.parseColor("#FFFFE0"));
                        painttext=new Paint();
                        painttext.setColor(Color.parseColor("#FFD700"));
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 4",400,100,painttext);
                    }else if (play2 == 0) {
                        canvas.drawColor(Color.parseColor("#d4ebf2"));
                        painttext=new Paint();
                        painttext.setColor(Color.BLUE);
                        painttext.setAntiAlias(true);
                        painttext.setTextSize(100f);
                        canvas.drawText("PLAYER 1",400,100,painttext);
                    }


            }
        }
        for(int i=0;i<=2000;i+=200)
        {
            for(int j=0;j<=1000;j+=200)
            {
                canvas.drawLine(i,j,i,(j+2000),paint3);
            }

        }
        for(int i=0;i<=3000;i+=200)
        {
            for(int j=0;j<=1000;j+=200)
            {
                canvas.drawLine(j,i,j+2000,i,paint3);
            }



        }
        for(int i=1;i<=Main2Activity.c;i++)
        {
            for(int j=1;j<=Main2Activity.r;j++)
            {
                mBitmapCanvas.drawCircle(i*200,j*200,25,paint);
            }
        }
        if(p==2){
        if(score1+score2==(row-1)*(column-1)){

            launch();


        }}
        if(p==3){
            if(score1+score2+score3==(row-1)*(column-1)){

                launch();


            }}
        if(p==4){
            if(score1+score2+score3+score4==(row-1)*(column-1)){

                launch();


            }}



        canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);



    }

float tx,tx1;
    float ty,ty1;
    int tmpx1,tmpy1;
    int tmpx2,tmpy2;
    boolean line1;
    boolean line2;
    boolean line3;
    boolean line4;
    boolean line5;
    boolean line6;
    Paint paint5;




    float tmpx,tmpy;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

a=0;
b=0;
c=0;
d=0;
overlap=false;
       float x=event.getX();
       float y=event.getY();
       //invalidate();
     switch (event.getAction())
     {
         case MotionEvent.ACTION_DOWN:




             tx=Math.round(x);
             tx=tx+30;
             ty=Math.round(y);
             ty=ty+30;
             tmpx1= (int) tx;
             tmpy1= (int) ty;
             if(tmpx1<1000){
             while(!(tmpx1>=1&&tmpx1<=9))
             {
                 tmpx1=tmpx1/10;
             }}else{while(!(tmpx1>=10&&tmpx1<=99))
             {
                 tmpx1=tmpx1/100;
             }}
             tmpx1=tmpx1*100;
             if(tmpy1<1000){
             while(!(tmpy1>=1&&tmpy1<=9))
             {
                 tmpy1=tmpy1/10;
             }}else{while(!(tmpy1>=10&&tmpy1<=99))
             {
                 tmpy1=tmpy1/100;
             }}
             tmpy1=tmpy1*100;

           //  System.out.println(tmpx1);
            // System.out.println(tmpy1);

             x1.add(tmpx1);
             y1.add(tmpy1);

             return true;


         case MotionEvent.ACTION_MOVE:



             break;

             case MotionEvent.ACTION_UP:
                 z=1;
                 line1=false;
                 line2=false;
                 line3=false;
                 line4=false;
                 line5=false;
                 line6=false;
                 tx1=Math.round(x);
                 ty1=Math.round(y);
                // xresult2=(int)event.getX();
                 //yresult2=(int)event.getY();
                 if(Math.abs(ty1-tmpy1)>=80) {



                     if ((ty1 - tmpy1)>0){

                         tmpy2=tmpy1+200;
                         tmpx2=tmpx1;

                     }


                     else {
                         tmpy2=tmpy1-200;
                         tmpx2=tmpx1;
                     }
                 }
                 else if(Math.abs(tx1-tmpx1)>=80)
                 {

                     if ((tx1 - tmpx1)>0) {
                         tmpy2=tmpy1;
                         tmpx2=tmpx1+200;


                     } else {

                         tmpy2=tmpy1;
                         tmpx2=tmpx1-200;

                     }
                 }
                 else
                 {
                     invalidate();
                 }
                 x2.add(tmpx2);
                 y2.add(tmpy2);

                 if(Math.abs(tmpx2-tmpx1)>0)
                 {
                    // line1=false;
                     //line2=false;
                     //line3=false;
                     if(tmpx2-tmpx1>0){

                         for (int i = 0; i < x1.size() - 1; i++) {
                             if ((tmpx1 == x1.get(i) && (tmpy1 - 200) == y1.get(i)) || (tmpx1 == x2.get(i) && (tmpy1 - 200) == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 - 200) == y1.get(i))) {
                                     line1 = true;
                                 }

                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if ((tmpx1 == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || ((tmpx1 == x1.get(i) && (tmpy1 - 200) == y1.get(i)))) {
                                     line2 = true;

                                 }

                             }
                             if ((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 - 200) == y1.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i))) {
                                     line3 = true;

                                 }

                             }
                             if(a==0) {

                                 if (line1 && line2 && line3) {
                                     a = 1;
                                     line1=false;
                                     line2=false;
                                     line3=false;
                                     // break;
                                 }
                             }


                         }
                         line1=false;
                         line2=false;
                         line3=false;

                         for (int i = 0; i < x1.size() - 1; i++) {
                             if ((tmpx1 == x1.get(i) && (tmpy1 + 200) == y1.get(i)) || (tmpx1 == x2.get(i) && (tmpy1 + 200) == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 + 200) == y1.get(i))) {
                                     line1 = true;
                                 }

                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if ((tmpx1 == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 == x1.get(i) && (tmpy1 + 200) == y1.get(i)))) {
                                     line2 = true;

                                 }

                             }
                             if ((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1+200) == x1.get(i) && (tmpy1+200) == y1.get(i))) {
                                     line3 = true;

                                 }

                             }
                             if(b==0) {

                                 if (line1 && line2 && line3) {
                                     b = 1;
                                     line1=false;
                                     line2=false;
                                     line3=false;

                                 }
                             }


                         }
                         line1=false;
                         line2=false;
                         line3=false;






                     }else{

                         int t=tmpx1;
                         tmpx1=tmpx2;
                         tmpx2=t;

                         for (int i = 0; i < x1.size() - 1; i++) {
                             if ((tmpx1 == x1.get(i) && (tmpy1 - 200) == y1.get(i)) || (tmpx1 == x2.get(i) && (tmpy1 - 200) == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 - 200) == y1.get(i))) {
                                     line1 = true;
                                 }

                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if ((tmpx1 == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || ((tmpx1 == x1.get(i) && (tmpy1 - 200) == y1.get(i)))) {
                                     line2 = true;

                                 }

                             }
                             if ((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 - 200) == y1.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 - 200) == y2.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i))) {
                                     line3 = true;

                                 }

                             }

                             if(a==0) {

                                 if (line1 && line2 && line3) {
                                     a = 1;
                                     line1=false;
                                     line2=false;
                                     line3=false;
                                     // break;
                                 }
                             }
                         }
                         line1=false;
                         line2=false;
                         line3=false;

                         for (int i = 0; i < x1.size() - 1; i++) {
                             if ((tmpx1 == x1.get(i) && (tmpy1 + 200) == y1.get(i)) || (tmpx1 == x2.get(i) && (tmpy1 + 200) == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 + 200) == y1.get(i))) {
                                     line1 = true;
                                 }

                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if ((tmpx1 == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 == x1.get(i) && (tmpy1 + 200) == y1.get(i)))) {
                                     line2 = true;

                                 }

                             }
                             if ((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1+200) == x1.get(i) && (tmpy1+200) == y1.get(i))) {
                                     line3 = true;

                                 }

                             }
                             if(b==0) {

                                 if (line1 && line2 && line3) {
                                     b = 1;
                                     line1=false;
                                     line2=false;
                                     line3=false;

                                 }
                             }


                         }
                         line1=false;
                         line2=false;
                         line3=false;
                        /* t=tmpx1;
                         tmpx1=tmpx2;
                         tmpx2=t;*/
                     }
                 }

                 if(Math.abs(tmpy2-tmpy1)>0)
                 {
                     /*if(tmpy2-tmpy1<0){
                         int t=tmpx1;
                         tmpx1=tmpx2;
                         tmpx2=t;

                     }*/
                     if(tmpy2-tmpy1>0) {
                         for (int i = 0; i < x1.size() - 1; i++) {

                             if (((tmpx1 + 200) == x1.get(i) && tmpy1 == y1.get(i)) || ((tmpx1 + 200) == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && (tmpy1 + 200) == y1.get(i))) {
                                     line4 = true;
                                 }
                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if (((tmpx1 + 200) == x2.get(i) && tmpy1 == y2.get(i)) || ((tmpx1 + 200) == x1.get(i) && tmpy1 == y1.get(i))) {
                                     line5 = true;
                                 }
                             }

                             if (((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i)))) {
                                 if (((tmpx2+200) == x2.get(i) && tmpy2 == y2.get(i)) || ((tmpx2+200) == x1.get(i) && tmpy2 == y1.get(i))) {
                                     line6 = true;
                                 }
                             }
                             if (c == 0) {
                                 if (line4 && line5 && line6) {
                                     c = 1;
                                     line4 = false;
                                     line5 = false;
                                     line6 = false;
                                 }
                             }

                         }

                         line4 = false;
                         line5 = false;
                         line6 = false;

                         for (int i = 0; i < x1.size() - 1; i++) {

                             if (((tmpx1 - 200) == x1.get(i) && tmpy1 == y1.get(i)) || ((tmpx1 - 200) == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if (((tmpx1 - 200) == x2.get(i) && (tmpy1 + 200) == y2.get(i)) || ((tmpx1 - 200) == x1.get(i) && (tmpy1 + 200) == y1.get(i))) {
                                     line4 = true;
                                 }
                             }

                             if ((tmpx1 == x1.get(i) && tmpy1 == y1.get(i)) || (tmpx1 == x2.get(i) && tmpy1 == y2.get(i))) {
                                 if (((tmpx1 - 200) == x2.get(i) && tmpy1 == y2.get(i)) || ((tmpx1 - 200) == x1.get(i) && tmpy1 == y1.get(i))) {
                                     line5 = true;
                                 }
                             }


                                 if ((tmpx2 == x1.get(i) && tmpy2 == y1.get(i)) || (tmpx2 == x2.get(i) && tmpy2 == y2.get(i))) {
                                     if (((tmpx2 - 200) == x2.get(i) && tmpy2 == y2.get(i)) || ((tmpx2 - 200) == x1.get(i) && tmpy2 == y1.get(i))) {
                                     line6 = true;
                                 }
                             }
                             if (d == 0) {
                                 if (line4 && line5 && line6) {
                                     d = 1;
                                     line4 = false;
                                     line5 = false;
                                     line6 = false;
                                 }
                             }
                         }

                         line4 = false;
                         line5 = false;
                         line6 = false;

                     } else
                     {

                         int t=tmpy1;
                         tmpy1=tmpy2;
                         tmpy2=t;
                         for(int i=0;i<x1.size()-1;i++)
                         {

                             if(((tmpx1+200)==x1.get(i)&&tmpy1==y1.get(i))||((tmpx1+200)==x2.get(i)&&tmpy1==y2.get(i))){
                                 if(((tmpx1+200)==x2.get(i)&&(tmpy1+200)==y2.get(i))||((tmpx1+200)==x1.get(i)&&(tmpy1+200)==y1.get(i))) {
                                     line4 = true;
                                 }
                             }

                             if((tmpx1==x1.get(i)&&tmpy1==y1.get(i))||(tmpx1==x2.get(i)&&tmpy1==y2.get(i))){
                                 if(((tmpx1+200)==x2.get(i)&&tmpy1==y2.get(i))||((tmpx1+200)==x1.get(i)&&tmpy1==y1.get(i))) {
                                     line5 = true;
                                 }
                             }

                             if(((tmpx1+200)==x2.get(i)&&(tmpy1+200)==y2.get(i))||((tmpx1+200)==x1.get(i)&&(tmpy1+200)==y1.get(i))){
                                 if((tmpx2==x1.get(i)&&tmpy2==y1.get(i))||(tmpx2==x2.get(i)&&tmpy2==y2.get(i))) {
                                     line6 = true;
                                 }
                             }

                             if(c==0) {
                                 // c=1;
                                 if (line4 && line5 && line6) {
                                     c = 1;
                                    // System.out.println("c="+c);
                                     //System.out.println("d="+d);
                                     //System.out.println("line4="+line4);
                                     //System.out.println("line5="+line5);
                                     //System.out.println("line6="+line6);
                                     line4 = false;
                                     line5 = false;
                                     line6 = false;
                                 }
                             }
                         }
                         line4 = false;
                         line5 = false;
                         line6 = false;


                         for(int i=0;i<x1.size()-1;i++)
                         {

                             if(((tmpx1-200)==x1.get(i)&&tmpy1==y1.get(i))||((tmpx1-200)==x2.get(i)&&tmpy1==y2.get(i))){
                                 if(((tmpx1-200)==x2.get(i)&&(tmpy1+200)==y2.get(i))||((tmpx1-200)==x1.get(i)&&(tmpy1+200)==y1.get(i))) {
                                     line4 = true;
                                 }
                             }

                             if((tmpx1==x1.get(i)&&tmpy1==y1.get(i))||(tmpx1==x2.get(i)&&tmpy1==y2.get(i))){
                                 if(((tmpx1-200)==x2.get(i)&&tmpy1==y2.get(i))||((tmpx1-200)==x1.get(i)&&tmpy1==y1.get(i))) {
                                     line5 = true;
                                 }
                             }

                             if(((tmpx1-200)==x2.get(i)&&(tmpy1+200)==y2.get(i))||((tmpx1-200)==x1.get(i)&&(tmpy1+200)==y1.get(i))){
                                 if((tmpx2==x1.get(i)&&tmpy2==y1.get(i))||(tmpx2==x2.get(i)&&tmpy2==y2.get(i))) {
                                     line6 = true;
                                 }
                             }
                             if(d==0) {
                                 // d=1;
                                 if (line4 && line5 && line6) {
                                     d = 1;
                                   //  System.out.println("c="+c);
                                    // System.out.println("d="+d);
                                     //System.out.println("line4="+line4);
                                     //System.out.println("line5="+line5);
                                     //System.out.println("line6="+line6);
                                     line4 = false;
                                     line5 = false;
                                     line6 = false;
                                 }
                             }
                         }
                         line4 = false;
                         line5 = false;
                         line6 = false;



                     }

                 }
                 invalidate();

                 System.out.println("Line1="+line1);
                 System.out.println("Line2="+line2);
                 System.out.println("Line3="+line3);



                 break;
         default:
             return false;

     }
       //System.out.println(x);
        //System.out.println(y);

        return true;


    }
    public void launch() {
        if(p==2) {
            Intent i = new Intent(getContext(), Result.class);
            i.putExtra("players",p);
            i.putExtra("score1", score1);
            i.putExtra("score2", score2);

            getContext().startActivity(i);
        } if(p==3) {
            Intent i = new Intent(getContext(), Result.class);
            i.putExtra("players",p);
            i.putExtra("score1", score1);
            i.putExtra("score2", score2);
            i.putExtra("score3",score3);

            getContext().startActivity(i);
        }
        if(p==4) {
            Intent i = new Intent(getContext(), Result.class);
            i.putExtra("players",p);
            i.putExtra("score1", score1);
            i.putExtra("score2", score2);
            i.putExtra("score3",score3);
            i.putExtra("score4",score4);

            getContext().startActivity(i);


        }

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public  void undo(){
        undo=1;
        if(count>=1&&flag==1)
            invalidate();


    }
}
