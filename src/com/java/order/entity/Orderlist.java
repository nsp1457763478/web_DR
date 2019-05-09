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
    private String  buyUser;
    private String  addr;
    private String  isDelivered;
    private String  orderlistNumber;//订单号
    private Integer totalCost;//总花费
    private String  date;
    private String  title;
    private String office_name;

    public Orderlist(Integer id, Integer wupinId, String buyUser,String title) {
        this.id = id;
        this.wupinId = wupinId;
        this.buyUser = buyUser;
        this.title = title;
    }

    public Orderlist(String wupinImage, Integer wupinId, Integer wupinNumber, String buyUser, String addr, String isDelivered, String orderlistNumber, Integer totalCost, String date,String title,String office_name) {
        this.wupinImage = wupinImage;
        this.wupinId = wupinId;
        this.wupinNumber = wupinNumber;
        this.buyUser = buyUser;
        this.addr = addr;
        this.isDelivered = isDelivered;
        this.orderlistNumber = orderlistNumber;
        this.totalCost = totalCost;
        this.date = date;
        this.title = title;
        this.office_name=office_name;
    }
    public Orderlist(Integer id,String wupinImage, Integer wupinId, Integer wupinNumber, String buyUser, String addr, String isDelivered, String orderlistNumber, Integer totalCost, String date,String title,String office_name) {
        this.id = id;
        this.wupinImage = wupinImage;
        this.wupinId = wupinId;
        this.wupinNumber = wupinNumber;
        this.buyUser = buyUser;
        this.addr = addr;
        this.isDelivered = isDelivered;
        this.orderlistNumber = orderlistNumber;
        this.totalCost = totalCost;
        this.date = date;
        this.title = title;
        this.office_name=office_name;
    }
    public Orderlist(Integer id, String wupinImage, Integer wupinId, Integer wupinNumber, String buyUser, String addr, String isDelivered, String orderlistNumber, Integer totalCost, String date,String title) {
        this.id = id;
        this.wupinImage = wupinImage;
        this.wupinId = wupinId;
        this.wupinNumber = wupinNumber;
        this.buyUser = buyUser;
        this.addr = addr;
        this.isDelivered = isDelivered;
        this.orderlistNumber = orderlistNumber;
        this.totalCost = totalCost;
        this.date = date;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    @Override
    public String toString() {
        return "Orderlist{" +
                "id=" + id +
                ", wupinImage='" + wupinImage + '\'' +
                ", wupinId=" + wupinId +
                ", wupinNumber=" + wupinNumber +
                ", buyUser='" + buyUser + '\'' +
                ", addr='" + addr + '\'' +
                ", isDelivered='" + isDelivered + '\'' +
                ", orderlistNumber='" + orderlistNumber + '\'' +
                ", totalCost=" + totalCost +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", office_name='" + office_name + '\'' +
                '}';
    }
}
