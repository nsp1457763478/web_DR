package com.java.system.entity;

public class Menu {
    private int menuId;//菜单编号
    private String menuName;//菜单名称
    private String img;//菜单图标
    private String url;//功能模块相对路径
    private int parentId = -1;//父节点
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Menu() {
    }

    public Menu(int menuId, String menuName, String img, String url, int parentId) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.img = img;
        this.url = url;
        this.parentId = parentId;
    }
    public Menu(String menuName, String img, String url, int parentId) {
        this.menuName = menuName;
        this.img = img;
        this.url = url;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
