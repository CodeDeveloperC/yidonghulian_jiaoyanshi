package com.example.mloong.yidonghulian.presenter;

import com.example.mloong.yidonghulian.entity.MemberEntity;
import com.example.mloong.yidonghulian.http.HttpMethods;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class MemberPresenter extends HttpMethods {
//    public static void register(Subscriber<MemberEntity> subscriber, String uname, String password, String email) {
//        Observable<MemberEntity> observable = sMemberService.register(uname, password, email)
//                .map(new HttpResultFunc<>());
//        toSubscribe(observable,subscriber);
//    }
//
//    public static void register(Consumer<MemberEntity> subscriber, String uname, String password, String email) {
//        Observable<MemberEntity> observable = sMemberService.register(uname, password, email)
//                .map(new HttpResultFunc<>());
//        toSubscribe(observable,subscriber);
//    }

    public static void register(Observer<MemberEntity> subscriber, String uname, String password, String email) {
        Observable<MemberEntity> observable = sMemberService.register(uname, password, email)
                .map(new HttpResultFunc<>());
        toSubscribe(observable,subscriber);
    }

    public static void login(Observer<MemberEntity> subscriber, String uname, String password) {
        Observable<MemberEntity> observable = sMemberService.login(uname, password)
                .map(new HttpResultFunc<>());
        toSubscribe(observable,subscriber);
    }
}
