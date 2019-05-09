package com.java.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.java.user.entity.User;
import com.java.user.service.UserService;
import com.java.util.JiaMi;
import com.java.util.JsonUtil;
import com.java.util.PageBean;
import com.java.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author : liuxulong
 * date : 9:45 2019/4/30
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService service=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if("findOne".equals(action)){
            findOne(request,response);
        }else if("update".equals(action)){
            update(request,response);
        }else if("query".equals(action)){
            query(request,response);
        }else if("queryOne".equals(action)){
            queryOne(request,response);
        }else if("delete".equals(action)){
            delete(request,response);
        }
    }

    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = service.findOne(username);
        Integer u_id = user.getU_id();
        String name = user.getName();
        long id = user.getId();
        String sex = user.getSex();
        long phone = user.getPhone();
        String email = user.getEmail();
        String address = user.getAddress();
        String password = user.getPassword();
        String psd = JiaMi.base64Decode(password);
        request.setAttribute("u_id",u_id);
        request.setAttribute("username",username);
        request.setAttribute("name",name);
        request.setAttribute("id",id);
        request.setAttribute("sex",sex);
        request.setAttribute("phone",phone);
        request.setAttribute("email",email);
        request.setAttribute("address",address);
        request.setAttribute("password",psd);
        request.getRequestDispatcher("frontpage/self_info.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        //验证手机号格式
        int telLength = phone.length();
        String pattern2 = "^[0-9]*[1-9][0-9]*$";
        boolean isMatch = Pattern.matches(pattern2, phone);
        //判断密码是否小于六位
        int passwordLength = password.length();
        //收货地址不能为空
        int addrLength = address.length();
        if((telLength<11)||!isMatch){
            response.getWriter().print("手机号格式不正确!");
        }else if(passwordLength<6){
            response.getWriter().print("密码不可以小于六位!");
        }else if(addrLength==0||address.equals("")){
            response.getWriter().print("收货地址不能为空!");
        }else{
            User user = new User();
            user.setU_id(Integer.parseInt(u_id));
            user.setUsername(username);
            user.setName(name);
            user.setId(Long.parseLong(id));
            user.setSex(sex);
            user.setPhone(Long.parseLong(phone));
            user.setEmail(email);
            user.setAddress(address);
            user.setPassword(password);
            Integer i = service.update(user);
            if(i!=0){
                response.getWriter().print("更新资料成功!");
            }
        }
    }
    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        PageBean pageBean = new PageBean();
        pageBean.setPageIndex(Integer.parseInt(page));
        pageBean.setPageCount(Integer.parseInt(limit));
        pageBean.setCount(service.findAll().size());
        List<User> users = service.queryPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(users, pageBean);
        response.getWriter().print(table);
    }
    protected void queryOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("u_id");
        User users = service.queryOne(Integer.parseInt(uid));
        request.setAttribute("users",users);
        request.getRequestDispatcher("user/xiangqing.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid= request.getParameter("u_id");
        int linkId=-1;
        if (!StringUtil.isEmpty(uid)){
            linkId= Integer.parseInt(uid);
        }
        int i = service.delete(linkId);
        response.getWriter().print(""+i);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
