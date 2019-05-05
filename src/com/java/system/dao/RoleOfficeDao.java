package com.java.system.dao;

import com.java.system.entity.RoleOffice;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:20
 */
public interface RoleOfficeDao {

    //查询所有的角色和职员映射表
    public List<RoleOffice> getAllRoleOffice();

    //通过officeId查找角色和职员的映射表
    public RoleOffice findRoleOfficeByOfficeId(int officeId);

    //添加角色和职员映射表
    public int addRoleOffice(RoleOffice roleOffice);

    //删除添加角色和职员映射表
    public int deleteRoleOffice(int roleOfficeId);

    //通过用户删除角色和职员映射表
    public int deleteByOfficeId(int officeId);
}
