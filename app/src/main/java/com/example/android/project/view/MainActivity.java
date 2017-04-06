package com.example.android.project.view;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

    //退出时的时间
    private long mExitTime;

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
        drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.menu_index:
                switchContent(0);
                break;
            case R.id.menu_image:
                switchContent(1);
                break;
            case R.id.menu_joke:
                switchContent(2);
                break;
            case R.id.menu_news:
                switchContent(3);
                break;
        }
        return true;
    }

    public void switchContent(int index) {
        setFragment(index);
        navigation_view.getMenu().getItem(index).setChecked(true);
    }

    private void setFragment(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragmentArrayList.get(i));
        fragmentTransaction.commit();
        toolbar.setTitle(indexNames[i]);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
