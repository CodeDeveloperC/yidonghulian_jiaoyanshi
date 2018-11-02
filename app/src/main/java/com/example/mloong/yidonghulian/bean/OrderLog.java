package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class OrderLog implements Serializable {
    private Integer logId;

    private Integer orderId;

    private String orderStatus;

    private Date statusTime;

    private static final long serialVersionUID = 1L;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Date statusTime) {
        this.statusTime = statusTime;
    }

    @Override
    public String toString() {
        return "OrderLog{" +
                "logId=" + logId +
                ", orderId=" + orderId +
                ", orderStatus='" + orderStatus + '\'' +
                ", statusTime=" + statusTime +
                '}';
    }
}