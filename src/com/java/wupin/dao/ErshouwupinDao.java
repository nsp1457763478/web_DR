package com.java.wupin.dao;


import com.java.wupin.entity.Ershouwupin;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:17
 * Description: No Description
 */
public interface ErshouwupinDao {
    public List<Ershouwupin> findAll();
    public List<Ershouwupin> search(String title, Integer index, Integer pageCount);
    public Ershouwupin queryDetail(Integer id);
    public List<Ershouwupin> findOneSale(String office_name, Integer index, Integer pageCount);
    public Integer delete(Integer id);
    public Integer getCount(String title);
    public Integer getOneSaleCount(String office_name);
    public Integer update(Ershouwupin ershouwupin);


    public Integer add(Ershouwupin ershouwupin);
    public List<String> findAllType();
   // public List<Ershouwupin> findHot();
    public List<Ershouwupin> findNewst();

    public List<Ershouwupin> findByType(String type);
}
