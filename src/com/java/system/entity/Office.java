package com.java.system.entity;

import java.util.Date;

/**
 * author:孙琪
 * date:2019/4/28
 * time:11:30
 */

public class Office {
    private int officeId;//职员编号
    private String officeName;//职员姓名
    //private String roleName;//角色名（超级管理员/普通管理员）
    private String sex;//性别
    private long phone;//联系电话
    private String email;//邮箱
    private String address;//详细住址
    private String degree;//学历
    private Date officeTime;//入职时间
    private String password;//登陆密码
    private String roleName;

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getOfficeTime() {
        return officeTime;
    }

    public void setOfficeTime(Date officeTime) {
        this.officeTime = officeTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Office() {
    }

    public Office(int officeId, String officeName, String sex, long phone, String email, String address, String degree, Date officeTime, String password) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.degree = degree;
        this.officeTime = officeTime;
        this.password = password;
    }
    public Office(String officeName, String sex, long phone, String email, String address, String degree, Date officeTime, String password) {

        this.officeName = officeName;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.degree = degree;
        this.officeTime = officeTime;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", degree='" + degree + '\'' +
                ", officeTime=" + officeTime +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
