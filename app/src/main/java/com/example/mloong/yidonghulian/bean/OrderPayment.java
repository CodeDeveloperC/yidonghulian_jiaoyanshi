package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderPayment implements Serializable {
    private Integer paymentId;

    private String sn;

    private Integer paytypeId;

    private BigDecimal amount;

    private Short status;

    private Date paytime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getPaytypeId() {
        return paytypeId;
    }

    public void setPaytypeId(Integer paytypeId) {
        this.paytypeId = paytypeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "OrderPayment{" +
                "paymentId=" + paymentId +
                ", sn='" + sn + '\'' +
                ", paytypeId=" + paytypeId +
                ", amount=" + amount +
                ", status=" + status +
                ", paytime=" + paytime +
                ", remark='" + remark + '\'' +
                '}';
    }
}