<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/28
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>二货商城-通知详情</title>
    <link rel="icon" href="<%=request.getContextPath()%>/image/logo2.ico" type="image/x-icon"/>
    <style>
        #read{
            height: 40px;
            width: 200px;
            border-radius: 100px;
            background:lightcyan;
        }
        #delete{
            height: 40px;
            width: 200px;
            border-radius: 100px;
            background:lightcyan;
        }
    </style>
</head>
<body>
<!-- start header -->
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->

<!-- self_info -->
<div style="height: auto" class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/OrderlistServlet?action=findAll">我的订单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="<%=request.getContextPath()%>/UserServlet?action=findOne&username=${sessionScope.username}">我的个人中心</a></li>
                    <li><a href="<%=request.getContextPath()%>/InformationServlet?action=findAll" style="color:#ff6700;font-weight:bold;">消息通知</a></li>
                    <li><a href="">我的上架</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">通知详情</div>
                <div class="ddxq">
                    <input hidden="hidden" id="informationId" value="${requestScope.information.id}">
                    <div style="display: inline;">#${requestScope.information.id}</div>
                    <div style="display: inline;margin-left: 360px">通知类型:<div style="display: inline;color:red">系统通知</div></div>
                    <div style="display: inline;margin-left: 170px">通知时间:${requestScope.information.date}</div>
                    <div style="display: inline;">【通知内容】</div>
                    <div style="display: inline;">${requestScope.information.content}</div>
                    <div style="display: inline;margin-left: 730px">二货商城官方团队致上</div>
                    <div style="display: inline;margin-left: 220px"><button id="read" onclick="read()">我了解了</button></div>
                    <div style="display: inline;margin-left: 80px"><button id="delete" class="confirmMsgConfirmCancel">删除此通知</button></div>
                    </div>
                    <div class="ztxx fr">
                        <ul>
                            <li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div onclick="smoothscroll()" style="float: right"><img src="<%=request.getContextPath()%>/image/topback.png" height="40px" width="40px" title="返回顶部"></div>

<%@include file="/frontpage/footer/footer.jsp"%>
<script>
    function read() {
        var id = $("#informationId").val();
        $(window).attr('location','InformationServlet?action=update&id='+id);
    }

    $('.confirmMsgConfirmCancel').click(function() {
        $.sendConfirm({
            hideHeader: true,
            withCenter: true,
            msg: '确定删除此条通知吗？',
            button: {
                confirm: '确认',
                cancel: '取消'
            },
            onConfirm: function() {
                var id = $("#informationId").val();
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/InformationServlet",
                    data:{
                        "action":"delete",
                        "id":id
                    },
                    dateType:"text",
                    success:function (msg) {
                        $.sendSuccessToTop(msg,3000, function() {
                            console.log('sendSuccessToTop closed');
                        });
                        window.setTimeout("$(window).attr('location','InformationServlet?action=findAll');",3000);
                    }
                });
            },
            onCancel: function() {
                console.log('点击取消！');
            },
            onClose: function() {
                console.log('点击关闭！');
            }
        });
    });

    function smoothscroll(){
        var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
        if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            window.scrollTo (0,currentScroll - (currentScroll/5));
        }
    }
</script>
</body>
</html>

