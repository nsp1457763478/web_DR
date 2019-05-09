package com.java.order.dao.impl;


import com.java.order.dao.OrderlistDao;
import com.java.order.entity.Orderlist;
import com.java.util.DateUtil;
import com.java.util.JdbcUtil;
import com.java.util.PageBean;

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
                //String sell_user = rs.getString("sell_user");
                //String sellUserCollege = rs.getString("sell_user_college");
                //String sellUserPhone = rs.getString("sell_user_phone");
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
                String wupinTitle = rs.getString("wupin_title");
                list.add(new Orderlist(id,wupin_image,wupinId,wupin_number,buy_user,addr,delivered,orderlist_number,
                        total_cost,newDate,wupinTitle));
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
        String sql="insert into orderlist(wupin_image,wupin_id,wupin_number," +
                "buy_user,addr,is_delivered," +
                "orderlist_number,total_cost,date,wupin_title,office_name) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,orderlist.getWupinImage());
            ps.setInt(2,orderlist.getWupinId());
            ps.setInt(3,orderlist.getWupinNumber());
            //ps.setString(4,orderlist.getSellUser());
            ps.setString(4,orderlist.getBuyUser());
            ps.setString(5,orderlist.getAddr());
            ps.setInt(6,0);
            ps.setString(7,orderlist.getOrderlistNumber());
            ps.setInt(8,orderlist.getTotalCost());
            String date = orderlist.getDate();
            Integer newDate = DateUtil.stringToTimeStamp(date);
            ps.setInt(9,newDate);
            ps.setString(10,orderlist.getTitle());
            ps.setString(11,orderlist.getOffice_name());
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
                //String sellUser = rs.getString("sell_user");
                //String sellUserPhone = rs.getString("sell_user_phone");
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
                String wupinTitle = rs.getString("wupin_title");
                return new Orderlist(id,wupinImage,wupinId,wupinNumber,buyUser,addr,delivered,
                        orderlistNumber,totalCost,newDate,wupinTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close();
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
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            rs = ps.executeQuery();
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
    public List<Orderlist> queryPage(PageBean pageBean) {
        String sql="select * from orderlist limit ?,?";
        List<Orderlist>list = new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBean.getIndex());
            ps.setInt(2,pageBean.getPageCount());
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String wupin_image = rs.getString("wupin_image");
                int wupin_id = rs.getInt("wupin_id");
                int wupin_number = rs.getInt("wupin_number");
                String buy_user = rs.getString("buy_user");
                String addr = rs.getString("addr");

                //int is_delivered = rs.getInt("is_delivered");
                String is_delivered = rs.getString("is_delivered");

                String orderlist_number = rs.getString("orderlist_number");

                int total_cost = rs.getInt("total_cost");
                String date = rs.getString("date");
                String wupin_title = rs.getString("wupin_title");
                String office_name = rs.getString("office_name");
                Orderlist orderlist = new Orderlist(id, wupin_image, wupin_id, wupin_number, buy_user, addr, is_delivered, orderlist_number, total_cost, date, wupin_title, office_name);
                list.add(orderlist);
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

    }

    @Override
    public List<Orderlist> findAll() {
        String sql="select * from orderlist";
        List<Orderlist> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String wupin_image = rs.getString("wupin_image");
                Integer wupinId = rs.getInt("wupin_id");
                Integer wupin_number = rs.getInt("wupin_number");
                //String sell_user = rs.getString("sell_user");
               // Long sellUserPhone = rs.getLong("sell_user_phone");
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
                String wupinTitle = rs.getString("wupin_title");
                String office_name = rs.getString("office_name");
                list.add(new Orderlist(id,wupin_image,wupinId,wupin_number,buy_user,addr,delivered,orderlist_number,
                        total_cost,newDate,wupinTitle,office_name));
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
    public Orderlist findOneByWupinId(Integer wupinId) {
        String sql="SELECT * FROM orderlist where wupin_id=?";
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,wupinId);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String buyUser = rs.getString("buy_user");
                String wupinTitle = rs.getString("wupin_title");
                return new Orderlist(id,wupinId,buyUser,wupinTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public Integer update(Integer id) {
        String sql="update orderlist set is_delivered=? where wupin_id=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2,id);
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