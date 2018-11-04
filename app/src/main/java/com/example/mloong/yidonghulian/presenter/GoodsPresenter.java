package com.example.mloong.yidonghulian.presenter;

import com.example.mloong.yidonghulian.bean.Goods;
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.http.HttpMethods2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class GoodsPresenter extends HttpMethods2 {

    public static void list(Observer<HttpResult<List<Goods>>> subscriber,Integer catId) {
        Observable<HttpResult<List<Goods>>> observable = sGoodsService.list(catId)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void listByKeywords(Observer<HttpResult<List<Goods>>> subscriber,String name) {
        Observable<HttpResult<List<Goods>>> observable = sGoodsService.listByKeywords(name)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

}
