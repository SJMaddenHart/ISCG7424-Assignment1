package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class DrawView extends View implements View.OnTouchListener {

    class PaintCoordinate
    {
        PointF Point;
        float radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    ArrayList <PaintCoordinate> points = new ArrayList<PaintCoordinate>();

    float radius = 5;

    public DrawView(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Random random = new Random();
        paint.setColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));

        for(PaintCoordinate pc : points){
            canvas.drawCircle(pc.Point.x, pc.Point.y, pc.radius,paint);
            paint.setColor(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        PaintCoordinate pc = new PaintCoordinate();
        PointF Point = new PointF();
        Point.set(event.getX(), event.getY());

        pc.Point= Point;
        pc.radius = radius;
        points.add(pc);

        invalidate();

        return true;

    }
}
