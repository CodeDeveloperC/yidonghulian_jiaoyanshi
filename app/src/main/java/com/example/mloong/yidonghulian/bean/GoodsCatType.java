package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class GoodsCatType implements Serializable {
    private Integer typeId;

    private String name;

    private Byte disabled;

    private Byte isPhysical;

    private Date creatime;

    private Date modifytime;

    private String params;

    private static final long serialVersionUID = 1L;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getDisabled() {
        return disabled;
    }

    public void setDisabled(Byte disabled) {
        this.disabled = disabled;
    }

    public Byte getIsPhysical() {
        return isPhysical;
    }

    public void setIsPhysical(Byte isPhysical) {
        this.isPhysical = isPhysical;
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }

    @Override
    public String toString() {
        return "GoodsCatType{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                ", disabled=" + disabled +
                ", isPhysical=" + isPhysical +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                ", params='" + params + '\'' +
                '}';
    }
}