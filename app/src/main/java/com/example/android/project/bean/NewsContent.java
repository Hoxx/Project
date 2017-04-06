package com.example.android.project.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Android on 2017/4/6.
 */

public class NewsContent implements Serializable {

    private String content;

    private List<String> allList;

    private String pubDate;

    private boolean havePic;

    private String title;

    private String channelName;

    private List<NewsContentImage> imageurls;

    private String desc;

    private String source;

    private String channelId;

    private String link;

    private String html;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setAllList(List<String> allList) {
        this.allList = allList;
    }

    public List<String> getAllList() {
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

    public void setHtml(String html) {
        this.html = html;
    }

    public String getHtml() {
        return this.html;
    }
}
