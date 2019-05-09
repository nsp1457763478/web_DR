package com.java.wupin.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "UploadServlet", urlPatterns = "/UploadServlet")
//使用注解@MultipartConfig将一个Servlet标识为支持文件上传
@MultipartConfig//标识Servlet支持文件上传
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //存储路径
        //String savePath = "E:\\IntelliJ IDEA 2018.2.1\\workspace\\ershoujiaoyi\\web\\image\\";
        String savePath = "F:\\IdeaProjects\\three\\DR\\web\\image";
        //获取上传的文件集合
        Collection<Part> parts = request.getParts();
        //上传单个文件
        //Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
        //Part part = parts[0];//从上传的文件集合中获取Part对象
        Part part = request.getPart("file");//通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
        //Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
        //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
        String header = part.getHeader("content-disposition");
        //获取文件名
        String fileName = getFileName(header);
        request.setAttribute("fileName", fileName);
        request.getSession().setAttribute("fileName", fileName);
        //把文件写到指定路径
        part.write(savePath + File.separator + fileName);
        request.getRequestDispatcher("frontpage/shangjiawupin2.jsp").forward(request, response);
    }

    /**
     * 根据请求头解析出文件名
     * 请求头的格式：火狐和google浏览器下：form-data; name="file"; filename="snmp4j--api.zip"
     * IE浏览器下：form-data; name="file"; filename="E:\snmp4j--api.zip"
     *
     * @param header 请求头
     * @return 文件名
     */
    public String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
         *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
        return fileName;
    }

    private void uploadErshouwupin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("selectType");
        String deal = request.getParameter("deal");
        String didian = request.getParameter("didian");
        String price = request.getParameter("price");
        String sellUser = request.getParameter("sellUser");
        String sellPhone = request.getParameter("sellPhone");
        String introduce = request.getParameter("introduce");
        System.out.println(title);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
