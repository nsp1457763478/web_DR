<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/8
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/tanchuceng.jsp"%>
<%@ include file="../common/info.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DR-物品详情</title>
    <link rel="icon" href="<%=request.getContextPath()%>/static/img/logo2.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <style>
        .confirmDescConfirmIcon {
            height: 50px;
            width: 120px;
            margin-left: 720px;
            border-radius: 5px;
            background: lightcyan;
        }
        .update {
            height: 50px;
            width: 120px;
            margin-left: 250px;
            border-radius: 5px;
            background: lightcyan;
        }
        .deliver {
            height: 50px;
            width: 120px;
            margin-left: 630px;
            margin-bottom: 30px;
            border-radius: 5px;
            background: lightcyan;
        }

        #realImage {
            margin-left: 270px;
            display: inline;
        }
    </style>
</head>
<body>
<!-- self_info -->
<div style="height: auto" class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">上架日期</div>
            <div class="subddzx">
                <ul>
                    <li id="date"></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <input hidden="hidden" id="hiddenId" value="">
            <div class="ddzxbt">物品详情</div>
            名称:
            <div id="title" style="display: inline;"></div><br/>
            分类:
            <div id="type" style="display: inline;"></div><br/>
            价格:
            <div id="price" style="display: inline;"></div>
            <br/>
            商品展示:
            <div id="display">
                <img src="" id="realImage" height="310px" width="350px"></div>
            商品介绍:
            <div id="introduce" style="display: inline;"></div>
        </div>
        <button class="deliver" onclick="deliver()">我已发货</button>
        <div class="clear"></div>
    </div>
</div>
<script>
    var object1;
    function child(realJsonObject) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        object1=realJsonObject;
        var id = realJsonObject.id;
        var title= realJsonObject.title;
        var type= realJsonObject.type;
        var image = realJsonObject.image;
        var price = realJsonObject.price;
        var introduce = realJsonObject.introduce;
        var date = realJsonObject.date;
        $("#hiddenId").val(id);
        $("#title").html(title);
        $("#type").html(type);
        $("#realImage").attr("src", "../image/" + image);
        $("#price").html("￥" + price);
        $("#introduce").html(introduce);
        $("#date").html(date);
    }

    //已发货，并通知买家
    function deliver() {
        var id = $("#hiddenId").val();
        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/ershouServlet",
            data: {
                "action": "delivered",
                "id": id
            },
            dateType: "text",
            success: function (msg) {
                if (msg === "已发货,请注意买家动态!") {
                    alert(msg);
                } else if(msg === "通知买家失败!"){
                    alert(msg);
                }
            }
        });
    }
</script>
</body>
</html>