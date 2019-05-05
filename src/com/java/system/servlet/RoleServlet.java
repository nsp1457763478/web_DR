package com.java.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.java.system.entity.Menu;
import com.java.system.entity.MenuRole;
import com.java.system.entity.Role;
import com.java.system.service.MenuRoleService;
import com.java.system.service.MenuService;
import com.java.system.service.RoleService;
import com.java.util.JsonUtil;
import com.java.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * author:孙琪
 * date:2019/4/28
 * time:18:07
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {

    RoleService service=new RoleService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("getAllRoleByPage".equals(action)) {
            getAllRoleByPage(request, response);
        } else if ("addRole".equals(action)) {
            addRole(request, response);
        } else if ("editRole".equals(action)) {
            editRole(request, response);
        } else if ("updateRole".equals(action)) {
            updateRole(request, response);
        } else if ("deleteRole".equals(action)) {
            deleteRole(request, response);
        } else if ("toGrant".equals(action)) {
            toGrant(request, response);
        }else if ("grant".equals(action)) {
            grant(request, response);
        }
    }
    protected void getAllRoleByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int roleCount = service.getAllRole().size();
        pageBean.setCount(roleCount);
        List<Role> roleList = service.getAllRoleByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(roleList, pageBean);
        response.getWriter().print(table);
    }
    protected void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleName = request.getParameter("roleName");
        Role role = new Role(roleName);
        int i = service.addRole(role);
        response.getWriter().print(i);
    }
    protected void editRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        Role role = service.findRoleById(Integer.parseInt(roleId));
        request.setAttribute("role", role);
        request.getRequestDispatcher("/system/Role/EditRole.jsp").forward(request, response);
    }
    protected void updateRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        String roleName = request.getParameter("roleName");
        Role role = new Role(Integer.parseInt(roleId), roleName);
        int i = service.updateRole(role);
        response.getWriter().print(i);
    }protected void deleteRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        int i = service.deleteRole(Integer.parseInt(roleId));
        response.getWriter().print(i);
    }

    protected void toGrant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        Role role = service.findRoleById(Integer.parseInt(roleId));
        request.setAttribute("role", role);

        MenuService menuService = new MenuService();
        List<Menu> menuList = menuService.getAllMenu();
        request.setAttribute("menus", menuList);

        MenuRoleService menuRoleService = new MenuRoleService();
        List<MenuRole> menuByRoleId = menuRoleService.getAllMenuByRoleId(Integer.parseInt(roleId));
        request.setAttribute("menusByRole", menuByRoleId);

        request.getRequestDispatcher("/system/Role/GrantRole.jsp").forward(request, response);
    }
    protected void grant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");
        MenuRoleService menuRoleService = new MenuRoleService();
        int del = menuRoleService.deleteMenuRoleByRoleId(Integer.parseInt(roleId));
        String ids = request.getParameter("menuIds");
        String[] menuIds = ids.split(",");
        int success = 0;
        for (int i = 0; i < menuIds.length; i++) {
            int id = Integer.parseInt(menuIds[i]);
            success += menuRoleService.addMenuRole(new MenuRole(id, Integer.parseInt(roleId)));
        }
        response.getWriter().print(success);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
