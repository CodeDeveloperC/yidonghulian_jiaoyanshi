package com.example.mloong.yidonghulian.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberEntity implements Serializable{
    private Integer memberId;
    private String uname;
    private String password;
    private String email;
    private Integer sex;
    private String mobile;
    private Object regtime;
    private Object lastLogin;
    private String image;
    private Object memberAddress;

    @Override
    public String toString() {
        return "MemberEntity{" +
                "memberId=" + memberId +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime=" + regtime +
                ", lastLogin=" + lastLogin +
                ", image='" + image + '\'' +
                ", memberAddress=" + memberAddress +
                '}';
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getRegtime() {
        return regtime;
    }

    public void setRegtime(Object regtime) {
        this.regtime = regtime;
    }

    public Object getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(Object memberAddress) {
        this.memberAddress = memberAddress;
    }
}
