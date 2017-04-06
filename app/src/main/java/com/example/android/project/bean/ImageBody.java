package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class ImageBody {

    private int ret_code;

    private int count;

    private String ret_message;

    private List<String> data;

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getRet_code() {
        return this.ret_code;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void setRet_message(String ret_message) {
        this.ret_message = ret_message;
    }

    public String getRet_message() {
        return this.ret_message;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return this.data;

    }
}
