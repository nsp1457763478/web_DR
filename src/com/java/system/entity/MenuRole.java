package com.java.system.entity;

public class MenuRole {
    private int menuRoleId;
    private int roleId;
    private int menuId;

    public int getMenuRoleId() {
        return menuRoleId;
    }
    public void setMenuRoleId(int menuRoleId) {
        this.menuRoleId = menuRoleId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public MenuRole() {
    }

    public MenuRole(int menuRoleId, int menuId, int roleId) {
        this.menuRoleId = menuRoleId;
        this.roleId = roleId;
        this.menuId = menuId;

    }
    public MenuRole(int menuId, int roleId) {
        this.roleId = roleId;
        this.menuId = menuId;

    }
}
