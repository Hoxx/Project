package com.example.android.project;

import android.app.Application;

import com.example.android.project.net.Constant;
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
        RetrofitUtil.getInstance().init(Constant.BASE_URL);
    }
}
