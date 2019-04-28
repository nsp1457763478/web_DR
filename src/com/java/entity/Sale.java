package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * author:孙琪
 * date:2019/4/28
 * time:10:32
 */
@Entity
@Table(name = "sale")//销售表
public class Sale {
    private Integer sid;//销售编号
    private String goodsName;//商品名称（点击可查看商品详细信息）
    private Integer saleNumber;//销售量
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    @Column(name = "sale_number")
    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Sale() {
    }

    public Sale(Integer sid, String goodsName, Integer saleNumber) {
        this.sid = sid;
        this.goodsName = goodsName;
        this.saleNumber = saleNumber;
    }
    public Sale(String goodsName, Integer saleNumber) {
        this.goodsName = goodsName;
        this.saleNumber = saleNumber;
    }
}
