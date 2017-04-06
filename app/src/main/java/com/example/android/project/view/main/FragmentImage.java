package com.example.android.project.view.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterImage;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.presenter.ImagePresenter;
import com.example.android.project.view.IImageView;

import java.util.List;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentImage extends BaseFragment implements IImageView {

    private RecyclerView recycler_image;
    private AdapterImage adapterImage;

    private ImagePresenter presenter;

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
        adapterImage = new AdapterImage(list, getActivity());
        recycler_image.setAdapter(adapterImage);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
