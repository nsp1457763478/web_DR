package com.java.order.dao;


import com.java.order.entity.Information;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/28
 * Time: 14:32
 * Description: No Description
 */
public interface InformationDao {
    List<Information> findAll(Integer uId, Integer index, Integer pageCount);
    Integer add(Information information);
    Integer update(Integer id);
    Integer delete(Integer id);
    Information findOne(Integer id);
    Integer deleteAll(Integer uId);
    Integer getCount();
}
