package com.example.android.project.view;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.project.R;
import com.example.android.project.base.BaseActivity;
import com.example.android.project.base.BaseFragment;
import com.example.android.project.view.main.FragmentImage;
import com.example.android.project.view.main.FragmentIndex;
import com.example.android.project.view.main.FragmentJoke;
import com.example.android.project.view.main.FragmentNews;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigation_view;
    private ActionBarDrawerToggle toggle;


    private ArrayList<BaseFragment> fragmentArrayList;
    private FragmentIndex fragmentIndex = new FragmentIndex();
    private FragmentImage fragmentImage = new FragmentImage();
    private FragmentJoke fragmentJoke = new FragmentJoke();
    private FragmentNews fragmentNews = new FragmentNews();

    private String[] indexNames;

    @Override
    public int setLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    @Override
    public void initData() {
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigation_view.setNavigationItemSelectedListener(this);
        setMenuName();
        addFragment();
        setFragment(0);//默认显示首页
    }

    private void setMenuName() {
        indexNames = getResources().getStringArray(R.array.index_name);
        Menu menu = navigation_view.getMenu();
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menu.getItem(i);
            item.setTitle(indexNames[i]);
        }
    }

    private void addFragment() {
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(fragmentIndex);
        fragmentArrayList.add(fragmentImage);
        fragmentArrayList.add(fragmentNews);
        fragmentArrayList.add(fragmentJoke);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        drawerLayout.closeDrawers();
        switchContent(item.getItemId());
        return true;
    }

    private void switchContent(int id) {
        switch (id) {
            case R.id.menu_index:
                setFragment(0);
                break;
            case R.id.menu_image:
                setFragment(1);
                break;
            case R.id.menu_joke:
                setFragment(2);
                break;
            case R.id.menu_news:
                setFragment(3);
                break;
        }
    }

    private void setFragment(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragmentArrayList.get(i));
        fragmentTransaction.commit();
        toolbar.setTitle(indexNames[i]);
    }
}
