package com.java.comment.dao.impl;


import com.java.comment.dao.CommentDao;
import com.java.comment.entity.Comment;
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
 * Date: 2019/4/24
 * Time: 21:49
 * Description: No Description
 */
public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> findAll(Integer wupinId) {
        String sql="select * from comment where wupin_id=?";
        List<Comment> list=new ArrayList<>();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            Connection connection = JdbcUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,wupinId);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String user = rs.getString("user");
                String comment = rs.getString("comment");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                list.add(new Comment(id,wupinId,user,comment,newDate));
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
    public Integer add(Comment comment) {
        String sql="insert into comment(wupin_id,user,comment,date,is_reported) values (?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,comment.getWupinId());
            ps.setString(2,comment.getUser());
            ps.setString(3,comment.getComment());
            String date = comment.getDate();
            Integer newDate = DateUtil.stringToTimeStamp(date);
            ps.setInt(4,newDate);
            ps.setInt(5,comment.getIsReported());
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
    public Integer report(Integer id) {
        String sql="update comment set is_reported=1 where id=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
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
    public Integer deleteOne(Integer id) {
        String sql="delete from comment where id=?";
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
}
