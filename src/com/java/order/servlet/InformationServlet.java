package com.java.order.servlet;


import com.java.order.entity.Information;
import com.java.order.service.InformationService;
import com.java.user.entity.User;
import com.java.user.service.UserService;
import com.java.util.DateUtil;

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
 * Date: 2019/4/28
 * Time: 11:52
 * Description: No Description
 */
@WebServlet(name = "InformationServlet",urlPatterns = "/InformationServlet")
public class InformationServlet extends HttpServlet {
    private InformationService informationService=new InformationService();
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("findAll".equals(action)){
            findAll(request,response);
        }else if("findOne".equals(action)){
            findOne(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }else if("informaionToAll".equals(action)){
            informaionToAll(request,response);
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        Integer pageCount=3;
        String index = request.getParameter("index");
        if(index==null){
            index="1";
        }
        User user = userService.findOne(username);
        Integer count = informationService.getCount(user.getU_id());
        List<Information> informationList = informationService.findAll(user.getU_id(),Integer.parseInt(index),pageCount);
        Integer size = informationList.size();
        Integer pages=(count+pageCount-1)/pageCount;
        request.setAttribute("informationList",informationList);
        request.setAttribute("end",pages);
        request.setAttribute("index",Integer.parseInt(index));
        request.setAttribute("sizezxc",size);
        request.getRequestDispatcher("frontpage/information.jsp").forward(request,response);
    }

    private void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Information information = informationService.findOne(Integer.parseInt(id));
        request.setAttribute("information",information);
        request.getRequestDispatcher("frontpage/informationDetail.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        informationService.update(Integer.parseInt(id));
        findAll(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i = informationService.delete(Integer.parseInt(id));
        if(i!=0){
            response.getWriter().print("删除成功!");
        }
    }
    private void informaionToAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        List<User> userAll = userService.findAll();
        String newDate = DateUtil.dateToString(new Date(System.currentTimeMillis()));
        for (User user:userAll
        ) {
            informationService.add(new Information(user.getU_id(),content,"未读",newDate));
        }
        response.getWriter().print("发送成功!");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
