package com.java.comment.dao;


import com.java.comment.entity.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/24
 * Time: 21:49
 * Description: No Description
 */
public interface CommentDao {
    public List<Comment> findAll(Integer wupinId);
    public Integer add(Comment comment);
    public Integer report(Integer id);
    public Integer deleteOne(Integer id);


    public List<Comment> findAll();
    public List<Comment> findReport();
    public Integer deleteWupinAllComment(Integer wupinId);
}
