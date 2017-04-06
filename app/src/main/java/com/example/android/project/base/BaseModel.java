package com.example.android.project.base;

import com.example.android.project.api.IAPI;
import com.example.android.project.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BaseModel {

    public Retrofit retrofit;
    public IAPI iAPI;

    public BaseModel() {
        retrofit = RetrofitUtil.getInstance().getRetrofit();
        iAPI = retrofit.create(IAPI.class);
    }

    public <T, R> void request(Observable<T> observable, Function<? super T, R> f, Observer<R> observer) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(f).subscribe(observer);
    }

    public <T> void request(Observable<T> observable, Observer<? super T> observer) {
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
