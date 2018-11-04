package com.example.mloong.yidonghulian.presenter;

import com.example.mloong.yidonghulian.bean.GoodsCat;
import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.http.HttpMethods2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class CategoryPresenter extends HttpMethods2 {

    public static void getTopList(Observer<HttpResult<List<GoodsCat>>> subscriber) {
        Observable<HttpResult<List<GoodsCat>>> observable = sCategoryService.getTopList()
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void getSecondList(Observer<HttpResult<List<GoodsCat>>> subscriber,Integer parentId) {
        Observable<HttpResult<List<GoodsCat>>> observable = sCategoryService.getSecondList(parentId)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }
}
