package com.example.mloong.yidonghulian.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {

    public static void okHttp(final Context context) throws MalformedURLException {
        OkHttpClient okHttpClient = new OkHttpClient();
        URL url = new URL("https://www.baidu1.com");
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);

        final TextView textView = new TextView(context);
        call.enqueue(new Callback() {

            private Activity mContextActivity = (Activity) context;

            @Override
            public void onFailure(Call call, final IOException e) {
                mContextActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                mContextActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContextActivity, "response.body():" + response.body(), Toast.LENGTH_SHORT).show();
                        textView.setText(response.body().toString());
                    }
                });
            }
        });
    }

    public static void postOkHttp(final Activity activity, final TextView textView) throws MalformedURLException {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody body = new FormBody.Builder().add("id", "id")
                .add("name", "name").build();

        //http://必须要加，而且不能是https
        URL url = new URL("http://192.168.1.119:8888/post");

        Request request = new Request.Builder().url(url).post(body).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // activity.runOnUiThread(() -> textView.setText(e.getMessage()),Toast.makeText(activity, "fail", Toast.LENGTH_SHORT).show());
                activity.runOnUiThread(() -> {
                    textView.setText(e.getMessage());
                    Toast.makeText(activity, "fail", Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                activity.runOnUiThread(() -> {
                    textView.setText(response.body().toString());
                    Toast.makeText(activity, "success", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}
