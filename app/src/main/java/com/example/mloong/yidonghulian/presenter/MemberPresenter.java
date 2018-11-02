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
        toSubscribe(observable, subscriber);
    }

    public static void registerAdd(Observer<MemberEntity> subscriber, MemberEntity memberEntity) {
        Observable<MemberEntity> observable = sMemberService.registerAdd(memberEntity)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 更新时，服务器不会传对象信息，总是为空，所以泛型为Object
     *
     * @param subscriber
     * @param email
     */
    public static void findPwd(Observer<MemberEntity> subscriber, String email) {
        Observable<MemberEntity> observable = sMemberService.findPwd(email)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void updateById(Observer<MemberEntity> subscriber, MemberEntity memberEntity) {
        Observable<MemberEntity> observable = sMemberService.updateById(memberEntity)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void updateById2(Observer<MemberEntity> subscriber, MemberEntity memberEntity) {
        Observable<MemberEntity> observable = sMemberService.updateById(memberEntity)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void findEmailPwd(Observer<MemberEntity> subscriber, String email,String password) {
        Observable<MemberEntity> observable = sMemberService.findEmailPwd(email, password)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }

    public static void login(Observer<MemberEntity> subscriber, String uname, String password) {
        Observable<MemberEntity> observable = sMemberService.login(uname, password)
                .map(new HttpResultFunc<>());
        toSubscribe(observable, subscriber);
    }
}
