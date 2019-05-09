<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/7
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员登录</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/login1.css">
</head>
<body>
<!-- login -->
<div class="top center">
    <div class="logo center">
        <a href="GoIndexServlet"><img src="<%=request.getContextPath()%>/static/tesiro/logo/logo2.jpg" alt=""></a>
    </div>
</div>
<div class="form center">
    <input type="hidden"  name="action" value="login">
    <div class="login">
        <div class="login_center">
            <div class="login_top">
                <div class="left fl">快速登录</div>
                <div class="right fr">还没有账号><a href="<%=request.getContextPath()%>/frontpage/register.jsp" target="_self">立即注册</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="login_main center">
                <div class="username">用户名:&nbsp;<input class="shurukuang" type="text" id="username" name="username" placeholder="请输入你的用户名"/></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" id="password" name="password" placeholder="请输入你的密码"/></div>
                <div class="username">
                    <div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" id="code" name="code" placeholder="请输入验证码"/></div>
                    <div class="right fl"><img id="imgObj" alt="验证码" onclick="changeThis()" src="${pageContext.request.contextPath}/getCode"></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="login_submit">
                <input onclick="login()" class="submit" type="button" value="立即登录" >
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function changeThis(){
        //再访问一次验证码的Servlet
        //把img的src属性
        var imgObject=$("#imgObj");
        imgObject.attr("src","${pageContext.request.contextPath}/getCode"+newUrl());
    }
    function newUrl(){
        var timestamp = (new Date()).valueOf();
        var url = "?timestamp="+timestamp;
        return url;
    }

    function login() {
        var username=document.getElementById("username").value;
        var password=document.getElementById("password").value;
        var code=document.getElementById("code").value;
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/checkCode",
            data:"action=login&username="+username+"&password="+password+"&code="+code,
            dateType:"text",
            success:function (msg) {
                if(msg!="登陆成功！"){
                    $.sendWarning(msg, 3000, function() {
                        console.log('sendWarning closed');
                    });
                }else{
                    $.sendSuccessToTop('登陆成功！', 3000, function() {
                        console.log('sendSuccessToTop closed');
                    });
                    window.setTimeout("window.location='../goIndex.jsp'",3000);
                }
            }
        });
    }
</script>
</html>
