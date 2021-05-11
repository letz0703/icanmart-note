package com.letz.icanmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    // animation for Image and Text
    Animation animationImage, animationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        animationImage = AnimationUtils.loadAnimation(this, R.anim.image_animation);
        animationText = AnimationUtils.loadAnimation(this, R.anim.text_animation);

        imageView.setAnimation(animationImage);
        textView.setAnimation(animationText);

        // Main Activity 자동 오픈 시키키 : count down timer 사용
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                // new Intent 장면전환 splash.this to MainActivity.class 그리고
                // 끝내기
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();

    }
}