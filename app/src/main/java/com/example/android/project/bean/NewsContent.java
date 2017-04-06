package com.example.android.project.bean;

import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContent {

    private List<Object> allList;

    private String pubDate;

    private boolean havePic;

    private String title;

    private String channelName;

    private List<NewsContentImage> imageurls;

    private String desc;

    private String source;

    private String channelId;

    private String link;

    public void setAllList(List<Object> allList) {
        this.allList = allList;
    }

    public List<Object> getAllList() {
        return this.allList;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setHavePic(boolean havePic) {
        this.havePic = havePic;
    }

    public boolean getHavePic() {
        return this.havePic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setImageurls(List<NewsContentImage> imageurls) {
        this.imageurls = imageurls;
    }

    public List<NewsContentImage> getImageurls() {
        return this.imageurls;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return this.source;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }
}
