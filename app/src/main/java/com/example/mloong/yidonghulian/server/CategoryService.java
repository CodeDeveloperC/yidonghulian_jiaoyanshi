package com.example.mloong.yidonghulian.server;

import com.example.mloong.yidonghulian.bean.GoodsCat;
import com.example.mloong.yidonghulian.entity.HttpResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryService {
    @GET("goodsCat/queryAllGoodsCatFirst")
    Observable<HttpResult<List<GoodsCat>>> getTopList();

    @GET("goodsCat/queryGoodsCatByParentId")
    Observable<HttpResult<List<GoodsCat>>> getSecondList(@Query("parentId") Integer parentId);
}
