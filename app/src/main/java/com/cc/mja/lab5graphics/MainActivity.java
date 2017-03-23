package com.cc.mja.lab5graphics;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // declare DrawLinesView as private attribute so tat is
    // visible in method drawLine
    private DrawLinesView drawView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Uncomment each section accordingly, keep the rest commented

        //DRAWING, PAINT, GRADIENTS, TEXT
        //setContentView(new ViewWithRedDot(this));

        // BITMAP DRAWING
        //setContentView(new BitmapDrawing(this));

        // FRAME ANIMATION
        /*
        setContentView(R.layout.activity_main);
        ImageView iView = (ImageView) findViewById(R.id.imageView1);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame1);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame2);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.frame3);

        int duration = 1000;
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(frame1, duration);
        animation.addFrame(frame2, duration);
        animation.addFrame(frame3, duration);

        iView.setBackgroundDrawable(animation);
        animation.start();
        */

        // DRAW LINES
        // see DrawLinesView
        setContentView(R.layout.draw_lines);
        drawView = new DrawLinesView(this);
        drawView.setBackgroundColor(Color.WHITE);
        ViewGroup parentLayout = (ViewGroup) findViewById(R.id.parentLayout);
        parentLayout.addView(drawView);

    }

    public void drawLine(View view) {
        switch (view.getId()) {
            case R.id.buttonDown:
                // tell DrawLinesView what direction to move the line when onDraw is executed
                drawView.setCurrentDirection(DrawLinesView.DIRECTION_DOWN);
                // invalidate() forces an invocation of onDraw method
                drawView.invalidate();
                break;

            case R.id.buttonRight:
                drawView.setCurrentDirection(DrawLinesView.DIRECTION_RIGHT);
                // force invocation of onDraw method
                drawView.invalidate();
                break;

            default:
                break;
        }
    }
}

