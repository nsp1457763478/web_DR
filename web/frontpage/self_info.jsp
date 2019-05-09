<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tanchuceng.jsp"%>
<%@ include file="/common/info.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DR-个人中心</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <link rel="icon" href="<%=request.getContextPath()%>/static/img/logo2.ico" type="image/x-icon"/>
</head>
<body>
<!-- start header -->
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->

<!-- self_info -->
<div class="grzxbj" style="overflow: auto">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/OrderlistServlet?action=findAll" >我的订单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/UserServlet?action=findOne&username=${sessionScope.username}" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                    <li><a href="<%=request.getContextPath()%>/InformationServlet?action=findAll">消息通知</a></li>
                    <%--<li><a href="<%=request.getContextPath()%>/ershouServlet?action=findOneSale&username=${sessionScope.username}">我的上架</a></li>--%>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">我的资料</div>
            <div class="subgrzl ml40"><span>用户id</span><span id="u_id">${requestScope.u_id}</span></div>
            <div class="subgrzl ml40"><span>用户名</span><span id="username">${requestScope.username}</span></div>
            <div class="subgrzl ml40"><span>真实姓名</span><span id="name">${requestScope.name}</span></div>
            <div class="subgrzl ml40"><span>身份证号</span><span id="id">${requestScope.id}</span></div>
            <div class="subgrzl ml40"><span>性别</span><span id="sex">${requestScope.sex}</span></div>
            <div class="subgrzl ml40"><span>手机号</span><span id="phone">${requestScope.phone}</span></div>
            <div class="subgrzl ml40"><span>邮箱</span><span id="email">${requestScope.email}</span></div>
            <div class="subgrzl ml40"><span>收货地址</span><span id="address">${requestScope.address}</span></div>
            <div class="subgrzl ml40"><span>密码</span><span id="password">${requestScope.password}</span></div>
            <div style="text-align:center">
                <button onclick="edit()" style="width: 400px;height: 50px;border-radius: 10px;background:lightcyan;">编辑个人资料</button>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div onclick="smoothscroll()" style="float: right"><img src="<%=request.getContextPath()%>/static/img/topback.png" height="40px" width="40px" title="返回顶部"></div>

<%@include file="/frontpage/footer/footer.jsp"%>
</body>
<script>
    function smoothscroll(){
        var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
        if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            window.scrollTo (0,currentScroll - (currentScroll/5));
        }
    };

    function edit() {
        var u_id=document.getElementById("u_id").innerHTML;
        var username=document.getElementById("username").innerHTML;
        var name=document.getElementById("name").innerHTML;
        var id=document.getElementById("id").innerHTML;
        var sex=document.getElementById("sex").innerHTML;
        var phone=document.getElementById("phone").innerHTML;
        var email=document.getElementById("email").innerHTML;
        var address=document.getElementById("address").innerHTML;
        var password=document.getElementById("password").innerHTML;
        var user = {
            u_id:u_id,
            username:username,
            name:name,
            id:id,
            sex:sex,
            phone: phone,
            email:email,
            address: address,
            password: password,
        };
        layer.open({
            title: this.text,
            type: 2,
            skin: 'layui-layer-rim', //加上边框
            area: [window.screen.width / 1.5 + 'px', window.screen.height / 1.5 + 'px'], //宽高
            maxmin: true, //开启最大化最小化按钮
            content: "<%=request.getContextPath()%>/frontpage/editPersonalInfo.jsp",
            success: function (layero, index) {
                // 获取子页面的iframe
                var iframe = window['layui-layer-iframe' + index];
                // 向子页面的全局函数child传参
                iframe.child(user);
            }
        })
    }
</script>
</html>

