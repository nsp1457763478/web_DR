package com.java.system.dao;

import com.java.system.entity.Menu;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:20
 */
public interface MenuDao {
    //查询所有的权限菜单
    public List<Menu> getAllMenu();

    //查询所有权限菜单的分页
    public List<Menu> getAllMenuByPage(PageBean pageBean);

    //通过ID查询权限菜单
    public Menu findMenuById(int menuId);

    //添加菜单
    public int addMenu(Menu menu);

    //修改菜单
    public int updateMenu(Menu menu);

    //删除菜单
    public int deleteMenu(int menuId);

    //通过officeId查找权限菜单
    public List<Menu> findMenuByOfficeId(int officeId);

}
