package com.example.mloong.yidonghulian.server;

import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.entity.MemberEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MemberService {
    @FormUrlEncoded
    @POST("member/register")
    Observable<HttpResult<MemberEntity>> register(@Field("uname") String uname, @Field("password") String password, @Field("email") String email);

    @POST("member/registerAdd")
    Observable<HttpResult<MemberEntity>> registerAdd(@Body MemberEntity memberEntity);


    @FormUrlEncoded
    @POST("member/queryByEmail")
    Observable<HttpResult<MemberEntity>> findPwd(@Field("email") String email);

    @GET("member/queryByEmailAndPwd")
    Observable<HttpResult<MemberEntity>> findEmailPwd(@Query("email") String email, @Query("password") String password);

    @POST("member/updateById")
    Observable<HttpResult<MemberEntity>> updateById(@Body MemberEntity memberEntity);

    @FormUrlEncoded
    @POST("member/login")
    Observable<HttpResult<MemberEntity>> login(@Field("uname") String uname, @Field("password") String password);
}
