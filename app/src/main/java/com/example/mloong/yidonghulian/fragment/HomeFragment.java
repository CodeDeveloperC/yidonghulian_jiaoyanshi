package com.example.mloong.yidonghulian.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mloong.yidonghulian.MainActivity;
import com.example.mloong.yidonghulian.R;
import com.example.mloong.yidonghulian.utils.NetworkUtils;
import com.example.mloong.yidonghulian.view.MyWebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.home_search)
    TextView homeSearch;
    @BindView(R.id.home_title_search)
    RelativeLayout homeTitleSearch;
    @BindView(R.id.webView)
    MyWebView webView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    Unbinder unbinder;
    private MainActivity mainActivity;
    private final int SEARCH_ACTIVITY = 1;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        mainActivity = (MainActivity) getActivity();

        initMyWebView(view);
        initSwipeRefreshLayout();

        return view;
    }


    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (NetworkUtils.isNetworkAvailable(mainActivity)) {//有网络才允许重新刷新
                    webView.reload();
                } else {
                    swipeRefreshLayout.setRefreshing(false);//无网络
                    Toast.makeText(mainActivity, "网络不可用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEARCH_ACTIVITY) {
            /*if (resultCode == Activity.RESULT_OK) {
                String keyword = data.getStringExtra("keyword");
                Intent intent = new Intent(this.getActivity(), GoodsListActivity.class);
                intent.putExtra("keyword", keyword);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }*/
        }
    }

    private class JWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
            paramWebView.loadUrl(paramString);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            view.getSettings().setDefaultTextEncodingName("UTF-8");
            super.onReceivedError(view, request, error);
            view.loadDataWithBaseURL("",
                    "<div style='padding-top:200px;text-align:center;color:#666;" +
                            "'>未打开无线网络</div>",
                    "text/html",
                    "UTF-8", "");
        }
    }


    @SuppressLint("JavascriptInterface")
    private void initMyWebView(View view) {
        webView.setWebViewClient(new JWebViewClient());
        webView.addJavascriptInterface(this, "app");
        webView.setVerticalScrollBarEnabled(false);//设置无垂直方向的scrollbar
        webView.setHorizontalScrollBarEnabled(false);//设置无水平方向的scrollbar

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true); // 启用JS脚本
        settings.setSupportZoom(false); // 支持缩放
        settings.setBuiltInZoomControls(false); // 启用内置缩放装置

        //对webview是否处于顶部进行监听，解决webview往下拉后无法往上拉的冲突（和SwipeRefreshLayout冲突）
        webView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll() {
            @Override
            public void onTop() {
                swipeRefreshLayout.setEnabled(true);
            }

            @Override
            public void notOnTop() {
                swipeRefreshLayout.setEnabled(false);
            }
        });
        // 点击后退按钮,让WebView后退
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                        webView.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            // 当点击链接时,希望覆盖而不是打开浏览器窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.e(TAG, "onReceivedError");
                //用javascript隐藏系统定义的404页面信息
                webView.loadUrl("file:///android_asset/error.html");
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                swipeRefreshLayout.setRefreshing(true);
                Log.e(TAG, "onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                swipeRefreshLayout.setRefreshing(false);
                Log.e(TAG, "onPageFinished");
            }
        });
        //加载Url
        webView.loadUrl("http://www.jd.com/");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
