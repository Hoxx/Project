package com.example.android.project.bean;

import java.io.Serializable;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContentImage implements Serializable {

    private int height;

    private int width;

    private String url;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
