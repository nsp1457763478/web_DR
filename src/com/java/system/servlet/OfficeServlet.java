package com.java.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.java.system.entity.Menu;
import com.java.system.entity.Office;
import com.java.system.entity.Role;
import com.java.system.entity.RoleOffice;
import com.java.system.service.MenuService;
import com.java.system.service.OfficeService;
import com.java.system.service.RoleOfficeService;
import com.java.system.service.RoleService;
import com.java.util.DateUtil;
import com.java.util.JsonUtil;
import com.java.util.MD5Util;
import com.java.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:18:08
 */
@WebServlet("/OfficeServlet")
public class OfficeServlet extends HttpServlet {
    OfficeService service=new OfficeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("getAllOfficeByPage".equals(action)) {
            getAllOfficeByPage(request, response);
        } else if ("addOffice".equals(action)) {
            addOffice(request, response);
        } else if ("editOffice".equals(action)) {
            editOffice(request, response);
        } else if ("updateOffice".equals(action)) {
            updateOffice(request, response);
        } else if ("deleteOffice".equals(action)) {
            deleteOffice(request, response);
        } else if ("toRole".equals(action)) {
            toRole(request, response);
        }else if ("giveOfficeAndRole".equals(action)) {
            giveOfficeAndRole(request, response);
        }else if ("findOfficeByOfficeName".equals(action)) {
            findOfficeByOfficeName(request, response);
        }

    }
    protected void getAllOfficeByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        if (pageIndex != null) {
            pageBean.setPageIndex(Integer.parseInt(pageIndex));
        }
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int userCount = service.getAllOffice().size();
        pageBean.setCount(userCount);
        List<Office> officeList = service.getAllOfficeByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(officeList, pageBean);
        response.getWriter().print(table);
    }
    protected void addOffice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeName = request.getParameter("officeName");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String degree = request.getParameter("degree");
        String officeTime = request.getParameter("officeTime");
        String password = request.getParameter("password");
        Office o = new Office(officeName,sex,Long.parseLong(phone),email,address,degree, DateUtil.formatString(officeTime,"yyyy-MM-dd"), password);
        int i = service.addOffice(o);
        response.getWriter().print(i);
    }
    protected void editOffice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        Office office = service.findOfficeById(Integer.parseInt(officeId));
        request.setAttribute("office", office);
        request.getRequestDispatcher("/system/Office/EditOffice.jsp").forward(request, response);
    }
    protected void updateOffice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        String officeName = request.getParameter("officeName");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String degree = request.getParameter("degree");
        String officeTime = request.getParameter("officeTime");
        String password = request.getParameter("password");
        String pwd=MD5Util.MD5Test(password);
        Office o = new Office(Integer.parseInt(officeId),officeName,sex,Long.parseLong(phone),email,address,degree, DateUtil.formatString(officeTime, "yyyy-MM-dd"), pwd);
        int i = service.updateOffice(o);
        response.getWriter().print(i);
    }
    protected void deleteOffice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        int i = service.deleteOffice(Integer.parseInt(officeId));
        response.getWriter().print(i);
    }
    protected void toRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        Office office = service.findOfficeById(Integer.parseInt(officeId));
        request.setAttribute("office", office);
        RoleService roleService = new RoleService();
        List<Role> roleList = roleService.getAllRole();
        request.setAttribute("roleList", roleList);
        RoleOfficeService roleOfficeService = new RoleOfficeService();
        RoleOffice roleOffice = roleOfficeService.findRoleOfficeByOfficeId(Integer.parseInt(officeId));
        request.setAttribute("roleOffice", roleOffice);
        request.getRequestDispatcher("/system/Office/GiveOfficeAndRole.jsp").forward(request, response);
    }
    protected void giveOfficeAndRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        String roleId = request.getParameter("roleId");
        RoleOfficeService roleOfficeService = new RoleOfficeService();
        int i = roleOfficeService.addRoleOffice(new RoleOffice(Integer.parseInt(officeId),Integer.parseInt(roleId)));
        response.getWriter().print(i);
    }
    protected void findOfficeByOfficeName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeName = request.getParameter("officeName");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
         //验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            //不区分大小写
            if (code.equalsIgnoreCase(sessionCode)) {
                Office office = service.findOfficeByOfficeName(officeName);
                String str = MD5Util.MD5Test(password);
                if (office == null) {
                    System.out.println("职员名 " + officeName + " 不存在");
                    // 职员名不存在
                    response.getWriter().print(202);
                } else {
                    if (office.getPassword().equals(str)) {
                        //System.out.println("职员 " + officeName + " 登录成功");
                        // 登陆成功
                        HttpSession session = request.getSession();
                        session.setAttribute("officeName", officeName);
                        session.setAttribute("office", office);
                        MenuService menuService = new MenuService();
                        List<Menu> menuList = menuService.findMenuByOfficeId(office.getOfficeId());
                        //System.out.println(menuList.toString());
                        request.getSession().setAttribute("menus", menuList);
                        response.getWriter().print(200);
                    } else {
                        // 密码错误
                        System.out.println("职员 " + officeName + " 的密码错误");
                        response.getWriter().print(201);
                    }
                }
            } else {
                response.getWriter().print(203);
            }
        } else {
            response.getWriter().println(204);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
