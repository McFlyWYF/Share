package io.github.leibnik.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Droidroid on 2016/5/10.
 */
public class DemoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_fragment, container, false);
        int type = getArguments().getInt("type", 0);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(type == 0 ? "1st Fragment" : type == 1 ? "2nd Fragment" : type == 2 ? "3rd Fragment" : "4th Fragment");
        return view;
    }
}
