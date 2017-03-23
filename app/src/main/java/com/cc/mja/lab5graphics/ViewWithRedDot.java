package com.cc.mja.lab5graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.view.View;

public class ViewWithRedDot extends View {
    public ViewWithRedDot(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint circlePaint = new Paint();
        circlePaint.setColor(Color.RED);

        //to draw just the contour of the circle
        //circlePaint.setStyle(Paint.Style.STROKE);

        // apply a gradient
        LinearGradient linGrad = new LinearGradient(0, 0, 25, 25,
                Color.RED, Color.BLACK,
                Shader.TileMode.MIRROR);
        circlePaint.setShader(linGrad);

        // draw the circle
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() / 3, circlePaint);

        //WORKING WITH TEXT
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(32);
        //textPaint.setc
        textPaint.setTypeface(null);

        //drawText(CharSequence text, int start, int end, float x, float y, Paint paint)
        //Draw the specified range of text, specified by start/end, with its origin at (x,y), in the specified Paint.

        canvas.drawText("Default Typeface", 20, 60, textPaint);
        // monospace normal
        Typeface mNormal = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
        textPaint.setTypeface(mNormal);
        canvas.drawText("Monospace Normal Typeface", 20, 120, textPaint);
        // serif italic
        Typeface serifItalic = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
        textPaint.setTypeface(serifItalic);
        canvas.drawText("Serif Italic Typeface", 20, 180, textPaint);

        // now write text underlined and serif italic
        textPaint.setFlags(Paint.UNDERLINE_TEXT_FLAG);
        canvas.drawText("This is underlined", 20, 240, textPaint);
    }
}
