package com.example.android.project.base;

import com.example.android.project.net.HttpManager;
import com.example.android.project.net.RetrofitUtil;

import retrofit2.Retrofit;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BaseModel {

    public HttpManager httpManager;

    public Retrofit retrofit;

    public BaseModel() {
        httpManager = new HttpManager();
        retrofit = RetrofitUtil.getInstance().getRetrofit();
    }
}
