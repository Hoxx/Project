package com.example.android.project.view.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterImage;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.presenter.ImagePresenter;
import com.example.android.project.utils.PhotoViewDialog;
import com.example.android.project.view.IImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentImage extends BaseFragment implements IImageView, AdapterImage.onItemClickListener {

    private RecyclerView recycler_image;
    private AdapterImage adapterImage;

    private List<String> dataList;

    private ImagePresenter presenter;

    private PhotoViewDialog dialog;

    @Override
    public int setLayout() {
        return R.layout.fragment_image;
    }

    @Override
    public void initView() {
        recycler_image = (RecyclerView) rootView.findViewById(R.id.recycler_image);
        recycler_image.setLayoutManager(new GridLayoutManager(getActivity(), 2));
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
}
