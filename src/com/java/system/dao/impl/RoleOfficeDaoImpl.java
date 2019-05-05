package com.java.system.dao.impl;

import com.java.system.dao.RoleOfficeDao;
import com.java.system.entity.RoleOffice;
import com.java.util.JdbcUtil;
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
public class RoleOfficeDaoImpl implements RoleOfficeDao {
    private QueryRunner queryRunner = new QueryRunner();
    final static String colname=" role_office_id roleOfficeId,office_id OfficeId,role_id roleId ";
    @Override
    public List<RoleOffice> getAllRoleOffice() {
        String sql = "select"+colname+"from role_office";
        try {
            List<RoleOffice> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(RoleOffice.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public RoleOffice findRoleOfficeByOfficeId(int officeId) {
        String sql = "select"+colname+"from role_office where office_id=?";
        try {
            RoleOffice query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(RoleOffice.class), officeId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addRoleOffice(RoleOffice roleOffice) {
        String sql = "insert into role_office (role_id,office_id) values (?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleOffice.getRoleId(), roleOffice.getOfficeId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRoleOffice(int roleOfficeId) {
        String sql = "delete from role_office where role_office_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleOfficeId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteByOfficeId(int officeId) {
        String sql = "delete from role_office where office_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, officeId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
