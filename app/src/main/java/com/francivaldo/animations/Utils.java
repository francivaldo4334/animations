package com.francivaldo.animations;

import android.os.Handler;

public class Utils {

    // Delay mechanism

    public static interface DelayCallback {
        void afterDelay();
    }

    public static void delay(int secs, final DelayCallback delayCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, secs); // afterDelay will be executed after (secs*1000) milliseconds.
    }
}
