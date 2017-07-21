package com.idigital.administrador;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.idigital.administrador.fragment.AttendanceFragment;
import com.idigital.administrador.fragment.FilterFragment;
import com.idigital.administrador.fragment.FragmentTab;

public class MainActivity extends AppCompatActivity {

    FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        Bundle bundle = new Bundle();
        bundle.putString("name", "Tab 1");
        mTabHost.addTab(
                mTabHost.newTabSpec("tab1").setIndicator("Tab 1", null),
                AttendanceFragment.class, bundle);
        bundle = new Bundle();
        bundle.putString("name", "Tab 2");
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator("Tab 2", null),
                FragmentTab.class, bundle);
        bundle = new Bundle();
        bundle.putString("name", "Tab 3");
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator("Tab 3", null),
                FilterFragment.class, bundle);
    }
}
