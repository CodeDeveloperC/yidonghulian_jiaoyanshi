package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCatComment implements Serializable {
    private Integer commentId;

    private Integer orderId;

    private Integer goodsId;

    private Integer memberId;

    private Byte score;

    private Byte isopen;

    private Date creatime;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Byte getIsopen() {
        return isopen;
    }

    public void setIsopen(Byte isopen) {
        this.isopen = isopen;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "GoodsCatComment{" +
                "commentId=" + commentId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", memberId=" + memberId +
                ", score=" + score +
                ", isopen=" + isopen +
                ", creatime=" + creatime +
                ", content='" + content + '\'' +
                '}';
    }
}