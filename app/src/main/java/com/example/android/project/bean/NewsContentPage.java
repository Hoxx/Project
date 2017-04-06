package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContentPage {
    private int allPages;

    private List<NewsContent> contentlist;

    private int currentPage;

    private int allNum;

    private int maxResult;

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getAllPages() {
        return this.allPages;
    }

    public void setContentlist(List<NewsContent> contentlist) {
        this.contentlist = contentlist;
    }

    public List<NewsContent> getContentlist() {
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
