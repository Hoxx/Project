package com.example.android.project;

import android.app.Application;

import com.example.android.project.net.NetConstant;
import com.example.android.project.net.RetrofitUtil;

/**
 * Created by Android on 2017/3/30.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        RetrofitUtil.getInstance().init(NetConstant.BASE_URL);
    }
}
