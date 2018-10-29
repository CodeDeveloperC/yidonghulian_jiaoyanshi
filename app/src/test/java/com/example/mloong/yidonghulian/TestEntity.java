package com.example.mloong.yidonghulian;

import com.example.mloong.yidonghulian.entity.HttpResult;
import com.example.mloong.yidonghulian.entity.MemberEntity;

import org.junit.Test;

public class TestEntity {
    public static void main(String[] args) {
        System.out.println("Hello");
    }

    @Test
    public void testLomBok() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail("email");
        memberEntity.setImage("image");
        System.out.println(memberEntity);
    }

    @Test
    public void testHttp() {
        HttpResult<MemberEntity> memberEntityHttpResult = new HttpResult<>();
        memberEntityHttpResult.setStatus(0);
        memberEntityHttpResult.getStatus();
    }
}
