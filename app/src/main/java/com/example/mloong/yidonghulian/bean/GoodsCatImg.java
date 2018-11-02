package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCatImg implements Serializable {
    private Integer imgId;

    private Integer goodsId;

    private String thumbnail;

    private String big;

    private String small;

    private String original;

    private Short isdefault;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big == null ? null : big.trim();
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small == null ? null : small.trim();
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original == null ? null : original.trim();
    }

    public Short getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Short isdefault) {
        this.isdefault = isdefault;
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
        return "GoodsCatImg{" +
                "imgId=" + imgId +
                ", goodsId=" + goodsId +
                ", thumbnail='" + thumbnail + '\'' +
                ", big='" + big + '\'' +
                ", small='" + small + '\'' +
                ", original='" + original + '\'' +
                ", isdefault=" + isdefault +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}