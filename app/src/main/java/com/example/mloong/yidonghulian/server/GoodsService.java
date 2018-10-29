package com.example.mloong.yidonghulian.server;

import com.example.mloong.yidonghulian.entity.GoodsEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoodsService {
    @GET("goods")
    Call<List<GoodsEntity>> getGoodsEntity(@Query("page") Integer page,@Query("count")  Integer count);
}
