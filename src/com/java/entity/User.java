package com.java.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * author:孙琪
 * date:2019/4/28
 * time:9:24
 */
@Entity
@Table(name = "user")//用户表
public class User {
    private Integer uid;//用户id
    private String username;//用户名
    private String name;//真实姓名
    private Integer id;//身份证号(因为只能买一次钻戒)
    private String sex;//性别
    private Integer phone;//联系电话
    private String email;//邮箱
    private String address;//详细住址

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
    }

    public User(Integer uid, String username, String name, Integer id, String sex, Integer phone, String email, String address) {
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public User(String username, String name, Integer id, String sex, Integer phone, String email, String address) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
