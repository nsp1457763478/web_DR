package com.java.order.servlet;

import com.alibaba.fastjson.JSONObject;
import com.java.order.entity.Orderlist;
import com.java.order.service.OrderlistService;

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
 * Date: 2019/4/27
 * Time: 17:06
 * Description: No Description
 */
@WebServlet(name = "OrderlistServlet",urlPatterns = "/OrderlistServlet")
public class OrderlistServlet extends HttpServlet {
    private OrderlistService orderlistService=new OrderlistService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("findOne".equals(action)){
            findOne(request,response);
        }else if("deleteOne".equals(action)){
            deleteOne(request,response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        Integer pageCount=3;
        String index = request.getParameter("index");
        if(index==null){
            index="1";
        }
        List<Orderlist> orderlist = orderlistService.findAll(username,Integer.parseInt(index),pageCount);
        Integer size = orderlist.size();
        Integer count =orderlistService.getCount(username);
        Integer pages=(count+pageCount-1)/pageCount;
        request.setAttribute("orderlist",orderlist);
        request.setAttribute("end",pages);
        request.setAttribute("sizezxc",size);
        request.setAttribute("index",Integer.parseInt(index));
        request.getRequestDispatcher("frontpage/dingdanzhongxin.jsp").forward(request,response);
    }

    private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Orderlist orderlist = orderlistService.findOne(Integer.parseInt(id));
        Object jsonObject = JSONObject.toJSON(orderlist);//将java对象转换为json对象
//        String str = json.toString();//将json对象转换为字符串
        //返回json对象，通过js解析并传递给子页面
        response.getWriter().print(jsonObject);
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i = orderlistService.deleteOne(Integer.parseInt(id));
        if (i!=0){
            response.getWriter().print("删除成功!");
        }else{
            response.getWriter().print("删除失败,订单可能不存在!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
