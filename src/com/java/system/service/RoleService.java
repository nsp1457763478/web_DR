package com.java.system.service;

import com.java.system.dao.impl.RoleDaoImpl;
import com.java.system.entity.Role;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:16:02
 */

public class RoleService {

    RoleDaoImpl dao=new RoleDaoImpl();
    //查询所有的角色
    public List<Role> getAllRole(){
        return dao.getAllRole();
    }

    //查询所有角色的分页
    public List<Role> getAllRoleByPage(PageBean pageBean){
        return dao.getAllRoleByPage(pageBean);
    }

    //通过ID查询角色
    public Role findRoleById(int roleId){
        return dao.findRoleById(roleId);
    }

    //添加角色
    public int addRole(Role role){
        return dao.addRole(role);
    }

    //修改角色
    public int updateRole(Role role){
        return dao.updateRole(role);
    }

    //删除角色
    public int deleteRole(int roleId){
        return dao.deleteRole(roleId);
    }
}
