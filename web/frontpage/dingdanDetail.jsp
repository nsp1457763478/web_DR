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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>二货商城-订单详情</title>
    <link rel="icon" href="<%=request.getContextPath()%>/static/img/logo2.ico" type="image/x-icon"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <style>
        .confirmDescConfirmIcon{
            height:50px;
            width: 350px;
            margin-left:520px;
            border-radius:5px;
            background:lightcyan;
        }
        #realImage{
            margin-left: 270px;
        }
        #wupinImage{
            margin-right: 200px;
        }
    </style>
</head>
<body>
<!-- self_info -->
<div style="height: auto" class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">收货地址</div>
            <div class="subddzx">
                <ul>
                    <li id="addr"></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <input hidden="hidden" id="hiddenId" value="">
            <div class="ddzxbt">订单详情</div>
            购买数量:<div id="wupinNumber" style="display: inline;"></div>
            <br/><br/><br/><br/>
            商品展示:<div id="wupinImage">
            <div style="display: inline;margin-left: 260px">图片仅供参考,请以实物为准,二货商城保留所有解释权</div>
            <img src="" id="realImage" height="310px" width="350px"></div>
        </div>
        <button class="confirmDescConfirmIcon">删除该订单</button>
        <div class="clear"></div>
    </div>
</div>
<script>
        $('.confirmDescConfirmIcon').click(function() {
            $.sendConfirm({
                hideHeader: true,
                withIcon: true,
                desc: '确定要删除吗?',
                button: {
                    confirm: '确定',
                    cancel: '取消'
                },
                onConfirm: function() {
                    var id=$("#hiddenId").val();
                    $.ajax({
                        type:"post",
                        url:"<%=request.getContextPath()%>/OrderlistServlet",
                        data:{
                            "action":"deleteOne",
                            "id":id
                        },
                        dateType:"text",
                        success:function (msg) {
                            if(msg==="删除成功!"){
                                $.sendSuccessToTop(msg, 3000, function() {
                                    console.log('sendSuccessToTop closed');
                                });
                            }else{
                                $.sendWarning(msg, 3000, function() {
                                    console.log('sendWarning closed');
                                });
                            }
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

    function child(realJsonObject) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        var id=realJsonObject.id;
        var wupinNumber = realJsonObject.wupinNumber;
        var wupinImage = realJsonObject.wupinImage;
        var addr=realJsonObject.addr;
        $("#realImage").attr("src", "../static/tesiro/diamond02/"+wupinImage);
        $("#wupinNumber").html(wupinNumber);
        $("#addr").html(addr);
        $("#hiddenId").val(id);
    }
</script>
</body>
</html>
