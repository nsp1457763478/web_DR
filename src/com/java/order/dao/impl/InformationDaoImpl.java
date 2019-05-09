package com.java.order.dao.impl;


import com.java.order.entity.Information;
import com.java.order.dao.InformationDao;
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
 * Date: 2019/4/28
 * Time: 14:32
 * Description: No Description
 */
public class InformationDaoImpl implements InformationDao {
    @Override
    public List<Information> findAll(Integer uId, Integer index, Integer pageCount) {
        String sql="select * from information where u_id=? order by date desc limit ?,?";
        List<Information> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,uId);
            ps.setInt(2,(index-1)*pageCount);
            ps.setInt(3,pageCount);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String content = rs.getString("content");
                Integer isRead = rs.getInt("is_read");
                String read=null;
                if(isRead==0){
                    read="未读";
                }else {
                    read="已读";
                }
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new Information(id,uId,content,read,newDate));
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
    public Integer add(Information information) {
        String sql="insert into information(u_id,content,is_read,date) values (?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,information.getuId());
            ps.setString(2,information.getContent());
            String isRead = information.getIsRead();
            ps.setInt(3,0);
            Integer newDate = DateUtil.stringToTimeStamp(information.getDate());
            ps.setInt(4,newDate);
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
    public Integer update(Integer id) {
        String sql="update information set is_read=? where id=?";
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

    @Override
    public Integer delete(Integer id) {
        String sql="delete from information where id=?";
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
    public Integer deleteAll(Integer uId) {
        return null;
    }

    @Override
    public Information findOne(Integer id) {
        String sql="SELECT * FROM information where id=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer uId = rs.getInt("u_id");
                String content = rs.getString("content");
                Integer isRead = rs.getInt("is_read");
                String read=null;
                if(isRead==0){
                    read="未读";
                }else if(isRead==1){
                    read="已读";
                }
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                return new Information(id,uId,content,read,newDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getCount(Integer uId) {
        String sql="SELECT count(*) AS count FROM information where u_id=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,uId);
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
