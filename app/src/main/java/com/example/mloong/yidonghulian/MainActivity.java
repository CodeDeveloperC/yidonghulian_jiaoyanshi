package com.example.mloong.yidonghulian;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.example.mloong.yidonghulian.activity.BaseActivity;
import com.example.mloong.yidonghulian.fragment.NavigationFragment;
import com.example.mloong.yidonghulian.utils.OkHttpUtils;

import java.net.MalformedURLException;

public class MainActivity extends BaseActivity {

    private NavigationFragment mNavigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationFragment = new NavigationFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame, mNavigationFragment).commit();

        try {
            OkHttpUtils.okHttp(this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
