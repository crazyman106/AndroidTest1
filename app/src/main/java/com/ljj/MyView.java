package com.ljj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    TextPaint textPaint = null;
    StaticLayout staticLayout = null;
    Paint paint = null;
    int width = 50;
    int height = 0;
    String txt = null;
    boolean running = false;


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(48);
        txt = "fsdafsdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafsdafsdaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdfaaaaaaaaaaaaaaaaaaaaasdf";
        staticLayout = new StaticLayout(txt, textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
        height = staticLayout.getHeight();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    public MyView(Context context) {
        super(context);
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(12);
        txt = "fsdafsdaaaaaaaaaaaaaaaaaaaaaaaaaaaafsdafsdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\naaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasdf";
        staticLayout = new StaticLayout(txt, textPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
        height = staticLayout.getHeight();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub  
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                running = !running;
                if (running) {
                    new Thread() {
                        public void run() {
                            while (running) {
                                width++;
                                staticLayout = new StaticLayout(txt, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
                                height = staticLayout.getHeight();
                                postInvalidate();
                                try {
                                    Thread.sleep(50);
                                } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                if (width >= 300) {
                                    width = 50;
                                }
                            }
                        }

                        ;
                    }.start();
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        staticLayout.draw(canvas);
        canvas.drawRect(0, 0, width, height, paint);
        super.onDraw(canvas);
    }

}  