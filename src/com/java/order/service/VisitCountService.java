package com.java.order.service;

import com.java.order.dao.VisitCountDao;
import com.java.order.dao.impl.VisitCountDaoImpl;

public class VisitCountService {
    private VisitCountDao visitCountDao=new VisitCountDaoImpl();
    public Integer getCount(){
        return visitCountDao.getCount();
    }
    public Integer update(Integer count){
        return visitCountDao.update(count);
    }
}
