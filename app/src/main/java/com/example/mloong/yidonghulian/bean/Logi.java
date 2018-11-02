package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Logi implements Serializable {
    private Integer logiId;

    private Integer shipId;

    private String sn;

    private BigDecimal carriage;

    private String sender;

    private Short status;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getLogiId() {
        return logiId;
    }

    public void setLogiId(Integer logiId) {
        this.logiId = logiId;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
        return "Logi{" +
                "logiId=" + logiId +
                ", shipId=" + shipId +
                ", sn='" + sn + '\'' +
                ", carriage=" + carriage +
                ", sender='" + sender + '\'' +
                ", status=" + status +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}