package com.cc.mja.lab5graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.view.View;

public class BitmapDrawingView extends View {
    public BitmapDrawingView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.cardinal);
        canvas.drawBitmap(pic, 0, 0, null);

        Matrix mirrorMatrix = new Matrix();
        mirrorMatrix.preScale(-1, 1);
        Bitmap mirrorPic = Bitmap.createBitmap(pic, 0, 0,
                pic.getWidth(), pic.getHeight(), mirrorMatrix, false);
        canvas.drawBitmap(mirrorPic, pic.getHeight(), 0, null);

        Matrix mirrorAndTilt30 = new Matrix();
        mirrorAndTilt30.preRotate(30);
        mirrorAndTilt30.preScale(-1, 1);
        Bitmap tiltPic = Bitmap.createBitmap(pic, 0, 0,
                pic.getWidth(), pic.getHeight(), mirrorAndTilt30, false);

        canvas.drawBitmap(tiltPic, 0, pic.getHeight(), null);
    }
}
