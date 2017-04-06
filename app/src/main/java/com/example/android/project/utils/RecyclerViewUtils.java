package com.example.android.project.utils;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Android on 2017/4/6.
 */

public class RecyclerViewUtils {

    public static void setOnScrollBottom(RecyclerView recyclerView, final OnScrollBottom onScrollBottom) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (isSlideToBottom(recyclerView)) {
                    if (onScrollBottom != null)
                        onScrollBottom.onBottom();
                }
            }
        });
    }

    static boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }


    public interface OnScrollBottom {
        void onBottom();
    }
}
