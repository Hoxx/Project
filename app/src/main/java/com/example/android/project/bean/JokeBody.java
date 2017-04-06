package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class JokeBody {

    private int allPages;

    private int ret_code;

    private List<Joke> contentlist;

    private int currentPage;

    private int allNum;

    private int maxResult;

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getAllPages() {
        return this.allPages;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getRet_code() {
        return this.ret_code;
    }

    public void setContentlist(List<Joke> contentlist) {
        this.contentlist = contentlist;
    }

    public List<Joke> getContentlist() {
        return this.contentlist;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getAllNum() {
        return this.allNum;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public int getMaxResult() {
        return this.maxResult;
    }
}
