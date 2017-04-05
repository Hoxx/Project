package com.example.android.project.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Android on 2017/4/5.
 */

public class OkHttpUtil {

    private OkHttpClient client;
    private OkHttpClient.Builder builder;


    private void init() {
        builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String url = request.url().toString();
                url += "showapi_appid=" + NetConstant.APP_ID + "&showapi_sign=" + NetConstant.APP_KEY;
                return chain.proceed(request);
            }
        });
    }

}
