package com.example.android.project.bean;

/**
 * Created by Android on 2017/4/6.
 */

public class Joke {
    private String id;

    private String title;

    private String img;

    private int type;

    private String ct;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return this.img;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCt() {
        return this.ct;
    }
}
