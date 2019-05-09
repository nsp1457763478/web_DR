package com.java.order.dao.impl;

import com.java.order.dao.VisitCountDao;
import com.java.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitCountDaoImpl implements VisitCountDao {
    @Override
    public Integer getCount() {
        String sql="select * from visit_count";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer count = rs.getInt("count");
                return count;
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
        return 0;
    }

    @Override
    public Integer update(Integer count) {
        String sql="update visit_count set count=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,count+1);
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