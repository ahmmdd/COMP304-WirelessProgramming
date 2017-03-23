package com.cc.mja.lab5graphics;
 import android.content.Context;
 import android.graphics.Canvas;
 import android.graphics.Color;
 import android.graphics.Paint;
 import android.graphics.Path;
 import android.view.View;

public class DrawLinesView extends View {

    // declare constants visible across app, easy to refer from different places
    public static final int DIRECTION_DOWN = 0;
    public static final int DIRECTION_RIGHT = 1;

    private int currentDirection;
    private Path currentPath = new Path();
    private float currentX;
    private float currentY;

    public DrawLinesView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // this code is executed first time the class is loaded
        // as well as each time the invalidate() method is invoked (see main activity)
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        switch (currentDirection) {
            case DIRECTION_RIGHT:
                currentX += 10;
                break;

            case DIRECTION_DOWN:
                currentY += 10;
                break;

            default:
                break;
        }
        currentPath.lineTo(currentX, currentY);
        canvas.drawPath(currentPath, paint);
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

}