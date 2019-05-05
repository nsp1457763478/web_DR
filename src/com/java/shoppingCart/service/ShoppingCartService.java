package com.java.shoppingCart.service;

import com.java.shoppingCart.entity.ShoppingCart;
import com.java.shoppingCart.dao.ShoppingCartDao;
import com.java.shoppingCart.dao.impl.ShoppingCartDaoImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/26
 * Time: 9:06
 * Description: No Description
 */
public class ShoppingCartService {
    private ShoppingCartDao shoppingCartDao=new ShoppingCartDaoImpl();
    public int add(ShoppingCart shoppingCart){
        return shoppingCartDao.add(shoppingCart);
    }
    public List<ShoppingCart> findAll(String user){
        return shoppingCartDao.findAll(user);
    }
    public int delete(Integer id,String user){
        return shoppingCartDao.delete(id,user);
    }
    public int deleteAll(String user){
        return shoppingCartDao.deleteAll(user);
    }
}
