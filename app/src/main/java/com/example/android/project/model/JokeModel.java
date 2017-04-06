package com.example.android.project.model;

import com.example.android.project.base.BaseModel;
import com.example.android.project.base.IBaseDataInterface;
import com.example.android.project.bean.Joke;
import com.example.android.project.bean.JokeRoot;
import com.example.android.project.datainterface.IJokeCallback;
import com.example.android.project.net.NetConstant;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by Android on 2017/4/6.
 */

public class JokeModel extends BaseModel implements IJokeModel {

    private IJokeCallback jokeCallback;

    private Observer<List<Joke>> observer = new Observer<List<Joke>>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(List<Joke> list) {
            if (jokeCallback != null)
                jokeCallback.onSuccess(list);
        }

        @Override
        public void onError(Throwable e) {
            if (jokeCallback != null)
                jokeCallback.onError(e.toString());
        }

        @Override
        public void onComplete() {

        }
    };
    private Function<JokeRoot, List<Joke>> function = new Function<JokeRoot, List<Joke>>() {
        @Override
        public List<Joke> apply(JokeRoot jokeRoot) throws Exception {
            return jokeRoot.getShowapi_res_body().getContentlist();
        }
    };


    @Override
    public void getData(IBaseDataInterface dataInterface) {
        jokeCallback = (IJokeCallback) dataInterface;
        loadData();
    }

    @Override
    public void onRefreshData() {
        loadData();
    }

    @Override
    public void onLoadData(int page) {
        request(iAPI.getJokeList("" + page, NetConstant.MAX_RESULT), function, observer);
    }

    private void loadData() {
        request(iAPI.getJokeList("1", NetConstant.MAX_RESULT), function, observer);
    }
}
