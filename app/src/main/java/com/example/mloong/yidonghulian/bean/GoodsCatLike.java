package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCatLike implements Serializable {
    private Integer likeId;

    private Integer goodsId;

    private Integer memberId;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public String toString() {
        return "GoodsCatLike{" +
                "likeId=" + likeId +
                ", goodsId=" + goodsId +
                ", memberId=" + memberId +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}