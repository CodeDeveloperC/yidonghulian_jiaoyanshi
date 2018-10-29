package com.example.mloong.yidonghulian.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

import lombok.Data;

@Entity
@Data
public class Category implements Serializable{
    private static final long serialVersionUID= 536871008L;
    @Id
    private Long cat_id;
    private String name;
    private Integer parent_id;
    private String cat_path;
    private Integer goods_counts;
    private Integer sort;
    private Integer type_id;
    private Integer list_show;
    private String image;

    @Generated(hash = 1271809492)
    public Category(Long cat_id, String name, Integer parent_id, String cat_path,
            Integer goods_counts, Integer sort, Integer type_id, Integer list_show,
            String image) {
        this.cat_id = cat_id;
        this.name = name;
        this.parent_id = parent_id;
        this.cat_path = cat_path;
        this.goods_counts = goods_counts;
        this.sort = sort;
        this.type_id = type_id;
        this.list_show = list_show;
        this.image = image;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }
    public Long getCat_id() {
        return this.cat_id;
    }
    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getParent_id() {
        return this.parent_id;
    }
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
    public String getCat_path() {
        return this.cat_path;
    }
    public void setCat_path(String cat_path) {
        this.cat_path = cat_path;
    }
    public Integer getGoods_counts() {
        return this.goods_counts;
    }
    public void setGoods_counts(Integer goods_counts) {
        this.goods_counts = goods_counts;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Integer getType_id() {
        return this.type_id;
    }
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
    public Integer getList_show() {
        return this.list_show;
    }
    public void setList_show(Integer list_show) {
        this.list_show = list_show;
    }
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
