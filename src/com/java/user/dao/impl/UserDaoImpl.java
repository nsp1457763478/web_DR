package com.java.user.dao.impl;

import com.java.user.dao.UserDao;
import com.java.user.entity.User;
import com.java.util.JdbcUtil;
import com.java.util.JiaMi;
import com.java.util.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuxulong
 * date : 9:20 2019/4/30
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner qr=new QueryRunner();
    @Override
    public List<User> queryPage(PageBean pageBean) {
        String sql="select * from user limit ?,?";
        System.out.println("sql========="+sql);
        List<User>list = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()){
                int u_id = rs.getInt("u_id");
                String username = rs.getString("username");
                String name = rs.getString("name");
                long id = rs.getLong("id");
                String sex = rs.getString("sex");
                long phone = rs.getLong("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                User user = new User(u_id, username, name, id, sex, phone, email, address, password);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return list;















      /*  List<User> list=new ArrayList<>();
        try {
            list = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(User.class), pageBean.getIndex(), pageBean.getCount());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;*/
    }
    public List<User> findAll(){
        String sql="select * from user";
        List<User> userList=new ArrayList<>();

        try {
            userList = qr.query(JdbcUtil.getConnection(), sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(userList.size());

        return userList;
    }

    @Override
    public User queryOne(int u_id) {
        String sql="select * from user where u_id=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        User user=new User();
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,u_id);
            rs = ps.executeQuery();
            while (rs.next()){
                user.setU_id(rs.getInt("u_id"));
                rs.getString("username");
                user.setName(rs.getString("name"));
                user.setId(rs.getLong("id"));
                user.setSex(rs.getString("sex"));
                user.setPhone(rs.getLong("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }


        return user;
    }


    @Override
    public int delete(int u_id) {
        String sql="delete from user where u_id=?";
        try {
            int i = qr.update(JdbcUtil.getConnection(), sql, u_id);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer add(User user) {
        String sql="insert into user(username,name,id,sex,phone,email,address,password) values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            //将加密后的密码存入数据库
            String password = JiaMi.base64Encode(user.getPassword());
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getName());
            ps.setLong(3,user.getId());
            ps.setString(4,user.getSex());
            ps.setLong(5,user.getPhone());
            ps.setString(6,user.getEmail());
            ps.setString(7,user.getAddress());
            ps.setString(8,password);
            Integer i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return 0;
    }

    @Override
    public User findOne(String username) {
        String sql="select * from user where username=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            User user=new User();
            while (rs.next()){
                user.setU_id(rs.getInt("u_id"));
                rs.getString("username");
                user.setName(rs.getString("name"));
                user.setId(rs.getLong("id"));
                user.setSex(rs.getString("sex"));
                user.setPhone(rs.getLong("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null)
                    rs.close();
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public Integer update(User user) {
        String sql="update user set username=?,name=?,id=?,sex=?,phone=?,email=?,address=?,password=? where u_id=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            //将加密后的密码存入数据库
            String password = user.getPassword();
            String newPassword = JiaMi.base64Encode(password);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getName());
            ps.setLong(3,user.getId());
            ps.setString(4,user.getSex());
            ps.setLong(5,user.getPhone());
            ps.setString(6,user.getEmail());
            ps.setString(7,user.getAddress());
            ps.setString(8,newPassword);
            ps.setInt(9,user.getU_id());
            Integer i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtil.close();
        }
        return 0;
    }
}
