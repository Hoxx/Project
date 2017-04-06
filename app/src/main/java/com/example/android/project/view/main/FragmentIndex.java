package com.example.android.project.view.main;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.android.project.R;
import com.example.android.project.adapter.AdapterIndex;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Android on 2017/4/5.
 */

public class FragmentIndex extends BaseFragment implements AdapterIndex.onItemClickListener {

    RecyclerView recyclerView_index;

    ArrayList<HashMap<String, Object>> list;

    private AdapterIndex adapter;

    @Override
    public int setLayout() {
        return R.layout.fragmen_index;
    }

    @Override
    public void initView() {
        recyclerView_index = (RecyclerView) rootView.findViewById(R.id.recycler_index);
        recyclerView_index.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void initDate() {
        initIndexData();
    }

    private void initIndexData() {
        list = new ArrayList<>();
        String[] indexNames = getResources().getStringArray(R.array.index_name);
        for (int i = 0; i < indexNames.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("NAME", indexNames[i]);
            map.put("ICON", R.mipmap.timg);
            list.add(map);
        }
        adapter = new AdapterIndex(getActivity(), list);
        recyclerView_index.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        ((MainActivity) getActivity()).switchContent(position);
//        Log.e("TAG", "点击位置:" + position);
    }
}
