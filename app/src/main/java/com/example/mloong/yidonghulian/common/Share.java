package com.example.mloong.yidonghulian.common;

import android.app.Activity;
import android.content.SharedPreferences;

public class Share {
    public final static String BASE_URL = "http://192.168.1.119:8080";
    public final static String APP_IMAGE = "app_image";
    public final static String AD_URL = "/test/picture";
    public final static String AD_URL_DIED = "https://img.alicdn.com/tfs/TB1ZkoLukCWBuNjy0FaXXXUlXXa-966-644.jpg_960x960q100.jpg_.webp";
    public final static Integer DEFAULT_TIMEOUT = 5;
    public final static Integer MAX_DISK_CACHE_SIZE = 20971520;
    public final static Integer AD_TIME_SECONDS = 0*1000;
    //未跳转
    public static Integer flag = 0;

    //result成功字段
    public static final Integer SUCCESS = 0;
    //result失败字段
    public static final Integer FAILURE = 1;

    //男性
    public static final Short MALE = 0;
    //    女性
    public static final Short FEMALE = 1;

    //商品分类是否可用
    public static final Byte ENABLE = 0;
    public static final Byte DISABLE = 1;

    //默认分页一页显示数量
    public static final Integer PAGENUMBER = 10;
    //默认没有排序
    public static final Integer NO_SORT = 0;

    //退出登录时，清楚本地用户信息
    public static void logout(Activity activity) {
        SharedPreferences.Editor localEditor = activity.getSharedPreferences("user", 0).edit();
        localEditor.remove("member_id");
        localEditor.remove("uname");
        localEditor.remove("email");
        localEditor.remove("image");
        localEditor.apply();
    }

    /**
     * 列表页面右侧列表的列数
     */
    public static int SPAN_COUNT = 3;

}
