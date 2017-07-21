package com.idigital.administrador.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idigital.administrador.R;

public class FragmentTab extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    static final String TAG = FragmentTab.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    String name;
    SwipeRefreshLayout swipeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView tv = (TextView) v.findViewById(R.id.text);
        tv.setText(this.getTag() + " Content");
        swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe);
        String name = getArguments().getString("name");
        swipeLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright),
                ContextCompat.getColor(getContext(), android.R.color.holo_green_light));
        swipeLayout.setOnRefreshListener(this);
        Log.i(TAG, name);

        tv.setText(name);

        return v;
    }

    @Override
    public void onDestroyView() {
        swipeLayout.removeAllViews();
        swipeLayout = null;
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
