package com.java.order.dao.impl;


import com.java.order.dao.OrderlistDao;
import com.java.order.entity.Orderlist;
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
 * Date: 2019/4/27
 * Time: 15:41
 * Description: No Description
 */
public class OrderlistDaoImpl implements OrderlistDao {
    @Override
    public List<Orderlist> findAll(String user, Integer index, Integer pageCount) {
        String sql="select * from orderlist where buy_user=? order by date DESC limit ?,?";
        List<Orderlist> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,user);
            ps.setInt(2,(index-1)*pageCount);
            ps.setInt(3,pageCount);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String wupin_image = rs.getString("wupin_image");
                Integer wupinId = rs.getInt("wupin_id");
                Integer wupin_number = rs.getInt("wupin_number");
                String sell_user = rs.getString("sell_user");
                String buy_user = rs.getString("buy_user");
                String addr = rs.getString("addr");
                Integer is_delivered = rs.getInt("is_delivered");
                String delivered=null;
                if(is_delivered==0){
                    delivered="未发货";
                }else {
                    delivered="已发货";
                }
                String orderlist_number = rs.getString("orderlist_number");
                Integer total_cost = rs.getInt("total_cost");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new Orderlist(id,wupin_image,wupinId,wupin_number,sell_user,buy_user,addr,delivered,orderlist_number,
                        total_cost,newDate));
            }
            return list;
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
    public Integer add(Orderlist orderlist) {
        String sql="insert into orderlist(wupin_image,wupin_id,wupin_number,sell_user," +
                "buy_user,addr,is_delivered," +
                "orderlist_number,total_cost,date) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,orderlist.getWupinImage());
            ps.setInt(2,orderlist.getWupinId());
            ps.setInt(3,orderlist.getWupinNumber());
            ps.setString(4,orderlist.getSellUser());
            ps.setString(5,orderlist.getBuyUser());
            ps.setString(6,orderlist.getAddr());
            ps.setInt(7,0);
            ps.setString(8,orderlist.getOrderlistNumber());
            ps.setInt(9,orderlist.getTotalCost());
            String date = orderlist.getDate();
            Integer newDate = DateUtil.stringToTimeStamp(date);
            ps.setInt(10,newDate);
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
    public Orderlist findOne(Integer id) {
        String sql="SELECT * FROM orderlist where id=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String wupinImage = rs.getString("wupin_image");
                Integer wupinId = rs.getInt("wupin_id");
                Integer wupinNumber = rs.getInt("wupin_number");
                String sellUser = rs.getString("sell_user");
                String buyUser = rs.getString("buy_user");
                String addr = rs.getString("addr");
                Integer isDelivered = rs.getInt("is_delivered");
                String delivered=null;
                if(isDelivered==0){
                    delivered="未发货";
                }else if(isDelivered==1){
                    delivered="已发货";
                }
                String orderlistNumber = rs.getString("orderlist_number");
                Integer totalCost = rs.getInt("total_cost");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                return new Orderlist(id,wupinImage,wupinId,wupinNumber,sellUser,buyUser,addr,delivered,
                        orderlistNumber,totalCost,newDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer deleteOne(Integer id) {
        String sql="delete from orderlist where id=?";
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
    public Integer getCount(String user) {
        String sql="SELECT count(*) AS count FROM orderlist WHERE buy_user=?";
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
}