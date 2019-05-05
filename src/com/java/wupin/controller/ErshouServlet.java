package com.java.wupin.controller;


import com.alibaba.fastjson.JSON;
import com.java.comment.entity.Comment;
import com.java.comment.service.CommentService;
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

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/10
 * Time: 23:48
 * Description:  search方法用于处理在搜索框中输入的信息
 *               queryDetail方法用于处理选中某一件商品时展示详情
 *               addShoppingCart方法用于添加购物车
 */
@WebServlet(name = "ErshouServlet",urlPatterns = "/ershouServlet")
public class ErshouServlet extends HttpServlet {
    private ErshouwupinService ershouwupinService=new ErshouwupinService();
    private CommentService commentService=new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("search".equals(action)){
            search(request,response);
        }else if("queryDetail".equals(action)){
            queryDetail(request,response);
        }else if("findOneSale".equals(action)){
            findOneSale(request,response);
        }else if("findOne".equals(action)){
            findOne(request,response);
        }else if("deleteOne".equals(action)){
            deleteOne(request,response);
        }
    }

    //queryDetail方法用于处理选中某一件商品时展示详情
    private void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String wupinId = request.getParameter("wupinId");
        Ershouwupin ershouwupin = ershouwupinService.queryDetail(Integer.parseInt(wupinId));
        //查询某个商品所有的评论信息
        List<Comment> commentList = commentService.findAll(Integer.parseInt(wupinId));
        request.setAttribute("ershouwupin",ershouwupin);
        request.setAttribute("commentList",commentList);
        request.getRequestDispatcher("frontpage/xiangqing.jsp").forward(request,response);
    }

    //search方法用于处理在搜索框中输入的信息
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageCount=5;
        String index = request.getParameter("index");
        if(index==null){
            index="1";
        }
        String title = request.getParameter("title");
        List<Ershouwupin> searchList = ershouwupinService.search(title,Integer.parseInt(index),pageCount);
        Integer count = ershouwupinService.getCount(title);
        Integer size = searchList.size();
        Integer pages=(count+pageCount-1)/pageCount;
        request.setAttribute("end",pages);
        request.setAttribute("index",Integer.parseInt(index));
        request.setAttribute("searchList",searchList);
        request.setAttribute("title",title);
        request.setAttribute("size",size);
        request.getRequestDispatcher("frontpage/search.jsp").forward(request,response);
    }

    private void findOneSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageCount=3;
        String index = request.getParameter("index");
        if(index==null){
            index="1";
        }
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        Integer count = ershouwupinService.getOneSaleCount(username);
        List<Ershouwupin> mySaleList = ershouwupinService.findOneSale(username,Integer.parseInt(index),pageCount);
        int size = mySaleList.size();
        int pages=(count+pageCount-1)/pageCount;
        request.setAttribute("end",pages);
        request.setAttribute("index",Integer.parseInt(index));
        request.setAttribute("mySaleList",mySaleList);
        request.setAttribute("sizezxc",size);
        request.getRequestDispatcher("frontpage/shangjia.jsp").forward(request,response);
    }

    private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Ershouwupin ershouwupin = ershouwupinService.queryDetail(Integer.parseInt(id));
        Object JsonObject = JSON.toJSON(ershouwupin);
        response.getWriter().print(JsonObject);
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i = ershouwupinService.delete(Integer.parseInt(id));
        if(i!=0){
            response.getWriter().print("下架成功!");
        }else{
            response.getWriter().print("下架失败,物品可能已被下架或购买!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}