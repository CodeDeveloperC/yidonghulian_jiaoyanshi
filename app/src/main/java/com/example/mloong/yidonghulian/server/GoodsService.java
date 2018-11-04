package com.example.mloong.yidonghulian.server;

import com.example.mloong.yidonghulian.bean.Goods;
import com.example.mloong.yidonghulian.entity.GoodsEntity;
import com.example.mloong.yidonghulian.entity.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodsService {
    @GET("goods")
    Call<List<GoodsEntity>> getGoodsEntity(@Query("page") Integer page,@Query("count")  Integer count);

    @GET("goods/queryAllGoodsByCatId")
    Observable<HttpResult<List<Goods>>> list(@Query("catId") Integer catId);

    @GET("goods/queryAllGoodsLikeName")
    Observable<HttpResult<List<Goods>>> listByKeywords(@Query("name") String name);
}
