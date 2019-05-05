package com.java.user.service;


import com.java.user.dao.UserDao;
import com.java.user.dao.impl.UserDaoImpl;
import com.java.user.entity.User;
import com.java.util.PageBean;

import java.util.List;

/**
 * @author : liuxulong
 * date : 9:40 2019/4/30
 */
public class UserService {
    private UserDao dao=new UserDaoImpl();
    public List<User> queryPage(PageBean pageBean){return dao.queryPage(pageBean);}
    public int delete(int u_id){ return  dao.delete(u_id);}
    public List<User> findAll(){ return  dao.findAll();}
    public User queryOne(int u_id){return  dao.queryOne(u_id);}

    public Integer add(User user){
        return dao.add(user);
    }
    public User findOne(String username){
        return dao.findOne(username);
    }
    public Integer update(User user){
        return dao.update(user);
    }

}
