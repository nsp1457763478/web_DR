package com.java.wupin.service;


import com.java.wupin.entity.Ershouwupin;
import com.java.wupin.dao.ErshouwupinDao;
import com.java.wupin.dao.impl.ErshouwupinDaoImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:36
 * Description: No Description
 */
public class ErshouwupinService {
    private ErshouwupinDao ershouwupinDao=new ErshouwupinDaoImpl();
    public List<Ershouwupin> findAll(){
        return ershouwupinDao.findAll();
    }
    public List<Ershouwupin> search(String title,Integer index,Integer pageCount){
        return ershouwupinDao.search(title,index,pageCount);
    }

    public Ershouwupin queryDetail(int id){
        return ershouwupinDao.queryDetail(id);
    }

    public List<Ershouwupin> findOneSale(String office_name,Integer index,Integer pageCount){
        return ershouwupinDao.findOneSale(office_name,index,pageCount);
    }
    public Integer delete(Integer id){
        return ershouwupinDao.delete(id);
    }
    public Integer getCount(String title){
        return ershouwupinDao.getCount(title);
    }
//    public Integer getOneSaleCount(String user){
//        return ershouwupinDao.getOneSaleCount(user);
//    }
    public Integer update(Ershouwupin ershouwupin){
        return ershouwupinDao.update(ershouwupin);
    }
    public Integer add(Ershouwupin ershouwupin){
        return ershouwupinDao.add(ershouwupin);
    }
    public List<String> findAllType(){
        return ershouwupinDao.findAllType();
    }
//    public List<Ershouwupin> findHot(){
//        return ershouwupinDao.findHot();
//    }
    public List<Ershouwupin> findNewst(){
        return ershouwupinDao.findNewst();
    }

    public List<Ershouwupin> findByType(String type){
        return ershouwupinDao.findByType(type);
    }

}

