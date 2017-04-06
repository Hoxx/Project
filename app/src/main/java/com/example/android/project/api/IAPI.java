package com.example.android.project.api;

import com.example.android.project.bean.ImageRoot;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Android on 2017/4/1.
 */

public interface IAPI {
    //ImageList:http://route.showapi.com/1208-3?showapi_appid=33164&id=2&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("1208-3")
    Observable<ImageRoot> getImageList(@Query("id") String page, @Query("showapi_appid") String showapi_appid,
                                       @Query("showapi_sign") String showapi_sign);

    @GET("1208-3")
    Observable<ImageRoot> getImageList(@Query("id") String page);

}
