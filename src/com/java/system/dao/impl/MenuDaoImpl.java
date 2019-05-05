package com.java.system.dao.impl;

import com.java.system.dao.MenuDao;
import com.java.system.entity.Menu;
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
public class MenuDaoImpl implements MenuDao {
    private QueryRunner queryRunner = new QueryRunner();
    final static String colname=" menu_id menuId,menu_name menuName,img,url,parent_id parentId ";
    @Override
    public List<Menu> getAllMenu() {
        String sql = "select"+colname+"from menu";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//        List<Menu> list = new ArrayList<>();
//        String sql="select"+colname+"from menu";
//        PreparedStatement ps=null;
//        ResultSet rs = null;
//        try {
//            Connection connection = JdbcUtil.getConnection();
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Menu  menu=  new Menu();
//                int menuId = rs.getInt("menuId");
//                String menuName = rs.getString("menuName");
//                String img = rs.getString("img");
//                String url=rs.getString("url");
//                int parentId = rs.getInt("parentId");
//                menu.setMenuId(menuId);
//                menu.setMenuName(menuName);
//                menu.setImg(img);
//                menu.setUrl(url);
//                menu.setParentId(parentId);
//                list.add(menu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(rs!=null)
//                    rs.close();
//                if(ps!=null)
//                    ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            JdbcUtil.close();
//        }
//        return list;
   }

    @Override
    public List<Menu> getAllMenuByPage(PageBean pageBean) {
        String sql = "select"+colname+"from menu limit ?,?";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class), pageBean.getIndex(), pageBean.getPageCount());
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Menu findMenuById(int menuId) {
        String sql = "select"+colname+"from menu where menu_id=?";
        try {
            Menu menu = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanHandler<>(Menu.class), menuId);
            return menu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addMenu(Menu menu) {
        String sql = "insert into menu (menu_name,img,url,parent_id) values (?,?,?,?)";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menu.getMenuName(), menu.getImg(), menu.getUrl(), menu.getParentId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateMenu(Menu menu) {
        String sql = "update menu set menu_name=?,img=?,url=?,parent_id=? where menu_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menu.getMenuName(), menu.getImg(), menu.getUrl(), menu.getParentId(), menu.getMenuId());
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenu(int menuId) {
        String sql = "delete from menu where menu_id=?";
        try {
            int i = queryRunner.update(JdbcUtil.getConnection(), sql, menuId);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Menu> findMenuByOfficeId(int officeId) {
        String sql = "select"+colname+"from menu\n" +
                "where menu_id in (select menu_id from menu_role where role_id =\n" +
                "             (select role_id from role where role_id = (select role_id from role_office where office_id = ?)))";
        try {
            List<Menu> list = queryRunner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(Menu.class), officeId);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
