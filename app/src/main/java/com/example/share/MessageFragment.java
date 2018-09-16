package com.example.share;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.share.adapter.MyAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小飞侠 on 2018/7/28.
 */

public class MessageFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        context = this.getActivity();
        View view = inflater.inflate(R.layout.layout_message_fragment,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        Fresco.initialize(this.getActivity());
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

        initListData();
    }

        /**************************
     * 列表数据
     *****************************/

    MyAdapter adapter;
    List<ListEntity> data;

    private void initListData() {
        data = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        data.add(new ListEntity());

        for(int i=0;i<20;i++){
            ListEntity listEntity=new ListEntity();
            listEntity.name="小飞侠";
            listEntity.date="9月16日12:25";
            listEntity.content="追求随性的路上还不够洒脱。记得所有的好，感谢所遇到的一切";

            listEntity.avatarUrl="http://img2.imgtn.bdimg.com/it/u=2452097355,3155741241&fm=21&gp=0.jpg";
            listEntity.descUrl="http://img4.imgtn.bdimg.com/it/u=2373780812,700019726&fm=21&gp=0.jpg";

            listEntity.layoutType=1;
            data.add(listEntity);
        }
        setAdapter();
    }

    public void setAdapter() {
        if (adapter == null) {
            adapter = new MyAdapter(context, data);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
