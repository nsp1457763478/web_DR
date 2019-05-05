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
    List<Comment> findAll(Integer wupinId);
    Integer add(Comment comment);
    Integer report(Integer id);
    Integer deleteOne(Integer id);
}
