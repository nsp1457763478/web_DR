<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/10
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>王后系列</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
</head>
<body>
<!-- start header -->
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->


<!-- start banner_y -->
<!-- end banner -->

<!-- start danpin -->
<div class="danpin center">

    <div class="biaoti center">搜索关键字：${title}</div>
    <div class="main center">
        <c:if test="${size==0}">
            <script>
                $.sendWarning('很抱歉，请定制钻戒', 3000, function() {
                    console.log('sendWarning closed');
                });
            </script>
        </c:if>
        <c:if test="${size!=0}">
            <c:forEach items="${searchList}" var="list">
                <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
                    <div class="sub_mingxing"><a href="<%=request.getContextPath()%>/ershouServlet?action=queryDetail&id=${list.id}"><img src="<%=request.getContextPath()%>/image/${list.image}" height="175px" width="175px" alt=""></a></div>
                    <div class="pinpai"><a href="<%=request.getContextPath()%>/ershouServlet?action=queryDetail&id=${list.id}">${list.title}</a></div>
                    <div class="youhui">${list.introduce}</div>
                    <div class="jiage">${list.price}元</div>
                </div>
            </c:forEach>
        </c:if>
        <div class="clear"></div>
    </div>
</div>
<%@include file="/frontpage/footer/footer.jsp"%>

</body>
</html>
