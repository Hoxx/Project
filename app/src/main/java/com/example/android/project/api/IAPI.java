package com.example.android.project.api;

import com.example.android.project.bean.ImageRoot;
import com.example.android.project.bean.JokeRoot;
import com.example.android.project.bean.NewsChannel;
import com.example.android.project.bean.NewsChannelRoot;
import com.example.android.project.bean.NewsContentRoot;

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

    //JokeList:http://route.showapi.com/341-3?showapi_appid=33164&page=1&maxResult=10
    // &showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("341-3")
    Observable<JokeRoot> getJokeList(@Query("page") String page, @Query("maxResult") String maxResult);

    //http://route.showapi.com/109-34?showapi_appid=33164&showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("109-34")
    Observable<NewsChannelRoot> getNewsChannel();


    //http://route.showapi.com/109-35?showapi_appid=33164
    // &channelId=5572a108b3cdc86cf39001d0
    // &channelName=%E8%B4%A2%E7%BB%8F%E7%84%A6%E7%82%B9
    // &title=
    // &page=1
    // &needContent=1
    // &needHtml=1
    // &needAllList=1
    // &maxResult=1
    // &showapi_sign=ed8aa3ba15074a9abf8f5b0f80b4a692
    @GET("109-35")
    Observable<NewsContentRoot> getNewsContent(
            @Query("channelId") String channelId,//新闻频道id，必须精确匹配
            @Query("channelName") String channelName,//新闻频道名称，可模糊匹配
            @Query("title") String title,//标题名称，可模糊匹配
            @Query("page") String page,//页数，默认1。每页最多20条记录。
            @Query("needContent") String needContent,//是否需要返回正文，1为需要，其他为不需要
            @Query("needHtml") String needHtml,//是否需要返回正文的html格式，1为需要，其他为不需要
            @Query("needAllList") String needAllList,//是否需要最全的返回资料。包括每一段文本和每一张图。用list的形式返回。
            @Query("maxResult") String maxResult);//每页返回记录数，值在20-100之间。
}
