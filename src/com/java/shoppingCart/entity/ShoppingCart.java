package com.java.shoppingCart.entity;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/26
 * Time: 8:59
 * Description: No Description
 */
public class ShoppingCart {
    private Integer id;
    private String user;
    private String image;
    private String title;
    private Integer price;
    private String date;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer id, String user, String image, String title, Integer price, String date) {
        this.id = id;
        this.user = user;
        this.image = image;
        this.title = title;
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
