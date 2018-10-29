package com.example.mloong.yidonghulian.server;

import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.entity.MemberEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MemberService {
    @FormUrlEncoded
    @POST("member/register")
    Observable<HttpResult<MemberEntity>> register(@Field("uname") String uname, @Field("password") String password, @Field("email") String email);

    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(@Field("uname") String uname, @Field("password") String password);
}
