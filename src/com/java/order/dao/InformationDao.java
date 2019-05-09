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
    public List<Information> findAll(Integer uId, Integer index, Integer pageCount);
    public Integer add(Information information);
    public Integer update(Integer id);
    public Integer delete(Integer id);
    public Information findOne(Integer id);
    public Integer deleteAll(Integer uId);
    public Integer getCount(Integer uId);
}
