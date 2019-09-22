package com.pvkhaicd.samngoclinh.ViewController.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.pvkhaicd.samngoclinh.R;
import com.pvkhaicd.samngoclinh.ViewController.MainActivity;

public class splash_screen extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_TIME = 800;
    SessionManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        manager =  new SessionManager(splash_screen.this);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                if (manager.isLogin()) {

                    intent.setClass(splash_screen.this,
                            MainActivity.class);


                } else {
                    intent.setClass(splash_screen.this, LoginActivity.class);
                }

                splash_screen.this.startActivity(intent);
                splash_screen.this.finish();
            }
        }, SPLASH_DISPLAY_TIME);
    }
}
