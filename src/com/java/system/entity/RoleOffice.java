package com.java.system.entity;

/**
 * author:孙琪
 * date:2019/4/28
 * time:11:37
 */

public class RoleOffice {
    private int roleOfficeId;
    private int officeId;
    private int roleId;

    public int getRoleOfficeId() {
        return roleOfficeId;
    }

    public void setRoleOfficeId(int roleOfficeId) {
        this.roleOfficeId = roleOfficeId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleOffice() {
    }

    public RoleOffice(int roleOfficeId, int officeId, int roleId) {
        this.roleOfficeId = roleOfficeId;
        this.officeId = officeId;
        this.roleId = roleId;
    }
    public RoleOffice(int officeId, int roleId) {
        this.officeId = officeId;
        this.roleId = roleId;
    }
}
