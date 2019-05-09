<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/25
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DR-支付中心</title>
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/time/jquery.tzineClock.css"/>
    <script src="<%=request.getContextPath()%>/time/jquery.tzineClock.js"></script>
    <link rel="icon" href="<%=request.getContextPath()%>/static/img/logo2.ico" type="image/x-icon"/>
</head>
<body>
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->
<div class="banner_x center">

    <div class="wdgwc fl ml40">支付界面</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li style="font-family: 'Microsoft YaHei UI';font-size: 15px">欢迎&nbsp;${sessionScope.username}&nbsp;来到支付界面</li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>
<div class="x-body" style="overflow: auto;">
        <img src="<%=request.getContextPath()%>/static/img/alipay.png" style="height: 350px">
        <div style="display: inline;margin-left: 365px;font-size: 30px">需支付:${sessionScope.sum}元</div>
        <img src="<%=request.getContextPath()%>/static/img/wechatpay.png" style="height: 350px;float: right">
        <br/>
        <div style="font-size: 20px;margin-left: 129px;display: inline">AliPay</div>
        <div style="font-size: 20px;margin-left: 1095px;display: inline">WechatPay</div>
        <div class="fancyClock" data-time="2100-04-27 14:59:00" data-type="time" id="fancyClock1" style=""></div>
        <div style="text-align:center">
            <button onclick="payed()" style="width: 400px;height: 50px;border-radius: 10px;background:lightcyan;">我已支付</button>
        </div>
</div>
<div onclick="smoothscroll()" style="float: right"><img src="<%=request.getContextPath()%>/static/img/topback.png" height="40px" width="40px" title="返回顶部"></div>
<!-- footer -->
<%@include file="/frontpage/footer/footer.jsp"%>
<script>
    function smoothscroll(){
        var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
        if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            //可以调整回到顶部动画的速度(或者说时间)
            window.scrollTo (0,currentScroll - (currentScroll/5));
        }
    };

    function payed(){
        $.ajax({
            type:"post",
            url:"<%=request.getContextPath()%>/ShoppingCartServlet",
            data:{
                "action":"payed"
            },
            dateType:"text",
            success:function (msg) {
                if(msg==="支付成功!请前往个人中心订单中心查看!"){
                    // $.sendSuccessToTop(msg,3000, function() {
                    //     console.log('sendSuccessToTop closed');
                    // });
                   alert(msg);
                }else if(msg==="您尚未购买商品,快快去浏览吧!"){
                    // $.sendWarningToTop(msg,3000, function() {
                    //     console.log('sendWarningToTop closed');
                    // });
                    alert(msg);
                }
            }
        });
    }

    $('#fancyClock1').tzineClock({
        colors : ['circle3','circle4'],
        words : ['分钟','秒'],
    });
</script>
</body>
</html>