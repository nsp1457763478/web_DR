package com.java.system.service;

import com.java.system.dao.OfficeDao;
import com.java.system.dao.impl.OfficeDaoImpl;
import com.java.system.entity.Office;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:16:02
 */

public class OfficeService {
    OfficeDao dao=new OfficeDaoImpl();
    //查询所有的职员
    public List<Office> getAllOffice(){
        return dao.getAllOffice();
    }

    //查询所有职员的分页
    public List<Office> getAllOfficeByPage(PageBean pageBean){
        return dao.getAllOfficeByPage(pageBean);
    }

    //通过ID查找职员
    public Office findOfficeById(int officeId){
        return dao.findOfficeById(officeId);
    }

    //通过officeName查找职员
    public Office findOfficeByOfficeName(String officeName){
        return dao.findOfficeByOfficeName(officeName);
    }

    //添加职员
    public int addOffice(Office o){
        return dao.addOffice(o);
    }

    //修改职员
    public int updateOffice(Office o){
        return dao.updateOffice(o);
    }

    //删除职员
    public int deleteOffice(int officeId){
        return dao.deleteOffice(officeId);
    }
}
