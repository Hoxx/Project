package com.example.android.project.net;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .addInterceptor(getInterceptor())//这里大家一定要注意了是addNetworkOnterceptor别搞错了啊。
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl httpUrl = request.url().newBuilder()
                        .setEncodedQueryParameter("showapi_appid", Constant.APP_ID)
                        .setEncodedQueryParameter("showapi_sign", Constant.APP_KEY).build();
                Request newRequest = request.newBuilder().method(request.method(), request.body())
                        .url(httpUrl).build();
                Response response = chain.proceed(newRequest);
                return response;
            }
        };
    }

}
