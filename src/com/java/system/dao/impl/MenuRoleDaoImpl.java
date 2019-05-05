package com.java.system.dao.impl;

import com.java.system.dao.MenuRoleDao;
import com.java.system.entity.MenuRole;
import com.java.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:14:23
 */
public class MenuRoleDaoImpl implements MenuRoleDao {
    final static String colname=" menu_role_id MenuRoleId,role_id roleId,menu_id menuId ";
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<MenuRole> getAllMenuByRoleId(int roleId) {
        String sql = "select"+colname+"from menu_role where role_id=?";
        try {
            List<MenuRole> query = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(MenuRole.class), roleId);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addMenuRole(MenuRole menuRole) {
        String sql = "insert into menu_role (role_id,menu_id) values (?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuRole.getRoleId(),menuRole.getMenuId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenuRole(int menuRoleId) {
        String sql = "delete from menu_role where menu_role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuRoleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenuRoleByRoleId(int roleId) {
        String sql = "delete from menu_role where role_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, roleId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
