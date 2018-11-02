package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCatStore implements Serializable {
    private Integer storeId;

    private Integer goodsId;

    private Integer store;

    private Integer enableStore;

    private Byte operateType;

    private Date intime;

    private Date outime;

    private static final long serialVersionUID = 1L;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getEnableStore() {
        return enableStore;
    }

    public void setEnableStore(Integer enableStore) {
        this.enableStore = enableStore;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOutime() {
        return outime;
    }

    public void setOutime(Date outime) {
        this.outime = outime;
    }

    @Override
    public String toString() {
        return "GoodsCatStore{" +
                "storeId=" + storeId +
                ", goodsId=" + goodsId +
                ", store=" + store +
                ", enableStore=" + enableStore +
                ", operateType=" + operateType +
                ", intime=" + intime +
                ", outime=" + outime +
                '}';
    }
}