package com.example.mloong.yidonghulian.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mloong.yidonghulian.MainActivity;
import com.example.mloong.yidonghulian.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    @BindView(R.id.splash_logo)
    ImageView splashLogo;
    @BindView(R.id.splash_loading_item)
    ImageView splashLoadingItem;
    @BindView(R.id.relativeLayout1)
    RelativeLayout relativeLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_loading);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        splashLoadingItem.setAnimation(animation);
    }
}
