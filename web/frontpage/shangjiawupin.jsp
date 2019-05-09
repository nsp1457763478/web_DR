<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/5/2
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/info.jsp"%>
<html>
<head>
    <title>上架物品</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/demo.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dialog.css">
    <script src="<%=request.getContextPath()%>/static/js/jquery.dialog.js"></script>
</head>
<body>
    <!-- 文件上传时必须要设置表单的enctype="multipart/form-data"-->
    <form action="${pageContext.request.contextPath}/UploadServlet"
          method="post" enctype="multipart/form-data">
        <br><br><br/><br/>
        <div style="margin-left: 35px">
            <div>
                上传照片：
                <input type="file" name="file">
            </div>
        </div>
        <div>
            <input type="submit" style="margin-left: 170px;margin-top: 50px;width: 150px;height: 50px" value="上传">
        </div>
    </form>
</body>
</html>
