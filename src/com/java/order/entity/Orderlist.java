package com.java.order.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/27
 * Time: 14:28
 * Description: No Description
 */
public class Orderlist {
    private Integer id;
    private String  wupinImage;
    private Integer wupinId;
    private Integer wupinNumber;
    private String  sellUser;
    private String  buyUser;
    private String  addr;
    private String  isDelivered;
    private String  orderlistNumber;
    private Integer totalCost;
    private String  date;

    public Orderlist() {
    }

    public Orderlist(String wupinImage, Integer wupinId, Integer wupinNumber, String sellUser, String buyUser, String addr, String isDelivered, String orderlistNumber, Integer totalCost, String date) {
        this.wupinImage = wupinImage;
        this.wupinId = wupinId;
        this.wupinNumber = wupinNumber;
        this.sellUser = sellUser;
        this.buyUser = buyUser;
        this.addr = addr;
        this.isDelivered = isDelivered;
        this.orderlistNumber = orderlistNumber;
        this.totalCost = totalCost;
        this.date = date;
    }

    public Orderlist(Integer id, String wupinImage, Integer wupinId, Integer wupinNumber, String sellUser,  String buyUser, String addr, String isDelivered, String orderlistNumber, Integer totalCost, String date) {
        this.id = id;
        this.wupinImage = wupinImage;
        this.wupinId = wupinId;
        this.wupinNumber = wupinNumber;
        this.sellUser = sellUser;
        this.buyUser = buyUser;
        this.addr = addr;
        this.isDelivered = isDelivered;
        this.orderlistNumber = orderlistNumber;
        this.totalCost = totalCost;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWupinImage() {
        return wupinImage;
    }

    public void setWupinImage(String wupinImage) {
        this.wupinImage = wupinImage;
    }

    public Integer getWupinId() {
        return wupinId;
    }

    public void setWupinId(Integer wupinId) {
        this.wupinId = wupinId;
    }

    public Integer getWupinNumber() {
        return wupinNumber;
    }

    public void setWupinNumber(Integer wupinNumber) {
        this.wupinNumber = wupinNumber;
    }

    public String getSellUser() {
        return sellUser;
    }

    public void setSellUser(String sellUser) {
        this.sellUser = sellUser;
    }

    public String getBuyUser() {
        return buyUser;
    }

    public void setBuyUser(String buyUser) {
        this.buyUser = buyUser;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered = isDelivered;
    }

    public String getOrderlistNumber() {
        return orderlistNumber;
    }

    public void setOrderlistNumber(String orderlistNumber) {
        this.orderlistNumber = orderlistNumber;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orderlist{" +
                "id=" + id +
                ", wupinImage='" + wupinImage + '\'' +
                ", wupinId=" + wupinId +
                ", wupinNumber=" + wupinNumber +
                ", sellUser='" + sellUser + '\'' +
                ", buyUser='" + buyUser + '\'' +
                ", addr='" + addr + '\'' +
                ", isDelivered='" + isDelivered + '\'' +
                ", orderlistNumber='" + orderlistNumber + '\'' +
                ", totalCost=" + totalCost +
                ", date='" + date + '\'' +
                '}';
    }
}
