package com.java.comment.service;


import com.java.comment.dao.CommentDao;
import com.java.comment.dao.impl.CommentDaoImpl;
import com.java.comment.entity.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/24
 * Time: 21:56
 * Description: No Description
 */
public class CommentService {
    private CommentDao commentDao=new CommentDaoImpl();
    public List<Comment> findAll(Integer wupinId){
        return commentDao.findAll(wupinId);
    }
    public int add(Comment comment){
        return commentDao.add(comment);
    }
    public int report(Integer id){
        return commentDao.report(id);
    }
    public Integer deleteOne(Integer id){
        return commentDao.deleteOne(id);
    }
}
