package com.example.android.project.base;

/**
 * Created by Android on 2017/4/1.
 */

public abstract class BasePresenter {

    private IBaseView baseView;

    public BasePresenter(IBaseView baseView) {
        this.baseView = baseView;
    }

    public void detachView() {
        if (baseView != null)
            baseView = null;
    }


}
