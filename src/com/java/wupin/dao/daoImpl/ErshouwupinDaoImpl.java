package com.java.wupin.dao.daoImpl;


import com.java.wupin.entity.Ershouwupin;
import com.java.wupin.dao.ErshouwupinDao;
import com.java.util.DateUtil;
import com.java.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/11
 * Time: 0:18
 * Description: 搜索，获得全部
 */
public class ErshouwupinDaoImpl implements ErshouwupinDao {
    @Override
    public List<Ershouwupin> findAll() {
        return null;
    }

    @Override
    public List<Ershouwupin> search(String title,Integer index,Integer pageCount) {
        String sql="SELECT * FROM ershouwupin WHERE title like '%"+title+"%' LIMIT ?,?";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(index-1)*pageCount);
            ps.setInt(2,pageCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                Integer price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate);
                list.add(ershouwupin);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ershouwupin queryDetail(Integer id) {
        String sql="SELECT * FROM ershouwupin WHERE id=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                Integer price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                return new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ershouwupin> findOneSale(String username,Integer index,Integer pageCount) {
        String sql="SELECT * FROM ershouwupin WHERE sell_user=?  LIMIT ?,?";
        Connection conn = JdbcUtil.getConnection();
        List<Ershouwupin> list=new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setInt(2,(index-1)*pageCount);
            ps.setInt(3,pageCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                String deal = rs.getString("deal");
                String where = rs.getString("where");
                Integer price = rs.getInt("price");
                String sellUser = rs.getString("sell_user");
                String sellPhone = rs.getString("sell_phone");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new Ershouwupin(id,title1,type,image,deal,where,price,sellUser,sellPhone,introduce,newDate));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        String sql="delete from ershouwupin where id=?";
        PreparedStatement ps=null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            Integer i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public Integer getCount(String title) {
        String sql="SELECT count(*) AS count FROM ershouwupin WHERE title LIKE '%"+title+"%'";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer count = rs.getInt("count");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer getOneSaleCount(String user) {
        String sql="SELECT count(*) AS count FROM ershouwupin WHERE sell_user=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer count = rs.getInt("count");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer update(Ershouwupin ershouwupin) {
        return null;
    }
}
