package com.example.android.project.view.main;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterImage;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.presenter.ImagePresenter;
import com.example.android.project.utils.PhotoViewDialog;
import com.example.android.project.utils.RecyclerViewUtils;
import com.example.android.project.view.IImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentImage extends BaseFragment implements IImageView, AdapterImage.onItemClickListener, RecyclerViewUtils.OnScrollBottom, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recycler_image;
    private AdapterImage adapterImage;

    private SwipeRefreshLayout refreshLayout;

    private List<String> dataList;

    private ImagePresenter presenter;

    private PhotoViewDialog dialog;

    private int page = 1;

    @Override
    public int setLayout() {
        return R.layout.fragment_image;
    }

    @Override
    public void initView() {
        refreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.refreshlayout_image);
        refreshLayout.setOnRefreshListener(this);
        recycler_image = (RecyclerView) rootView.findViewById(R.id.recycler_image);
        recycler_image.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RecyclerViewUtils.setOnScrollBottom(recycler_image, this);
    }

    @Override
    public void initDate() {
        dataList = new ArrayList<>();
        adapterImage = new AdapterImage(dataList, getActivity());
        recycler_image.setAdapter(adapterImage);
        adapterImage.setOnItemClickListener(this);
        dialog = new PhotoViewDialog(getActivity());
        presenter = new ImagePresenter(this);
        presenter.getData();
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
        if (refreshLayout.isRefreshing())
            refreshLayout.setRefreshing(false);
    }

    @Override
    public void setData(List<String> list) {
        dataList.addAll(list);
        adapterImage.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onItemClick(int position) {
        dialog.setImage(dataList.get(position));
        dialog.show();
    }

    @Override
    public void onBottom() {
        page++;
        presenter.LoadData(page);
    }

    @Override
    public void onRefresh() {
        dataList.clear();
        presenter.refreshData();
    }
}
