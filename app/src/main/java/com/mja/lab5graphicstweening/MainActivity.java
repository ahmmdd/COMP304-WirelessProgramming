package com.mja.lab5graphicstweening;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animate(View view) {
        ImageView iView = (ImageView)findViewById(R.id.imageView1);
        ShapeDrawable rect = new ShapeDrawable(new RectShape());
        rect.setIntrinsicHeight(100);
        rect.setIntrinsicWidth(200);
        rect.getPaint().setColor(Color.MAGENTA);
        iView.setImageDrawable(rect);

        Animation animation = null;

        switch (view.getId()) {
            case R.id.buttonFade:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                iView.startAnimation(animation);
                break;

            case R.id.buttonGrow:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                iView.startAnimation(animation);
                break;

            case R.id.buttonMove:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
                // example how to intercept animation events like, start and stop animation
                // we register a custom listener that implements the call back methods
                animation.setAnimationListener(new CustomAnimationListener());
                iView.startAnimation(animation);
                break;

            case R.id.buttonSpin:
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iView.startAnimation(animation);
                break;

            default:
                break;
        }
    }
    class CustomAnimationListener implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
            // executes at the end of animation
            Toast.makeText(getBaseContext(), "Animation finished", Toast.LENGTH_SHORT).show();
        }
        public void onAnimationRepeat(Animation animation) {
            Toast.makeText(getBaseContext(), "Animation repeats", Toast.LENGTH_SHORT).show();
        }
        public void onAnimationStart(Animation animation) {
            Toast.makeText(getBaseContext(), "Animation started", Toast.LENGTH_SHORT).show();
        }
    }
}
