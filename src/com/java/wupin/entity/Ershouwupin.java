package com.java.wupin.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:10
 * Description: No Description
 */
public class Ershouwupin {
    private Integer id;
    private String title;
    private String type;
    private String image;
    private String deal;
    private String where;
    private Integer price;
    private String sellUser;
    private String sellPhone;
    private String introduce;
    private String date;

    public Ershouwupin() {
    }

    public Ershouwupin(String title, String type, String image, String deal, String where, Integer price, String sellUser, String sellPhone, String introduce, String date) {
        this.title = title;
        this.type = type;
        this.image = image;
        this.deal = deal;
        this.where = where;
        this.price = price;
        this.sellUser = sellUser;
        this.sellPhone = sellPhone;
        this.introduce = introduce;
        this.date = date;
    }

    public Ershouwupin(Integer id, String title, String type, String image, String deal, String where, Integer price, String sellUser, String sellPhone, String introduce, String date) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.image = image;
        this.deal = deal;
        this.where = where;
        this.price = price;
        this.sellUser = sellUser;
        this.sellPhone = sellPhone;
        this.introduce = introduce;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSellUser() {
        return sellUser;
    }

    public void setSellUser(String sellUser) {
        this.sellUser = sellUser;
    }

    public String getSellPhone() {
        return sellPhone;
    }

    public void setSellPhone(String sellPhone) {
        this.sellPhone = sellPhone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ershouwupin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", deal='" + deal + '\'' +
                ", where='" + where + '\'' +
                ", price=" + price +
                ", sellUser='" + sellUser + '\'' +
                ", sellPhone='" + sellPhone + '\'' +
                ", introduce='" + introduce + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
