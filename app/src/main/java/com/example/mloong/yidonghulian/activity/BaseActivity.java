package com.example.mloong.yidonghulian.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.mloong.yidonghulian.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }

    /**
     * 购物车商品数量
     */
    private static int cartCount = 0;

    /**
     * 是否登录了
     *
     * @return
     */
    public boolean isLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
//        String username = sharedPreferences.getString("uname", "");
        return !TextUtils.isEmpty(sharedPreferences.getString("uname", ""));
    }

//    /**
//     * 显示商品
//     * @param goodsid
//     */
//    public void showGoods(int goodsid){
//        Intent intent = new Intent(this, GoodsActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//        intent.putExtra("goods_id", goodsid);
//        startActivity(intent);
//    }


    public int getCartCount() {
        return cartCount;
    }

    public void setCartCount(int cartCount) {
        this.cartCount = cartCount;
    }

}
