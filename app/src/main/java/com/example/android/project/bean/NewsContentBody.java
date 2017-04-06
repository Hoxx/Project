package com.example.android.project.bean;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContentBody {
    private int ret_code;

    private NewsContentPage pagebean;

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getRet_code() {
        return this.ret_code;
    }

    public void setPagebean(NewsContentPage pagebean) {
        this.pagebean = pagebean;
    }

    public NewsContentPage getPagebean() {
        return this.pagebean;
    }
}
