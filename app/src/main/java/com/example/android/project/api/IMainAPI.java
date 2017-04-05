package com.example.android.project.api;

import com.example.android.project.bean.Root;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Android on 2017/4/1.
 */

public interface IMainAPI {

    @GET("{pageCount}/{page}")
    Observable<Root> getVideoList(@Path("pageCount") String pageCount, @Path("page") String page);

}
