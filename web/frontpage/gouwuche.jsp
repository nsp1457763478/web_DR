<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/8
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的购物车-通灵珠宝</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/style.css">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/image/logo.png" type="image/x-icon" />
</head>
<body>
<!-- start header -->
<jsp:include page="../frontpage/head/header.jsp"/>
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="../index.jsp"><div class="logo fl"></div></a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <div class="dlzc fr">
        <ul>
            <li style="font-family: 'Microsoft YaHei UI';font-size: 15px">欢迎&nbsp;${sessionScope.username}&nbsp;来到购物车界面</li>
        </ul>
    </div>
    <div class="clear"></div>
</div>
<div class="xiantiao"></div>

<div class="gwcxqbj">
    <div class="gwcxd center">
        <table>
            <tr>
                <div class="top2 center">
                    <div class="sub_top fl">
                        商品缩略图
                    </div>
                    <div class="sub_top fl">商品名称</div>
                    <div class="sub_top fl">价格</div>
                    <div class="sub_top fl">数量</div>
                    <div class="sub_top fl">小计</div>
                    <div class="sub_top fr">操作</div>
                    <div class="clear"></div>
                </div>
            </tr>
        <tr>
            <input hidden="hidden" id="shoppingCartList" type="text" value="${sessionScope.shoppingCartList}">
            <c:if test="${sessionScope.size!=0}">
                <c:forEach items="${sessionScope.shoppingCartList}" var="list">
                    <div class="content2 center">
                        <div class="sub_content fl ">
                        </div>
                        <div class="sub_content fl"><img src="../tesiro/diamond02/${list.image}" height="80" width="80;" style="margin-top: 20px;margin-right: 100px"></div>
                        <div class="sub_content fl ft20">${list.title}</div>
                        <div class="sub_content fl ">&nbsp;￥${list.price}</div>
                        <div class="sub_content fl ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1</div>
                        <div class="sub_content fl ">&nbsp;&nbsp;${list.price}</div>
                        <div class="sub_content fl"><button class="confirmDescConfirmIconWarning" id="${list.id}"
                                                            style="line-height: 20px;margin-top: 40px;margin-right: 10px;font-size: 17px">删除</button>
                        </div>
                        <div class="clear"></div>
                    </div>
                </c:forEach>
            </c:if>
        </tr>
            <c:if test="${sessionScope.size==0}">
                <script>
                    $.sendWarning('购物车空空如也,快去挑选心仪的商品吧!', 3000, function() {
                        console.log('sendWarning closed');
                    });
                </script>
            </c:if>
        </table>
    </div>
    <div class="jiesuandan mt20 center">
        <div class="tishi fl ml20">
            <ul>
                <li><a href="<%=request.getContextPath()%>/index.jsp">继续购物</a></li>
                <li>|</li>
                <li>共<span>${sessionScope.shoppingCartList.size()}</span>件商品</li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="jiesuan fr">
            <div class="jiesuanjiage fl">合计（不含运费）：<span id="total">￥${sessionScope.sum}</span></div>
            <div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan" onclick="buy()" style="width: 120px"  value="去结算"/>&nbsp;&nbsp;&nbsp;<input id="confirmDescConfirmIcon" class="jsan" type="submit" name="jiesuan" style="width: 120px"  value="清空购物车"/></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<div onclick="smoothscroll()" style="float: right"><img src="<%=request.getContextPath()%>/image/topback.png" height="40px" width="40px" title="返回顶部"></div>

<!-- footer -->
<%@include file="/frontpage/footer/footer.jsp"%>
<script>
    function smoothscroll(){
        var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
        if (currentScroll > 0) {
            window.requestAnimationFrame(smoothscroll);
            window.scrollTo (0,currentScroll - (currentScroll/5));
        }
    }

    $('.confirmDescConfirmIconWarning').click(function() {
        var realId=this.id;
        $.sendConfirm({
            hideHeader: true,
            withIcon: 'withIconWarning',
            desc: '确定删除该商品吗?',
            button: {
                confirm: '确定',
                cancel: '取消',
            },
            onConfirm: function() {
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/ShoppingCartServlet",
                    data:{
                        "action":"deleteOne",
                        "id":realId
                    },
                    dateType:"text",
                    success:function (msg) {
                        if(msg==="移除成功!")
                            $.sendSuccess(msg, 3000, function() {
                                console.log('sendSuccess closed');
                            });
                        window.setTimeout("window.location.reload(true)",3000);
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

    $('#confirmDescConfirmIcon').click(function() {
        $.sendConfirm({
            hideHeader: true,
            withIcon: true,
            desc: '确定清空购物车吗  > <',
            button: {
                confirm: '确定',
                cancel: '取消'
            },
            onConfirm: function() {
                $.ajax({
                    type:"post",
                    url:"<%=request.getContextPath()%>/ShoppingCartServlet",
                    data:{
                        "action":"deleteAll"
                    },
                    dateType:"text",
                    success:function (msg) {
                        if(msg==="清空成功!")
                            $.sendSuccess(msg, 3000, function() {
                                console.log('sendSuccess closed');
                            });
                        window.setTimeout("window.location.reload(true)",3000);
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

    function buy() {
        window.setTimeout("window.location='pay.jsp'");
    }
</script>
</body>
</html>

