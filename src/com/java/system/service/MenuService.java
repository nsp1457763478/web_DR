package com.java.system.service;

import com.java.system.dao.MenuDao;
import com.java.system.dao.impl.MenuDaoImpl;
import com.java.system.entity.Menu;
import com.java.util.PageBean;

import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:16:02
 */

public class MenuService {

    MenuDao dao=new MenuDaoImpl();
    //查询所有的权限菜单
    public List<Menu> getAllMenu(){
        return dao.getAllMenu();
    }

    //查询所有权限菜单的分页
    public List<Menu> getAllMenuByPage(PageBean pageBean){
        return dao.getAllMenuByPage(pageBean);
    }

    //通过ID查询权限菜单
    public Menu findMenuById(int menuId){
        return dao.findMenuById(menuId);
    }

    //添加菜单
    public int addMenu(Menu menu){
        return dao.addMenu(menu);
    }

    //修改菜单
    public int updateMenu(Menu menu){
        return dao.updateMenu(menu);
    }

    //删除菜单
    public int deleteMenu(int menuId){
        return dao.deleteMenu(menuId);
    }

    //通过officeId查找权限菜单
    public List<Menu> findMenuByOfficeId(int officeId){
        return dao.findMenuByOfficeId(officeId);
    }

}
