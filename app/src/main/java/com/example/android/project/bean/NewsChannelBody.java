package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsChannelBody {
    private int totalNum;

    private int ret_code;

    private List<NewsChannel> channelList;

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public int getRet_code() {
        return this.ret_code;
    }

    public void setChannelList(List<NewsChannel> channelList) {
        this.channelList = channelList;
    }

    public List<NewsChannel> getChannelList() {
        return this.channelList;
    }
}
