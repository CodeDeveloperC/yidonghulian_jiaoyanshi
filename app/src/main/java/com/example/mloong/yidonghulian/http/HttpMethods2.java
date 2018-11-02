package com.example.mloong.yidonghulian.http;

import android.util.Log;

import com.example.mloong.yidonghulian.common.Share;
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.server.MemberService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpMethods2 {
    protected static String TAG = "HttpMethods2";
    private static HttpMethods2 sHttpMethods;
    private Retrofit mRetrofit;
    protected static MemberService sMemberService;

    public HttpMethods2() {
        if (sHttpMethods == null) {
            OkHttpClient okHttpClient =
                    new OkHttpClient.Builder().connectTimeout(Share.DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Share.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            sMemberService = mRetrofit.create(MemberService.class);
        }
    }

    public static HttpMethods2 getInstance() {
        if (sHttpMethods == null) {
            synchronized (HttpMethods2.class) {
                if (sHttpMethods == null) {
                    sHttpMethods = new HttpMethods2();
                }
            }
        }

        return sHttpMethods;
    }

    /**
     * 对结果进行解析
     * @param <T>
     */
    public static abstract class HttpResultFunc<T> implements Function<HttpResult<T>, T> {

        @Override
        public T apply(HttpResult<T> tHttpResult) throws Exception {
            if (tHttpResult.getStatus() != null) {
                Log.d(TAG, "tHttpResult.getStatus():" + tHttpResult.getStatus());
                if (tHttpResult.getStatus().equals(Share.FAILURE)) {
                    throw new Exception(tHttpResult.getMsg());
                }
            }
            if (tHttpResult.getMsg() != null) {
                Log.d(TAG, tHttpResult.getMsg());
            }
            if (tHttpResult.getData() != null) {
                Log.d(TAG, "tHttpResult.getData():" + tHttpResult.getData());
                return tHttpResult.getData();
            } else {
                return (T) new Object();
            }


        }
    }


    public static <T> void toSubscribe(Observable<T> observable, Observer<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
