package com.java.user.dao;


import com.java.user.entity.User;
import com.java.util.PageBean;

import java.util.List;

/**
 * @author : liuxulong
 * date : 9:13 2019/4/30
 */
public interface UserDao {
    public List<User> queryPage(PageBean pageBean);
    public int delete(int u_id);
    public List<User> findAll();
    public User queryOne(int u_id);

    //注册功能
    public Integer add(User user);
    //登录功能
    public User findOne(String username);
    //用户更新个人信息
    public Integer update(User user);
}
