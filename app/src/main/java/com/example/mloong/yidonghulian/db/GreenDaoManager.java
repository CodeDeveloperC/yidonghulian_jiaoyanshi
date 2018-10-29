package com.example.mloong.yidonghulian.db;

import com.example.mloong.yidonghulian.MyApplication;
import com.example.mloong.yidonghulian.gen.DaoMaster;
import com.example.mloong.yidonghulian.gen.DaoSession;

public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private static DaoMaster sDaoMaster;
    private static DaoSession sDaoSession;

    public GreenDaoManager() {
        if (mInstance == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), "mydb", null);
            sDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            sDaoSession = sDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getmInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }

        return mInstance;
    }

    public static DaoMaster getDaoMaster() {
        return sDaoMaster;
    }

    public static DaoSession getDaoSession() {
        return sDaoSession;
    }

    public static DaoSession getNewDaoSession() {
        DaoSession daoSession = sDaoMaster.newSession();
        return daoSession;
    }
}
