package com.example.android.project.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Android on 2017/3/30.
 */

public class RetrofitUtil {

    private Retrofit retrofit;
    private static RetrofitUtil retrofitUtil = new RetrofitUtil();

    public static RetrofitUtil getInstance() {
        return retrofitUtil;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void init(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
        //定义请求Client
//    private void initClient(){
//        OkHttpClient.Builder builder=new OkHttpClient.Builder();
//    }

}
