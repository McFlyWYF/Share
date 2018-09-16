package com.example.share;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 小飞侠 on 2018/7/28.
 */

public class MyFragment extends Fragment {

    private CardView cardView1,cardView2,cardView3,cardView4,cardView5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_my_fragment,container,false);
        cardView1 = view.findViewById(R.id.cardView1);
        cardView2 = view.findViewById(R.id.cardView2);
        cardView3 = view.findViewById(R.id.cardView3);
        cardView4 = view.findViewById(R.id.cardView4);
        cardView5 = view.findViewById(R.id.cardView5);
        init();
        return view;
    }

    private void init(){

        cardView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //手指按下
                    case MotionEvent.ACTION_DOWN:
                        cardView1.setCardElevation(0);
                        break;

                    //手指松开
                    case MotionEvent.ACTION_UP:
                        cardView1.setCardElevation(20);
                        break;
                }
                return true;
            }
        });

        cardView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //手指按下
                    case MotionEvent.ACTION_DOWN:
                        cardView2.setCardElevation(0);
                        break;

                    //手指松开
                    case MotionEvent.ACTION_UP:
                        cardView2.setCardElevation(20);
                        break;
                }
                return true;
            }
        });

        cardView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //手指按下
                    case MotionEvent.ACTION_DOWN:
                        cardView3.setCardElevation(0);
                        break;

                    //手指松开
                    case MotionEvent.ACTION_UP:
                        cardView3.setCardElevation(20);
                        break;
                }
                return true;
            }
        });

        cardView4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //手指按下
                    case MotionEvent.ACTION_DOWN:
                        cardView4.setCardElevation(0);
                        break;

                    //手指松开
                    case MotionEvent.ACTION_UP:
                        cardView4.setCardElevation(20);
                        break;
                }
                return true;
            }
        });

        cardView5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    //手指按下
                    case MotionEvent.ACTION_DOWN:
                        cardView5.setCardElevation(0);
                        break;

                    //手指松开
                    case MotionEvent.ACTION_UP:
                        cardView5.setCardElevation(20);
                        break;
                }
                return true;
            }
        });
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
