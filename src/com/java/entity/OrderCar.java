package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * author:孙琪
 * date:2019/4/28
 * time:10:18
 */
@Entity
@Table(name = "order_car")//购物车表
public class OrderCar {
    private Integer cid;//购物车订单编号
    private String typeName;//类型
    private Integer gid;//商品编号
    private String goodsName;//商品名称（点击可查看商品详细信息）
    private Double price;//单价
    private Integer amount;//数量（可修改）
    private Double sumPrice;//总价
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    @Column(name = "sum_price")
    public Double getSumPrice() {
        return price*amount;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public OrderCar() {
    }

    public OrderCar(Integer cid, String typeName, Integer gid, String goodsName, Double price, Integer amount, Double sumPrice) {
        this.cid = cid;
        this.typeName = typeName;
        this.gid = gid;
        this.goodsName = goodsName;
        this.price = price;
        this.amount = amount;
        this.sumPrice = sumPrice;
    }

    public OrderCar(String typeName, Integer gid, String goodsName, Double price, Integer amount, Double sumPrice) {
        this.typeName = typeName;
        this.gid = gid;
        this.goodsName = goodsName;
        this.price = price;
        this.amount = amount;
        this.sumPrice = sumPrice;
    }
}
