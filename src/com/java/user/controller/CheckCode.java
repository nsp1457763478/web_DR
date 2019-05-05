package com.java.user.controller;


import com.java.order.entity.Information;
import com.java.order.service.InformationService;
import com.java.user.entity.User;
import com.java.user.service.UserService;
import com.java.util.DateUtil;
import com.java.util.JiaMi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/7
 * Time: 14:45
 * Description: No Description
 */
@WebServlet(name = "CheckCode ",urlPatterns = "/checkCode")
public class CheckCode extends HttpServlet {
    private UserService userService = new UserService();
    private InformationService informationService=new InformationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            login(request, response);
        }else if("register".equals(action)){
            register(request, response);
        }else if("logout".equals(action)){
            logout(request, response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证验证码
        boolean yanzhengma = yanzhengma(request, response);
        if (yanzhengma) {
            String username = request.getParameter("username");
            User user = userService.findOne(username);
            //用户不存在
            if (user == null) {
                String s1 = "用户名或密码错误！";
                response.getWriter().print(s1);
                //用户存在
            } else {
                //密码正确
                String password = request.getParameter("password");
                if (user.getPassword().equals(JiaMi.base64Encode(password))) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    response.getWriter().print("登陆成功！");
                    //密码错误
                } else {
                    String s2 = "用户名或密码错误！";
                    response.getWriter().print(s2);
                }
            }
            //验证码输入错误
        } else {
            String str = "验证码输入有误";
            response.getWriter().print(str);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证验证码
        boolean yanzhengma = yanzhengma(request, response);
        //验证码正确
        if(yanzhengma){
            String userName = request.getParameter("username");
            //先判断用户名是否已被注册
            User one = userService.findOne(userName);
            if(one!=null){
                response.getWriter().print("该用户已被注册！");
            }else{
                String username = request.getParameter("username");
                String name = request.getParameter("name");
                String id = request.getParameter("id");
                String sex = request.getParameter("sex");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String password = request.getParameter("password");
                String rePassWord = request.getParameter("repassword");
                //正则判断用户名是否含汉字;
                Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher matcher = pattern.matcher(userName);
                boolean isMatch = matcher.find();
                //判断密码是否小于六位
                int passwordLength = password.length();
                //判断两次密码输入是否一致
                boolean equals = password.equals(rePassWord);
                //判断输入手机号位数是否正确
                int telLength = phone.length();
                String pattern2 = "^[0-9]*[1-9][0-9]*$";
                boolean isMatch2 = Pattern.matches(pattern2, phone);
                if(isMatch){
                    response.getWriter().print("用户名不可以包含汉字！");
                }else if(passwordLength<6){
                    response.getWriter().print("密码不可以小于六位！");
                }else if(!equals){
                    response.getWriter().print("两次密码输入不一致！");
                }else if(telLength<11&&(!isMatch2)){
                    response.getWriter().print("手机号格式不正确！");
                }else{
                    User user = new User(username,name,Long.parseLong(id),sex,Long.parseLong(phone),email,address,password);
                    int i = userService.add(user);
                    if(i!=0){
                        //给用户发送祝贺注册之类的通知
                        //通过用户名来确定给谁发通知
                        User newUser = userService.findOne(userName);
                        String information="恭喜您!非常幸运成为二货大学生二手交易平台的会员，请尽情享受您的购物之旅吧!";
                        String newDate= DateUtil.dateToString(new Date(System.currentTimeMillis()));
                        //发送通知
                        Integer add = informationService.add(new Information(newUser.getU_id(),information,"未读", newDate));
                        response.getWriter().print("注册成功！");
                    }
                }
            }
        } //验证码错误
        else {
            String str="验证码输入有误";
            response.getWriter().print(str);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        response.sendRedirect("foreground/login.jsp");
    }

    public boolean yanzhengma(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            if (code.equalsIgnoreCase(sessionCode)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
