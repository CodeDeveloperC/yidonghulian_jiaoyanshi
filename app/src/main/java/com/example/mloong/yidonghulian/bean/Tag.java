package com.example.mloong.yidonghulian.bean;

import java.io.Serializable;
import java.util.Date;

public class Tag implements Serializable {
    private Integer tagId;

    private String name;

    private Byte type;

    private Integer count;

    private Short sort;

    private Byte team;

    private Date creatime;

    private Date modifytime;

    private static final long serialVersionUID = 1L;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Byte getTeam() {
        return team;
    }

    public void setTeam(Byte team) {
        this.team = team;
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
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", count=" + count +
                ", sort=" + sort +
                ", team=" + team +
                ", creatime=" + creatime +
                ", modifytime=" + modifytime +
                '}';
    }
}