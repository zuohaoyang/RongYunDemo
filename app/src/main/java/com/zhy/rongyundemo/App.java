package com.zhy.rongyundemo;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by admin on 2016/12/11.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(getApplicationContext());
    }
}
