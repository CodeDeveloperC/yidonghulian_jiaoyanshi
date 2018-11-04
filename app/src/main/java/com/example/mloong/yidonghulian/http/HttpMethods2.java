package com.example.mloong.yidonghulian.http;

import android.util.Log;

import com.example.mloong.yidonghulian.common.Share;
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.server.CategoryService;
import com.example.mloong.yidonghulian.server.MemberService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.reflect.Type;
import java.util.Date;
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
    protected static CategoryService sCategoryService;

    public HttpMethods2() {
        if (sHttpMethods == null) {

            //Retrofit 自定义Gson对象解决日期格式问题
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsJsonPrimitive().getAsLong());
                }
            });
            Gson gson = builder.create();

            OkHttpClient okHttpClient =
                    new OkHttpClient.Builder().connectTimeout(Share.DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Share.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            sMemberService = mRetrofit.create(MemberService.class);

            //初始化
            sCategoryService = mRetrofit.create(CategoryService.class);
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
    public static class HttpResultFunc<T> implements Function<HttpResult<T>, HttpResult<T>> {

        @Override
        public HttpResult<T> apply(HttpResult<T> tHttpResult) throws Exception {
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
            }
            return tHttpResult;
        }
    }


    public static <T> void toSubscribe(Observable<T> observable, Observer<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
