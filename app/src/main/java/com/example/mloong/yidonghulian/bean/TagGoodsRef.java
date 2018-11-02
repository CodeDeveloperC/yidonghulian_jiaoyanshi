package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class TagGoodsRef implements Serializable {
    private Integer id;

    private Integer tagId;

    private Integer goodsId;

    private Short sort;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
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
        return "TagGoodsRef{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", goodsId=" + goodsId +
                ", sort=" + sort +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}