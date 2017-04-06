package com.example.android.project.api;

import com.example.android.project.bean.ImageRoot;
import com.example.android.project.bean.JokeRoot;
import com.example.android.project.bean.NewsChannel;
import com.example.android.project.bean.NewsChannelRoot;

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

    //http://route.showapi.com/109-34?showapi_appid=33164&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("109-34")
    Observable<NewsChannelRoot> getNewsChannel();


    //http://route.showapi.com/109-35?showapi_appid=33164&channelId=5572a108b3cdc86cf39001d0
    // &channelName=%E8%B4%A2%E7%BB%8F%E7%84%A6%E7%82%B9&title=&page=1&needContent=2&needHtml=&needAllList=
    // &maxResult=2&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("109-35")
    Observable<NewsChannelRoot> getNewsContent(@Query("channelId") String channelId,
                                               @Query("channelName") String channelName,
                                               @Query("title") String title,
                                               @Query("page") String page,
                                               @Query("needContent") String needContent,
                                               @Query("needHtml") String needHtml,
                                               @Query("needAllList") String needAllList,
                                               @Query("maxResult") String maxResult);
}
