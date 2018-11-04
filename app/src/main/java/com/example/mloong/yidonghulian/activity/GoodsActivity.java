package com.example.mloong.yidonghulian.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.mloong.yidonghulian.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.common_title)
    RelativeLayout commonTitle;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.txt_1)
    TextView txt1;
    @BindView(R.id.favorite_layout)
    LinearLayout favoriteLayout;
    @BindView(R.id.txt_2)
    TextView txt2;
    @BindView(R.id.cat_layout)
    LinearLayout catLayout;
    @BindView(R.id.add_to_cart)
    TextView addToCart;
    @BindView(R.id.content)
    RelativeLayout content;
    @BindView(R.id.image_pager)
    ViewPager imagePager;
    @BindView(R.id.image_pager_index)
    TextView imagePagerIndex;
    @BindView(R.id.top_layout)
    RelativeLayout topLayout;
    @BindView(R.id.goods_name)
    TextView goodsName;
    @BindView(R.id.goods_name_layout)
    LinearLayout goodsNameLayout;
    @BindView(R.id.goods_price)
    TextView goodsPrice;
    @BindView(R.id.goods_brand)
    TextView goodsBrand;
    @BindView(R.id.goods_store)
    TextView goodsStore;
    @BindView(R.id.goods_view_count)
    TextView goodsViewCount;
    @BindView(R.id.goods_count)
    TextView goodsCount;
    @BindView(R.id.choose_count)
    ImageView chooseCount;
    @BindView(R.id.goods_scrollview)
    ScrollView goodsScrollview;
    @BindView(R.id.right_frame)
    FrameLayout rightFrame;
    @BindView(R.id.goods_drawerlayout)
    DrawerLayout goodsDrawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);
    }

}
