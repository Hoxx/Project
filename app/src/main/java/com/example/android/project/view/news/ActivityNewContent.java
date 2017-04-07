package com.example.android.project.view.news;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterNewsContentImage;
import com.example.android.project.base.BaseActivity;
import com.example.android.project.bean.NewsContent;
import com.example.android.project.bean.NewsContentImage;
import com.example.android.project.net.Constant;

import java.io.UnsupportedEncodingException;

public class ActivityNewContent extends BaseActivity {

    private TextView tv_news_all_content_title;
    private TextView tv_news_all_content_time;
    private RecyclerView recyclerview_news_all_content_image;
    private TextView tv_news_all_content_content;

    private Toolbar toolbar_news_content;

    @Override
    public int setLayoutView() {
        return R.layout.activity_news_all_content;
    }

    @Override
    public void initView() {
        toolbar_news_content = (Toolbar) findViewById(R.id.toolbar_news_content);
        tv_news_all_content_title = (TextView) findViewById(R.id.tv_news_all_content_title);
        tv_news_all_content_time = (TextView) findViewById(R.id.tv_news_all_content_time);
        recyclerview_news_all_content_image = (RecyclerView) findViewById(R.id.recyclerview_news_all_content_image);
        tv_news_all_content_content = (TextView) findViewById(R.id.tv_news_all_content_content);
    }

    @Override
    public void initData() {
        setSupportActionBar(toolbar_news_content);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        NewsContent content = (NewsContent) getIntent().getSerializableExtra(Constant.NEWS_CONTENT);
        setData(content);
    }

    private void setData(NewsContent newsContent) {
        tv_news_all_content_title.setText(newsContent.getTitle());
        tv_news_all_content_time.setText(newsContent.getPubDate());
        tv_news_all_content_content.setText(newsContent.getContent());
        if (newsContent.getHavePic()) {
            recyclerview_news_all_content_image.setVisibility(View.VISIBLE);
            if (newsContent.getImageurls().size() <= 4) {
                recyclerview_news_all_content_image.setLayoutManager(new GridLayoutManager(this, 2) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
            } else {
                recyclerview_news_all_content_image.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            }
            AdapterNewsContentImage adapterNewsContentImage = new AdapterNewsContentImage(this, newsContent.getImageurls());
            recyclerview_news_all_content_image.setAdapter(adapterNewsContentImage);
        } else {
            recyclerview_news_all_content_image.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
