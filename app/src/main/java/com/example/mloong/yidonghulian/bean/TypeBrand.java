package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class TypeBrand implements Serializable {
    private Integer id;

    private Integer typeId;

    private Integer brandId;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
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
        return "TypeBrand{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", brandId=" + brandId +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}