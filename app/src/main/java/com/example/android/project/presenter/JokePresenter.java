package com.example.android.project.presenter;

import com.example.android.project.base.BasePresenter;
import com.example.android.project.base.IBaseView;
import com.example.android.project.bean.Joke;
import com.example.android.project.datainterface.IJokeCallback;
import com.example.android.project.model.IJokeModel;
import com.example.android.project.model.JokeModel;
import com.example.android.project.view.IJokeView;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class JokePresenter extends BasePresenter {

    private IJokeView iJokeView;
    private IJokeModel jokeModel;

    public JokePresenter(IBaseView baseView) {
        super(baseView);
        iJokeView = (IJokeView) baseView;
        jokeModel = new JokeModel();
    }

    @Override
    public void getData() {
        iJokeView.showLoading();
        jokeModel.getData(new IJokeCallback() {
            @Override
            public void onSuccess(List<Joke> list) {
                if (iJokeView != null)
                    iJokeView.setData(list);
                iJokeView.hideLoading();
            }

            @Override
            public void onError(String msg) {
                iJokeView.hideLoading();
            }
        });
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void LoadData(int page) {

    }

}
