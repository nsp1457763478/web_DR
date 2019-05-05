package com.java.system.dao.impl;


import com.java.system.dao.OfficeDao;
import com.java.system.entity.Office;
import com.java.util.JdbcUtil;
import com.java.util.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:23
 */
public class OfficeDaoImpl implements OfficeDao {
    private QueryRunner queryRunner = new QueryRunner();
    final static String colname="office_id officeId,office_name officeName,sex," +
            "phone,email,address,degree,office_time officeTime,password ";
    @Override
    public List<Office> getAllOffice() {
        String sql ="select o.office_id officeId,o.office_name officeName,o.sex,o.phone,o.email,o.address,o.degree,o.office_time officeTime,o.password,r.role_name roleName from office o" +
                " left join role_office ro on o.office_id=ro.office_id" +
                " left join role r on ro.role_id=r.role_id";
        //String sql = "select "+colname+" from office";
        try {
            List<Office> list = queryRunner.query(JdbcUtil.getConnection(),sql, new BeanListHandler<>(Office.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Office> getAllOfficeByPage(PageBean pageBean) {
        String sql ="select o.office_id officeId,o.office_name officeName,o.sex,o.phone,o.email,o.address,o.degree,o.office_time officeTime,o.password,r.role_name roleName from office o" +
                " left join role_office ro on o.office_id=ro.office_id" +
                " left join role r on ro.role_id=r.role_id limit ?,?";
       // String sql = "select "+colname+" from office limit ?,?";
        try {
            List<Office> list = queryRunner.query(JdbcUtil.getConnection(),sql, new BeanListHandler<>(Office.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Office findOfficeById(int officeId) {
        String sql = "select "+colname+"from office where office_id =?";
        try {
            Office o = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Office.class), officeId);
            return o;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Office findOfficeByOfficeName(String officeName) {
        String sql = "select "+colname+"from office where office_name =?";
        try {
            Office o = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Office.class), officeName);
            return o;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addOffice(Office o) {
        String sql = "insert into office (office_name,sex,phone,email,address,degree,office_time,password) values (?,?,?,?,?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql,
                    o.getOfficeName(), o.getSex(),o.getPhone(),o.getEmail(),
                    o.getAddress(),o.getDegree(),o.getOfficeTime(),o.getPassword());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private int officeId;//职员编号

    @Override
    public int updateOffice(Office o) {
        String sql = "update office set office_name=?,sex=?,phone=?,email=?,address=?,degree=?,office_time=?,password=? where office_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql,
                    o.getOfficeName(), o.getSex(),o.getPhone(),o.getEmail(),
                    o.getAddress(),o.getDegree(),o.getOfficeTime(),o.getPassword(),o.getOfficeId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteOffice(int officeId) {
        String sql = "delete from office where office_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, officeId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
