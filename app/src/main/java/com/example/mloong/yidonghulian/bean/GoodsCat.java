package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCat implements Serializable {
    private Integer catId;

    private String name;

    private Integer parentId;

    private String catPath;

    private Integer goodsCount;

    private Integer sort;

    private Integer typeId;

    private Byte listShow;

    private String image;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCatPath() {
        return catPath;
    }

    public void setCatPath(String catPath) {
        this.catPath = catPath == null ? null : catPath.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Byte getListShow() {
        return listShow;
    }

    public void setListShow(Byte listShow) {
        this.listShow = listShow;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
        return "GoodsCat{" +
                "catId=" + catId +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", catPath='" + catPath + '\'' +
                ", goodsCount=" + goodsCount +
                ", sort=" + sort +
                ", typeId=" + typeId +
                ", listShow=" + listShow +
                ", image='" + image + '\'' +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}