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
    <title>王后系列 你是我的王后</title>
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

    <div class="biaoti center"></div>

    <div class="main center">
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../static/tesiro/diamond/diamond06.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">UST YOU系列 简奢款 40分 D色</a></div>
            <div class="youhui">主钻重量: 30分 钻石颜色: G色 钻石净度: VS2 钻石切工: VG</div>
            <div class="jiage">￥16179</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../static/tesiro/diamond/diamond07.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">MY HEART系列 简奢款 100分 D色</a></div>
            <div class="youhui">主钻重量: 100分 钻石颜色: D色 钻石净度: VS2  </div>
            <div class="jiage">￥98499</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../static/tesiro/diamond02/dr03.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">MY HEART系列 浪漫款 35分 H色</a></div>
            <div class="youhui">主钻重量: 35分 钻石颜色: H色 钻石净度: SI1</div>
            <div class="jiage">￥22419</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../static/tesiro/diamond/diamond10.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">BELIEVE系列 典雅 100分 H色</a></div>
            <div class="youhui">主钻重量: 100分 钻石颜色: H色 钻石净度: VS1 钻石切工: VG</div>
            <div class="jiage">¥100999</div>
        </div>
        <div class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
            <div class="sub_mingxing"><a href=""><img src="../static/tesiro/diamond/diamond11.jpg" alt=""></a></div>
            <div class="pinpai"><a href="">JUST YOU系列 简奢款 18分 H色</a></div>
            <div class="youhui">主钻重量: 18分 钻石颜色: H色 钻石净度: SI1</div>
            <div class="jiage">¥7419</div>
        </div>
        <div class="clear"></div>
    </div>
</div>

<%@include file="/frontpage/footer/footer.jsp"%>
</body>
</html>
