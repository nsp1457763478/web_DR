package com.java.user.entity;


/**
 * author:孙琪
 * date:2019/4/28
 * time:9:24
 */

public class User {
    private Integer u_id;//用户id
    private String username;//用户名
    private String name;//真实姓名
    private long id;//身份证号(因为只能买一次钻戒)
    private String sex;//性别
    private long phone;//联系电话
    private String email;//邮箱
    private String address;//详细住址
    private String password;



    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(Integer u_id, String username, String name, long id, String sex, long phone, String email, String address,String password) {
        this.u_id = u_id;
        this.username = username;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User(String username, String name, long id, String sex, long phone, String email, String address,String password) {
        this.username = username;
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
