package com.example.share;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 小飞侠 on 2018/7/28.
 */

public class FindFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_find_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        AppCompatActivity appCompatActivity= (AppCompatActivity) getActivity();
        Toolbar toolbar= (Toolbar) appCompatActivity.findViewById(R.id.id_toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle("");

        }
        appCompatActivity.setSupportActionBar(toolbar);
        super.onActivityCreated(savedInstanceState);
    }
}
