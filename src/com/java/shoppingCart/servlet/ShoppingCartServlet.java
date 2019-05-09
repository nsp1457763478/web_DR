package com.java.shoppingCart.servlet;


import com.java.order.entity.Orderlist;
import com.java.order.service.InformationService;
import com.java.order.service.OrderlistService;
import com.java.shoppingCart.entity.ShoppingCart;
import com.java.shoppingCart.service.ShoppingCartService;
import com.java.system.service.OfficeService;
import com.java.user.entity.User;
import com.java.user.service.UserService;
import com.java.util.DateUtil;
import com.java.wupin.entity.Ershouwupin;
import com.java.wupin.service.ErshouwupinService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/26
 * Time: 9:49
 * Description: No Description
 */
@WebServlet(name = "ShoppingCartServlet",urlPatterns = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private ShoppingCartService shoppingCartService=new ShoppingCartService();
    private ErshouwupinService ershouwupinService=new ErshouwupinService();
    private OrderlistService orderlistService=new OrderlistService();
    private UserService userService=new UserService();
    private OfficeService officeService=new OfficeService();
    private InformationService informationService=new InformationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if("addShoppingCart".equals(action)){
            addShoppingCart(request,response);
        }else if("findAll".equals(action)){
            findAll(request,response);
        }else if("deleteOne".equals(action)){
            deleteOne(request,response);
        }else if("deleteAll".equals(action)){
            deleteAll(request,response);
        }else if("payed".equals(action)){
            payed(request,response);
        }
    }

    //addShoppingCart方法用于添加购物车
    private void addShoppingCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        if(username==null){
            String msg="请先登录!";
            response.getWriter().print(msg);
        }

        if(username!=null){
            String id = request.getParameter("id");
            Ershouwupin ershouwupin = ershouwupinService.queryDetail(Integer.parseInt(id));
            String image = ershouwupin.getImage();
            String title = ershouwupin.getTitle();
            Integer price = ershouwupin.getPrice();
            String date = DateUtil.dateToString(new Date(System.currentTimeMillis()));
            int i = shoppingCartService.add(new ShoppingCart(Integer.parseInt(id),username,image,title,price,date));
            if(i!=0){
                String msg="添加成功!";
                response.getWriter().print(msg);
            }else{
                String msg="请勿重复添加!";
                response.getWriter().print(msg);
            }
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        List<ShoppingCart> shoppingCartList = shoppingCartService.findAll(username);
        Integer size = shoppingCartList.size();
        Integer sum=0;
        for (ShoppingCart shoppingCart:shoppingCartList
             ) {
            Integer price = shoppingCart.getPrice();
            sum+=price;
        }
        session.setAttribute("shoppingCartList",shoppingCartList);
        session.setAttribute("sum",sum);
        session.setAttribute("size",size);
        response.sendRedirect("frontpage/gouwuche.jsp");
    }

    private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        String id = request.getParameter("id");
        int i = shoppingCartService.delete(Integer.parseInt(id), username);
        List<ShoppingCart> shoppingCartList=null;
        int size =0;
        Integer sum=0;
        if(i!=0){
            shoppingCartList = shoppingCartService.findAll(username);
            size = shoppingCartList.size();
            for (ShoppingCart shoppingCart:shoppingCartList
            ) {
                Integer price = shoppingCart.getPrice();
                sum+=price;
            }
        }
        session.setAttribute("shoppingCartList",shoppingCartList);
        session.setAttribute("sum",sum);
        session.setAttribute("size",size);
        response.getWriter().print("移除成功!");
    }

    private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username =(String) session.getAttribute("username");
        int i = shoppingCartService.deleteAll(username);
        List<ShoppingCart> shoppingCartList=null;
        int size =0;
        Integer sum=0;
        if (i!=0){
            shoppingCartList = shoppingCartService.findAll(username);
            size = shoppingCartList.size();
            for (ShoppingCart shoppingCart:shoppingCartList
            ) {
                Integer price = shoppingCart.getPrice();
                sum+=price;
            }
        }
        session.setAttribute("shoppingCartList",shoppingCartList);
        session.setAttribute("sum",sum);
        session.setAttribute("size",size);
        response.getWriter().print("清空成功!");
    }

    private void payed(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Integer sum = (Integer) session.getAttribute("sum");
        if (sum == 0) {
            response.getWriter().print("您尚未购买商品,快快去浏览吧!");
        }
        List<ShoppingCart> shoppingCartList = (List<ShoppingCart>) session.getAttribute("shoppingCartList");
        //从数据库获取到所有购物车的物品
        List<Ershouwupin> ershouwupinList = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCartList
        ) {
            Integer id = shoppingCart.getId();
            //将购物车所有商品获取到，准备生成订单
            Ershouwupin ershouwupin = ershouwupinService.queryDetail(id);
            ershouwupinList.add(ershouwupin);
        }
        //用于生成订单的list集合
        for (Ershouwupin ershouwupin : ershouwupinList
        ) {
            Integer id = ershouwupin.getId();
           // String title = ershouwupin.getTitle();
            String image = ershouwupin.getImage();
            Integer number = 1;
            String buyUser = (String) session.getAttribute("username");
            User buyuser = userService.findOne(buyUser);
            String isDelivered = "未发货";
            //生成订单号
            String listDate = DateUtil.dateToString(new Date(System.currentTimeMillis()));
            int hashCodeV = UUID.randomUUID().toString().hashCode();
            if (hashCodeV < 0) {//有可能是负数
                hashCodeV = -hashCodeV;
            }
            String str = listDate + "-" + hashCodeV;
            String orderlistNumber = str.substring(0, 29);
            //总花费
            Integer total = ershouwupin.getPrice();
            String date = DateUtil.dateToString(new Date(System.currentTimeMillis()));
            String title = ershouwupin.getTitle();
            String officeName = ershouwupin.getOffice_name();
            Orderlist orderlist = new Orderlist(image, id, number, buyUser, buyuser.getAddress(), isDelivered, orderlistNumber, total, date, title,officeName);
            orderlistService.add(orderlist);
        }
        //通知卖家发货
//        for (Ershouwupin ershouwupin : ershouwupinList
//        ) {
//            //String title = ershouwupin.getTitle();
//            String office_name = ershouwupin.getOffice_name();
//            //通过物品卖家姓名来确定给谁发通知
//            Office office = officeService.findOfficeByOfficeName(office_name);
//            //要提醒卖家发货的通知
//            String information = "您好，您上架的 " + ershouwupin.getTitle() + " 已被购买，请及时发货";
//            String newDate = DateUtil.dateToString(new Date(System.currentTimeMillis()));
//            //发送通知
//            Integer add = informationService.add(new Information(office.getOfficeId(), information, "未读", newDate));
//        }
        //将购买的商品从购物车清空
        String username = (String) session.getAttribute("username");
        shoppingCartService.deleteAll(username);
        response.getWriter().print("支付成功!请前往个人中心订单中心查看!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
