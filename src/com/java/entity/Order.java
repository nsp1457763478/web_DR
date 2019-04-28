package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * author:孙琪
 * date:2019/4/28
 * time:9:33
 */
@Entity
@Table(name = "order")//订单表
public class Order {
    private Integer oid;//订单编号
    private String name;//用户姓名
    private Integer id;//身份证号
    private String typeName;//商品分类名称
    private String productName;//商品名称（点击可查看商品详细信息）
    private Double price;//单价
    private Integer amount;//数量
    private Double sumPrice;//总价
    private String address;//送货地址
    private Date createTime;//订购时间
    private Integer handing;//是否发货
    private String shipper;//经手工作人员
    private String options;//操作（退货退款）
    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHanding() {
        return handing;
    }

    public void setHanding(Integer handing) {
        this.handing = handing;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }



    public Order() {
    }

    public Order(Integer oid, String name, Integer id, String typeName, String productName, Double price, Integer amount, Double sumPrice, String address, Date createTime, Integer handing, String shipper, String options) {
        this.oid = oid;
        this.name = name;
        this.id = id;
        this.typeName = typeName;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.sumPrice = sumPrice;
        this.address = address;
        this.createTime = createTime;
        this.handing = handing;
        this.shipper = shipper;
        this.options = options;
    }

    public Order(String name, Integer id, String typeName, String productName, Double price, Integer amount, Double sumPrice, String address, Date createTime, Integer handing, String shipper, String options) {
        this.name = name;
        this.id = id;
        this.typeName = typeName;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.sumPrice = sumPrice;
        this.address = address;
        this.createTime = createTime;
        this.handing = handing;
        this.shipper = shipper;
        this.options = options;
    }
//编号，商品名称（点击可查看商品详细信息），单价，数量，总价，退货退款
    public Order(Integer oid, String productName, Double price, Integer amount, Double sumPrice, String address) {
        this.oid = oid;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.sumPrice = sumPrice;
        this.address = address;
    }
}
