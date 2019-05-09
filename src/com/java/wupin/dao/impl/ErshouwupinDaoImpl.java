package com.java.wupin.dao.impl;


import com.java.util.DateUtil;
import com.java.util.JdbcUtil;
import com.java.wupin.dao.ErshouwupinDao;
import com.java.wupin.entity.Ershouwupin;

import java.sql.*;
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
    public List<Ershouwupin> findByType(String type) {
        String sql="SELECT * FROM ershouwupin where type=?";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,type);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String image = rs.getString("image");
                Integer price = rs.getInt("price");
                Integer stock=rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                String office_name = rs.getString("office_name");
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,price,stock,introduce,newDate,click,office_name);
                list.add(ershouwupin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



    @Override
    public List<Ershouwupin> findAll() {
        String sql="SELECT * FROM ershouwupin order by date desc";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                Integer price = rs.getInt("price");
                Integer stock = rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                String office_name = rs.getString("office_name");
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,price,stock,introduce,newDate,click,office_name);
                list.add(ershouwupin);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ershouwupin> search(String title,Integer index,Integer pageCount) {
        String sql="SELECT * FROM ershouwupin WHERE title LIKE '%"+title+"%' LIMIT ?,?";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(index-1)*pageCount);
            ps.setInt(2,pageCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                title = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                Integer price = rs.getInt("price");
                Integer stock = rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                String office_name = rs.getString("introduce");
                Ershouwupin ershouwupin = new Ershouwupin(id,title,type,image,price,stock,introduce,newDate,click,office_name);
                list.add(ershouwupin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
                Integer price = rs.getInt("price");
                Integer stock = rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                String office_name = rs.getString("office_name");
                return new Ershouwupin(id,title1,type,image,price,stock,introduce,newDate,click,office_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ershouwupin> findOneSale(String office_name,Integer index,Integer pageCount) {
        String sql="SELECT * FROM ershouwupin WHERE office_name=?  LIMIT ?,?";
        Connection conn = JdbcUtil.getConnection();
        List<Ershouwupin> list=new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,office_name);
            ps.setInt(2,(index-1)*pageCount);
            ps.setInt(3,pageCount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                Integer price = rs.getInt("price");
                Integer stock = rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                office_name = rs.getString("office_name");
                list.add(new Ershouwupin(id,title1,type,image,price,stock,introduce,newDate,click,office_name));
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
    public Integer getOneSaleCount(String office_name) {
        String sql="SELECT count(*) AS count FROM ershouwupin WHERE office_name=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,office_name);
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
        String sql="update ershouwupin set title=?,type=?,image=?,price=?,stock=?,introduce=?where id=?";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            //将加密后的密码存入数据库
            ps.setString(1,ershouwupin.getTitle());
            ps.setString(2,ershouwupin.getType());
            ps.setString(3,ershouwupin.getImage());
            ps.setInt(4,ershouwupin.getPrice());
            ps.setInt(5,ershouwupin.getStock());
            ps.setString(6,ershouwupin.getIntroduce());
//            ps.setDate(7,ershouwupin.getDate());
//            ps.setInt(8,ershouwupin.getClick());
            ps.setInt(7,ershouwupin.getId());
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
    public Integer add(Ershouwupin ershouwupin) {
        String sql="insert into ershouwupin(title,type,image,price,stock,introduce,date,office_name)" +
                " values (?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            Connection conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,ershouwupin.getTitle());
            ps.setString(2,ershouwupin.getType());
            ps.setString(3,ershouwupin.getImage());
            ps.setInt(4,ershouwupin.getPrice());
            ps.setInt(5,ershouwupin.getStock());
            ps.setString(6,ershouwupin.getIntroduce());
            Integer newDate = DateUtil.stringToTimeStamp(ershouwupin.getDate());
            ps.setInt(7,newDate);
            ps.setString(8,ershouwupin.getOffice_name());
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
    public List<String> findAllType() {
        String sql="SELECT DISTINCT type FROM ershouwupin";
        Connection conn = JdbcUtil.getConnection();
        List<String> list=new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String type = rs.getString("type");
                list.add(type);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public List<Ershouwupin> findHot() {
//        String sql="SELECT * FROM ershouwupin order by click desc limit 6";
//        List<Ershouwupin> list=new ArrayList<>();
//        Connection conn = JdbcUtil.getConnection();
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Integer id = rs.getInt("id");
//                String title1 = rs.getString("title");
//                String type = rs.getString("type");
//                String image = rs.getString("image");
//                String deal = rs.getString("deal");
//                String didian = rs.getString("didian");
//                Integer price = rs.getInt("price");
//                String sellUser = rs.getString("sell_user");
//                String sellPhone = rs.getString("sell_phone");
//                String introduce = rs.getString("introduce");
//                Integer date = rs.getInt("date");
//                String newDate = DateUtil.timeStampToString(date);
//                Integer click = rs.getInt("click");
//                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,deal,didian,price,sellUser,sellPhone,introduce,newDate,click);
//                list.add(ershouwupin);
//            }
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<Ershouwupin> findNewst() {
        String sql="SELECT * FROM ershouwupin order by date desc limit 8";
        List<Ershouwupin> list=new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String title1 = rs.getString("title");
                String type = rs.getString("type");
                String image = rs.getString("image");
                Integer price = rs.getInt("price");
                Integer stock = rs.getInt("stock");
                String introduce = rs.getString("introduce");
                Integer date = rs.getInt("date");
                String newDate = DateUtil.timeStampToString(date);
                Integer click = rs.getInt("click");
                String office_name = rs.getString("office_name");
                Ershouwupin ershouwupin = new Ershouwupin(id,title1,type,image,price,stock,introduce,newDate,click,office_name);
                list.add(ershouwupin);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
