package com.java.system.service;

import com.java.system.dao.MenuRoleDao;
import com.java.system.dao.impl.MenuRoleDaoImpl;
import com.java.system.entity.MenuRole;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:16:02
 */

public class MenuRoleService {

     MenuRoleDao dao=new MenuRoleDaoImpl();
    //通过roleId查询权限
    public List<MenuRole> getAllMenuByRoleId(int roleId){
        return dao.getAllMenuByRoleId(roleId);
    }

    //添加权限用户映射表
    public int addMenuRole(MenuRole menuRole){
        return dao.addMenuRole(menuRole);
    }

    //删除权限用户映射表
    public int deleteMenuRole(int menuRoleId){
        return dao.deleteMenuRole(menuRoleId);
    }

    //通过roleId删除权限用户映射表
    public int deleteMenuRoleByRoleId(int roleId){
        return dao.deleteMenuRoleByRoleId(roleId);
    }
}
