package com.example.android.project.api;

import com.example.android.project.bean.ImageRoot;
import com.example.android.project.bean.JokeRoot;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 2017/4/1.
 */

public interface IAPI {
    //ImageList:http://route.showapi.com/1208-3?showapi_appid=33164&id=2&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("1208-3")
    Observable<ImageRoot> getImageList(@Query("id") String id);

    //JokeList:http://route.showapi.com/341-3?showapi_appid=33164&page=1&maxResult=10&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("341-3")
    Observable<JokeRoot> getJokeList(@Query("page") String page, @Query("maxResult") String maxResult);

}
