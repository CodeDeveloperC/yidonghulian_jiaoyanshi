package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderGoods implements Serializable {
    private Integer id;

    private String orderId;

    private Integer goodsId;

    private Integer goodsNum;

    private BigDecimal price;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", goodsId=" + goodsId +
                ", goodsNum=" + goodsNum +
                ", price=" + price +
                '}';
    }
}