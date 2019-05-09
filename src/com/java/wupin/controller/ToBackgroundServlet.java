package com.java.wupin.controller;

import com.java.comment.entity.Comment;
import com.java.comment.service.CommentService;
import com.java.order.entity.Orderlist;
import com.java.order.service.OrderlistService;
import com.java.order.service.VisitCountService;
import com.java.user.entity.User;
import com.java.user.service.UserService;
import com.java.wupin.entity.Ershouwupin;
import com.java.wupin.service.ErshouwupinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToBackgroundServlet",urlPatterns = "/toBackground")
public class ToBackgroundServlet extends HttpServlet {
    private ErshouwupinService ershouwupinService=new ErshouwupinService();
    private UserService userService=new UserService();
    private CommentService commentService=new CommentService();
    private OrderlistService orderlistService=new OrderlistService();
    private VisitCountService visitCountService=new VisitCountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Ershouwupin> all = ershouwupinService.findAll();
        //上架物品数
        int wupinCount = all.size();
        List<User> userAll = userService.findAll();
        //注册会员数
        int userCount = userAll.size();
        List<Comment> commentAll = commentService.findAll();
        //留言总数
        int commentCount = commentAll.size();
        List<Orderlist> orderListAll = orderlistService.findAll();
        //所有订单数
        int orderListCount = orderListAll.size();
        //所有大学数
        //Integer collegeCount = userService.getCollegeCount();
        //网站访问总量
        Integer visitCount = visitCountService.getCount();
        session.setAttribute("wupinCount",wupinCount);
        session.setAttribute("userCount",userCount);
        session.setAttribute("commentCount",commentCount);
        session.setAttribute("orderListCount",orderListCount);
        //session.setAttribute("collegeCount",collegeCount);
        session.setAttribute("visitCount",visitCount);
        response.sendRedirect("background/Start.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
