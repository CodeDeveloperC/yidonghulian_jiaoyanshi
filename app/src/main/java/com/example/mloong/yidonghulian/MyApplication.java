package com.example.mloong.yidonghulian;

import android.app.Application;
import android.content.Context;

import com.example.mloong.yidonghulian.common.ImageLoaderManager;
import com.example.mloong.yidonghulian.db.GreenDaoManager;
import com.example.mloong.yidonghulian.http.HttpMethods;

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //greenDao全局配置
        GreenDaoManager.getmInstance();

        //全局配置fresco
        ImageLoaderManager.getmInstance();

        //全局配置Retrofit
        HttpMethods.getInstance();
    }

    public static Context getContext() {
        return mContext;
    }


}
