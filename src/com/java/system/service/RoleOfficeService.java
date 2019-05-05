package com.java.system.service;

import com.java.system.dao.RoleOfficeDao;
import com.java.system.dao.impl.RoleOfficeDaoImpl;
import com.java.system.entity.RoleOffice;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:16:02
 */

public class RoleOfficeService {

    RoleOfficeDao dao=new RoleOfficeDaoImpl();
    //查询所有的角色和职员映射表
    public List<RoleOffice> getAllRoleOffice(){
        return dao.getAllRoleOffice();
    }

    //通过officeId查找角色和职员的映射表
    public RoleOffice findRoleOfficeByOfficeId(int officeId){
        return dao.findRoleOfficeByOfficeId(officeId);
    }

    //添加角色和职员映射表
    public int addRoleOffice(RoleOffice roleOffice){
        return dao.addRoleOffice(roleOffice);
    }

    //删除添加角色和职员映射表
    public int deleteRoleOffice(int roleOfficeId){
        return dao.deleteRoleOffice(roleOfficeId);
    }

    //通过用户删除角色和职员映射表
    public int deleteByOfficeId(int officeId){
        return dao.deleteByOfficeId(officeId);
    }
}
