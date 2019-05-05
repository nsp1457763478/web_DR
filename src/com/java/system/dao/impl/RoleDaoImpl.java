package com.java.system.dao.impl;

import com.java.system.dao.RoleDao;
import com.java.system.entity.Role;
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
public class RoleDaoImpl implements RoleDao {
    private QueryRunner queryRunner = new QueryRunner();
    final static String colname=" role_id roleId,role_name roleName ";
    @Override
    public List<Role> getAllRole() {
        String sql = "select"+colname+"from role";
        try {
            List<Role> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Role.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Role> getAllRoleByPage(PageBean pageBean) {
        String sql = "select"+colname+"from role limit ?,?";
        try {
            List<Role> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Role.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Role findRoleById(int roleId) {
        String sql = "select"+colname+"from role where role_id=?";
        try {
            Role role = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Role.class), roleId);
            return role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addRole(Role role) {
        String sql = "insert into role (role_name) values (?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, role.getRoleName());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateRole(Role role) {
        String sql = "update role set role_name=? where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, role.getRoleName(), role.getRoleId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteRole(int roleId) {
        String sql = "delete from role where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
