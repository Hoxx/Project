package com.example.android.project.bean;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsChannelRoot {
    private int showapi_res_code;

    private String showapi_res_error;

    private NewsChannelBody showapi_res_body;

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public int getShowapi_res_code() {
        return this.showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_error() {
        return this.showapi_res_error;
    }

    public void setShowapi_res_body(NewsChannelBody showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public NewsChannelBody getShowapi_res_body() {
        return this.showapi_res_body;
    }
}
