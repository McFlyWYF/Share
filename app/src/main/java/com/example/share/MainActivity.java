package com.example.share;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirstFragment firstFragment;
    private ShareFragment shareFragment;
    private ReserveFragment reserveFragment;
    private MyFragment myFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private FrameLayout frameLayout;

    private ImageView weixin;
    private ImageView list;
    private ImageView find;
    private ImageView my;

    private Fragment[] fragments;


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ib_weixin:
                firstFragment = new FirstFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container,firstFragment);
                ft.commit();
                break;

            case R.id.ib_contact_list:
                shareFragment = new ShareFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container,shareFragment);
                ft.commit();
                break;

            case R.id.ib_find:
                reserveFragment = new ReserveFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container,reserveFragment);
                ft.commit();
                break;

            case R.id.ib_profile:
                myFragment = new MyFragment();
                ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container,myFragment);
                ft.commit();
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weixin = findViewById(R.id.ib_weixin);
        list = findViewById(R.id.ib_contact_list);
        find = findViewById(R.id.ib_find);
        my = findViewById(R.id.ib_profile);

        weixin.setOnClickListener(this);
        list.setOnClickListener(this);
        find.setOnClickListener(this);
        my.setOnClickListener(this);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
        fm = getSupportFragmentManager();

        initFragments();

    }

    private void initFragments() {
        firstFragment = new FirstFragment();
        shareFragment = new ShareFragment();
        reserveFragment = new ReserveFragment();
        myFragment = new MyFragment();
        fragments = new Fragment[]{firstFragment, shareFragment, reserveFragment,myFragment};
        Fragment fragment = new Fragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container,firstFragment)
                .show(fragment)
                .commit();
    }
}

