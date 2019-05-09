package com.java.comment.servlet;


import com.alibaba.fastjson.JSONObject;
import com.java.comment.entity.Comment;
import com.java.comment.service.CommentService;
import com.java.util.DateUtil;
import com.java.util.JsonUtil1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/25
 * Time: 14:56
 * Description: No Description
 */
@WebServlet(name = "CommentServlet",urlPatterns = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    private CommentService commentService=new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("add".equals(action)){
            add(request,response);
        }else if("report".equals(action)){
            report(request,response);
        }else if("deleteOne".equals(action)){
            deleteOne(request,response);
        }else if("findAll".equals(action)){
            findAll(request,response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String wupinId = request.getParameter("wupinId");
        String comment = request.getParameter("comment");
        //将日期格式化成String类型
        String newDate = DateUtil.dateToString(new Date(System.currentTimeMillis()));
        int i = commentService.add(new Comment(Integer.parseInt(wupinId), username, comment, newDate,0));
        if(i!=0){
            String msg="评论成功!";
            response.getWriter().print(msg);
        }
    }

    private void report(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int i = commentService.report(Integer.parseInt(id));
        if(i!=0){
            response.getWriter().print("举报成功!");
        }
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i = commentService.deleteOne(Integer.parseInt(id));
        if(i!=0){
            response.getWriter().print("删除成功!");
        }
    }
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Comment> all = commentService.findAll();
        JSONObject jsonObject = JsonUtil1.getJsonObject(all);
        response.getWriter().print(jsonObject);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}