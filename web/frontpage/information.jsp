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
    <title>二货商城-通知中心</title>
    <link rel="icon" href="<%=request.getContextPath()%>/image/logo2.ico" type="image/x-icon"/>
</head>
<body>
<!-- start header -->
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->

<!-- self_info -->
<div style="height: auto;overflow: auto" class="grzxbj">
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
                    <li><a href="<%=request.getContextPath()%>/ershouServlet?action=findOneSale&username=${sessionScope.username}">我的上架</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">通知中心</div>
            <c:if test="${requestScope.sizezxc==0}">
                <div style="margin-left: 320px;margin-top: 150px;font-family: 'Microsoft YaHei UI';font-size: 20px">还没有任何通知^^,快去浏览商品吧!</div>
                <br/>
                <img style="margin-left: 450px" src="<%=request.getContextPath()%>/image/laugh.gif" height="80px" width="80px">
            </c:if>
            <c:forEach items="${requestScope.informationList}" var="list">
                <div class="ddxq">
                    <div class="fl">#${list.id}</div>
                    <div class="ddbh fl">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                            <%--判断消息已读或未读--%>
                        状态:<c:if test="${list.isRead=='未读'}">
                            <div style="display: inline;color: red">${list.isRead}</div>
                        </c:if>
                        <c:if test="${list.isRead=='已读'}">
                            <div style="display: inline;color: black">${list.isRead}</div>
                        </c:if>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        通知时间:${list.date}
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        通知类型:&nbsp;&nbsp;&nbsp;系统通知
                    </div>
                    <div class="ztxx fr">
                        <ul>
                            <li><c:if test="${list.content.length()>6}">
                                ${list.content.substring(0, 6)}...
                            </c:if></li>
                            <li><a href="InformationServlet?action=findOne&id=${list.id}">通知详情></a></li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
            <div style="margin-left: 370px;margin-top: 40px">
                <c:if test="${requestScope.sizezxc>0}">
                    <a href="InformationServlet?action=findAll&index=1">首页</a>
                    <c:if test="${requestScope.index!=1}">
                        <a href="InformationServlet?action=findAll&index=${requestScope.index-1}">上一页</a>
                    </c:if>
                    <c:if test="${requestScope.index==1}">
                        <a style="color:#3f86ff">到顶啦</a>
                    </c:if>
                    <c:forEach var="i" begin="1" step="1" end="${requestScope.end}">
                        <a href="InformationServlet?action=findAll&index=${i}">【${i}】</a>
                    </c:forEach>
                    <c:if test="${requestScope.index<requestScope.end}">
                        <a href="InformationServlet?action=findAll&index=${requestScope.index+1}">下一页</a>
                    </c:if>
                    <c:if test="${requestScope.index==requestScope.end}">
                        <a style="color:#3f86ff">到底啦</a>
                    </c:if>
                    <a href="InformationServlet?action=findAll&index=${requestScope.end}">尾页</a>
                    <div style="display: inline;margin-left: 230px">当前页:第${requestScope.index}页</div>
                </c:if>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div onclick="smoothscroll()" style="float: right"><img src="<%=request.getContextPath()%>/image/topback.png" height="40px" width="40px" title="返回顶部"></div>

<%@include file="/frontpage/footer/footer.jsp"%>
<script>
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

