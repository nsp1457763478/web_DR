package com.java.order.dao;


import com.java.order.entity.Orderlist;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/27
 * Time: 15:41
 * Description: No Description
 */
public interface OrderlistDao {
    List<Orderlist> findAll(String user, Integer index, Integer pageCount);
    Integer add(Orderlist orderlist);
    Orderlist findOne(Integer id);
    Integer deleteOne(Integer id);
    Integer getCount(String user);
}
