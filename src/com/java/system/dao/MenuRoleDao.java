package com.java.system.dao;

import com.java.system.entity.MenuRole;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:21
 */
public interface MenuRoleDao {
    //通过roleId查询权限
    public List<MenuRole> getAllMenuByRoleId(int roleId);

    //添加权限用户映射表
    public int addMenuRole(MenuRole menuRole);

   //删除权限用户映射表
   public int deleteMenuRole(int menuRoleId);

    //通过roleId删除权限用户映射表
    public int deleteMenuRoleByRoleId(int roleId);
}
