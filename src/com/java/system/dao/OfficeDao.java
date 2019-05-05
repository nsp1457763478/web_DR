package com.java.system.dao;

import com.java.system.entity.Office;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:20
 */
public interface OfficeDao {
    //查询所有的职员
    public List<Office> getAllOffice();

    //查询所有职员的分页
    public List<Office> getAllOfficeByPage(PageBean pageBean);

    //通过ID查找职员
    public Office findOfficeById(int officeId);

    //通过username查找职员
    public Office findOfficeByOfficeName(String officeName);

    //添加职员
    public int addOffice(Office o);

    //修改职员
    public int updateOffice(Office o);

    //删除职员
    public int deleteOffice(int officeId);
}
