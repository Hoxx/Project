package com.example.android.project.view.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterJoke;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.bean.Joke;
import com.example.android.project.presenter.JokePresenter;
import com.example.android.project.view.IJokeView;

import java.util.List;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentJoke extends BaseFragment implements IJokeView {

    private RecyclerView recyclerView_joke;
    private JokePresenter jokePresenter;

    private AdapterJoke adapterJoke;

    @Override
    public int setLayout() {
        return R.layout.fragment_joke;
    }

    @Override
    public void initView() {
        recyclerView_joke = (RecyclerView) rootView.findViewById(R.id.recycler_joke);
        recyclerView_joke.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void initDate() {
        jokePresenter = new JokePresenter(this);
        jokePresenter.getData();
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
    public void setData(List<Joke> list) {
        adapterJoke = new AdapterJoke(list, getActivity());
        recyclerView_joke.setAdapter(adapterJoke);
    }
}
