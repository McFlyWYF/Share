package io.github.leibnik.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.github.leibnik.wechatradiobar.WeChatRadioGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WeChatRadioGroup gradualRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        gradualRadioGroup = (WeChatRadioGroup) findViewById(R.id.radiogroup);
        List<DemoFragment> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            DemoFragment fragment = new DemoFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type",i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        viewPager.setAdapter(new DemoPagerAdapter(getSupportFragmentManager(), list));
        gradualRadioGroup.setViewPager(viewPager);
    }

    class DemoPagerAdapter extends FragmentPagerAdapter {
        List<DemoFragment> mData;

        public DemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public DemoPagerAdapter(FragmentManager fm, List<DemoFragment> data) {
            super(fm);
            mData = data;
        }

        @Override
        public Fragment getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}
