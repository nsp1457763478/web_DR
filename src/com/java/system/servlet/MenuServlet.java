package com.java.system.servlet;

import com.alibaba.fastjson.JSONObject;
import com.java.system.entity.Menu;
import com.java.system.service.MenuService;
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
 * time:17:17
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

    MenuService service=new MenuService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if ("getAllMenuByPage".equals(action)) {
            getAllMenuByPage(request, response);
        } else if ("addMenu".equals(action)) {
            addMenu(request, response);
        } else if ("editMenu".equals(action)) {
            editMenu(request, response);
        } else if ("updateMenu".equals(action)) {
            updateMenu(request, response);
        } else if ("deleteMenu".equals(action)) {
            deleteMenu(request, response);
        } else if ("findMenuByOfficeId".equals(action)) {
            findMenuByOfficeId(request, response);
        }
    }

    protected void getAllMenuByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageBean pageBean = new PageBean();
        // 页码
        String pageIndex = request.getParameter("page");
        pageBean.setPageIndex(Integer.parseInt(pageIndex));
        // 每页条数
        String pageCount = request.getParameter("limit");
        pageBean.setPageCount(Integer.parseInt(pageCount));
        // 总条数
        int menuCount = service.getAllMenu().size();
        pageBean.setCount(menuCount);
        List<Menu> menuList = service.getAllMenuByPage(pageBean);
        JSONObject table = JsonUtil.getJsonObject(menuList, pageBean);
        response.getWriter().print(table);//table在jsonUtil.java里
    }

    protected void addMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuName = request.getParameter("menuName");
        String img = request.getParameter("img");
        String url = request.getParameter("url");
        String parentId = request.getParameter("parentId");
        Menu menu = new Menu(menuName, img, url, Integer.parseInt(parentId));
        int i = service.addMenu(menu);
        response.getWriter().print(i);
    }

    protected void editMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuId = request.getParameter("menuId");
        Menu menu = service.findMenuById(Integer.parseInt(menuId));
        request.setAttribute("menu", menu);
        request.getRequestDispatcher("/system/Menu/EditMenu.jsp").forward(request, response);
    }

    protected void updateMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuId = request.getParameter("menuId");
        String menuName = request.getParameter("menuName");
        String img = request.getParameter("img");
        String url = request.getParameter("url");
        String parentId = request.getParameter("parentId");
        Menu menu = new Menu(Integer.parseInt(menuId), menuName, img, url, Integer.parseInt(parentId));
        int i = service.updateMenu(menu);
        response.getWriter().print(i);
    }

    protected void deleteMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menuId = request.getParameter("menuId");
        int i = service.deleteMenu(Integer.parseInt(menuId));
        response.getWriter().print(i);
    }

    protected void findMenuByOfficeId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeId = request.getParameter("officeId");
        List<Menu> menuList = service.findMenuByOfficeId(Integer.parseInt(officeId));
        request.setAttribute("menuList", menuList);
        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
