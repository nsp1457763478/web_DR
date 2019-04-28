package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * author:孙琪
 * date:2019/4/28
 * time:9:41
 */
@Entity
@Table(name = "goods")//商品表
public class Goods {
    private Integer gid;//商品编号
    private String typeName;//商品分类名称
    private String goodsName;//商品名称
    private Double price;//单价
    private Integer stock;//库存
    private String image;//图片
    private String description;//商品描述
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Goods() {
    }

    public Goods(Integer gid, String typeName, String goodsName, Double price, Integer stock, String image, String description) {
        this.gid = gid;
        this.typeName = typeName;
        this.goodsName = goodsName;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.description = description;
    }
    public Goods(String typeName, String goodsName, Double price, Integer stock, String image, String description) {
        this.typeName = typeName;
        this.goodsName = goodsName;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.description = description;
    }
}
