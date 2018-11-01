package com.example.mloong.yidonghulian.activity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mloong.yidonghulian.MainActivity;
import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.common.Share;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdActivity extends BaseActivity {


    @BindView(R.id.content)
    LinearLayout content;
    @BindView(R.id.skip_button)
    Button skipButton;
    @BindView(R.id.ad_image)
    SimpleDraweeView adImage;

    //未跳转
    private Integer flag = 0;

    @OnClick(R.id.skip_button)
    public void onViewClicked() {
        flag ++;
        skip();
    }

    private static class MyHandler extends Handler {
        private final WeakReference<AdActivity> mActivity;

        public MyHandler(AdActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            AdActivity activity = mActivity.get();
            if (activity != null) {
                if (msg.what == -1) {
//                    skip();
                    activity.skip();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);

        loadAd(Share.AD_URL_DIED);
    }

    private void initPicture(String uri) {
        //写一个监听器 监听图片加载
        ControllerListener listener = new BaseControllerListener() {

            /**
             * 当图片加载成功时会执行的方法
             * @param id
             * @param imageInfo
             * @param animatable
             */
            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                timer();
            }


            /**
             * 图片加载失败时调用的方法
             * @param id
             * @param throwable
             */
            @Override
            public void onFailure(String id, Throwable throwable) {
                super.onFailure(id, throwable);
                flag++;
                skip();
            }


            /**
             *  如果图片使用渐进式，这个方法将会被回调
             * @param id
             * @param throwable
             */
            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {
                super.onIntermediateImageFailed(id, throwable);
                timer();
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .setControllerListener(listener)
                .build();

        adImage.setController(controller);
    }

    private void loadAd(String url) {
        initPicture(url);
    }

    private void skip() {
        if (flag == 1) {
            startActivity(new Intent(AdActivity.this, MainActivity.class));
            finish();
        }
    }

    private void timer() {
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == -1) {
                    flag ++;
                    skip();
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(Share.AD_TIME_SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
    }
}
