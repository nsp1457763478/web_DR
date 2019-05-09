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
    private Integer price;
    private Integer stock;//库存
    private String introduce;
    private String date;
    private Integer click;
    private String office_name;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getOffice_name() {
        return office_name;
    }

    public void setOffice_name(String office_name) {
        this.office_name = office_name;
    }

    public Ershouwupin() {
    }

    public Ershouwupin(Integer id, String title, String type, String image, Integer price, Integer stock, String introduce, String date, Integer click,String office_name) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.introduce = introduce;
        this.date = date;
        this.click = click;
        this.office_name = office_name;
    }
    public Ershouwupin(String title, String type, String image, Integer price, Integer stock, String introduce, String date, Integer click,String office_name) {
        this.title = title;
        this.type = type;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.introduce = introduce;
        this.date = date;
        this.click = click;
        this.office_name = office_name;
    }
    public Ershouwupin(String title, String type, String image, Integer price, Integer stock, String introduce, String date,String office_name) {
        this.title = title;
        this.type = type;
        this.image = image;
        this.price = price;
        this.stock = stock;
        this.introduce = introduce;
        this.date = date;
        this.office_name = office_name;
    }
    public Ershouwupin(String title, String type, Integer price, Integer stock, String introduce, String date,String office_name) {
        this.title = title;
        this.type = type;
        this.price = price;
        this.stock = stock;
        this.introduce = introduce;
        this.date = date;
        this.office_name = office_name;
    }
    @Override
    public String toString() {
        return "Ershouwupin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", introduce='" + introduce + '\'' +
                ", date='" + date + '\'' +
                ", click='" + click + '\'' +
                ", office_name=" + office_name +
                '}';
    }
}
