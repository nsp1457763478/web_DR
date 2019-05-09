<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/3/12
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>男士一生仅能定制一枚</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">

</head>
<!-- start header -->
<%@include file="/frontpage/head/header.jsp"%>
<!--end header -->
<div class="main center">
  <jsp:include page="/frontpage/banner/banner.jsp"/>
</div>

<!-- start banner_y -->
<div class="banner_y center">


</div>

<div class="sub_banner center">
  <div class="sidebar fl">
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot01.png"></a></div>
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot03.png"></a></div>
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot05.png"></a></div>
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot07.png"></a></div>
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot09.png"></a></div>
    <div class="fl"><a href=""><img src="/static/tesiro/hot/hot08.png"></a></div>
    <div class="clear"></div>
  </div>
  <div class="datu fl"><a href=""><img src="/static/tesiro/head/head001.jpg" alt=""></a></div>
  <div class="datu fl"><a href=""><img src="/static/tesiro/head/head006.jpg" alt=""></a></div>
  <div class="datu fr"><a href=""><img src="/static/tesiro/head/head02.jpg" alt=""></a></div>
  <div class="clear"></div>

</div>
<!-- end banner -->

<!-- start danpin -->
<div class="danpin center">

  <div class="biaoti center">明星推荐</div>

</div>
<div class="peijian w">
  <div class="biaoti center">浪漫钻戒 为爱定制</div>
  <div class="main center">
    <div class="content">
      <div class="remen fl"><a href=""><img src="/static/tesiro/static/static003.png"></a></div>
      <c:forEach items="${requestScope.newstList}" var="newst">
        <div class="remen fl">
          <div class="xinpin"><span>新品</span></div>
          <div class="tu"><a href="<%=request.getContextPath()%>/ershouServlet?action=queryDetail&id=${newst.id}"><img src="image/${newst.image}" height="150px" width="150px"></a></div>
          <div class="miaoshu"><a href="<%=request.getContextPath()%>/ershouServlet?action=queryDetail&id=${newst.id}">${newst.title}</a></div>
          <div class="jiage">￥${newst.price}</div>
          <div class="piao">
            <span>${newst.introduce}</span>
          </div>
        </div>
      </c:forEach>
      <div class="remenlast fr">
        <div class="hongmi"><a href=""><img src="/static/tesiro/static/ring09.png" alt=""></a></div>
        <div class="liulangengduo"><a href=""><img src="/static/tesiro/static/ring11.png" alt=""></a></div>
      </div>
      <div class="clear"></div>
    </div>
  </div>
</div>
<%@include file="frontpage/footer/footer.jsp"%>
</body>
</html>
