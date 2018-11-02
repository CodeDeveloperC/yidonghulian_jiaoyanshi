package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderPaytype implements Serializable {
    private Integer paytypeId;

    private String name;

    private String config;

    private String description;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getPaytypeId() {
        return paytypeId;
    }

    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config == null ? null : config.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        return "OrderPaytype{" +
                "paytypeId=" + paytypeId +
                ", name='" + name + '\'' +
                ", config='" + config + '\'' +
                ", description='" + description + '\'' +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}