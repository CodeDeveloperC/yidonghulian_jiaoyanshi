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


public class HttpMethods {
    protected static String TAG = "HttpMethods";
    private static HttpMethods sHttpMethods;
    private Retrofit mRetrofit;
    protected static MemberService sMemberService;

    public HttpMethods() {
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

    public static HttpMethods getInstance() {
        if (sHttpMethods == null) {
            synchronized (HttpMethods.class) {
                if (sHttpMethods == null) {
                    sHttpMethods = new HttpMethods();
                }
            }
        }

        return sHttpMethods;
    }

    public static class HttpResultFunc<T> implements Function<HttpResult<T>, T> {

        @Override
        public T apply(HttpResult<T> tHttpResult) throws Exception {
            if (tHttpResult.getStatus() != null) {
                Log.d(TAG, "tHttpResult.getStatus():" + tHttpResult.getStatus());
                if (tHttpResult.getStatus().equals(1)) {
                    throw new Exception(tHttpResult.getMsg());
                }
            }
            if (tHttpResult.getMsg() != null) {
                Log.d(TAG, tHttpResult.getMsg());
            }
            if (tHttpResult.getData() != null) {
                Log.d(TAG, "tHttpResult.getData():" + tHttpResult.getData());

            }

            return tHttpResult.getData();
        }
    }

//    public static <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
//        observable.subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((Observer<? super T>) subscriber);
//    }
//
//    public static <T> void toSubscribe(Observable<T> observable, Consumer<T> subscriber) {
//        observable.subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//    }

    public static <T> void toSubscribe(Observable<T> observable, Observer<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
