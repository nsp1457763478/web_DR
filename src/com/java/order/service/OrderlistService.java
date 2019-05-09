package com.java.order.service;


import com.java.order.dao.OrderlistDao;
import com.java.order.dao.impl.OrderlistDaoImpl;
import com.java.order.entity.Orderlist;
import com.java.util.PageBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/27
 * Time: 16:37
 * Description: No Description
 */
public class OrderlistService {
    private OrderlistDao orderlistDao=new OrderlistDaoImpl();
    public List<Orderlist> findAll(String user,Integer index,Integer pageCount){
        return orderlistDao.findAll(user,index,pageCount);
    }
    public List<Orderlist> findAll(){
        return orderlistDao.findAll();
    }
    public List<Orderlist> queryPage(PageBean pageBean){
        return orderlistDao.queryPage(pageBean);
    }
    public Integer add(Orderlist orderlist){
        return orderlistDao.add(orderlist);
    }
    public Integer getCount(String user){
        return orderlistDao.getCount(user);
    }
    public Orderlist findOne(Integer id){
        return orderlistDao.findOne(id);
    }
    public Orderlist findOneBywupinId(Integer wupinId){
        return orderlistDao.findOneByWupinId(wupinId);
    }
    public Integer deleteOne(Integer id){
        return orderlistDao.deleteOne(id);
    }
    public Integer update(Integer id){
        return orderlistDao.update(id);
    }
}
