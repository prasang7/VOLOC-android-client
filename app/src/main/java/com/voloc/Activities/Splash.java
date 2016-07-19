package com.voloc.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.voloc.R;

/**
 * Created by prasang on 19/4/16.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        runTimer();
    }

    void init() {
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    void runTimer() {

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    finish();
                    //startActivity(new Intent(Splash.this, LoginSignup.class));
                    Intent i = new Intent(Splash.this, LoginSignup.class);
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
}
