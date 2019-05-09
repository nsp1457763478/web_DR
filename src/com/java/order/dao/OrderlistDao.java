package com.java.order.dao;


import com.java.order.entity.Orderlist;
import com.java.util.PageBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/27
 * Time: 15:41
 * Description: No Description
 */
public interface OrderlistDao {
    public List<Orderlist> findAll(String user, Integer index, Integer pageCount);
    public Integer add(Orderlist orderlist);
    public Orderlist findOne(Integer id);
    public Integer deleteOne(Integer id);
    public Integer getCount(String user);
    public List<Orderlist> queryPage(PageBean pageBean);


    public List<Orderlist> findAll();
    public Orderlist findOneByWupinId(Integer wupinId);
    public Integer update(Integer id);

}
