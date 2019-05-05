package com.java.system.dao;


import com.java.system.entity.Role;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:20
 */
public interface RoleDao {
    //查询所有的角色
    public List<Role> getAllRole();

    //查询所有角色的分页
    public List<Role> getAllRoleByPage(PageBean pageBean);

    //通过ID查询角色
    public Role findRoleById(int roleId);

    //添加角色
    public int addRole(Role role);

    //修改角色
    public int updateRole(Role role);

    //删除角色
    public int deleteRole(int roleId);

}
