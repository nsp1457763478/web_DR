<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="../static/css/login.css">
    <script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
</head>
<body>
<div class="login">
    <%
        session.removeAttribute("officeName");
        session.removeAttribute("office");
    %>
    <div class="login_title">
        <p>DR</p>
    </div>
    <div class="login_main">
        <div class="main_left"></div>
        <div class="main_right">
            <div class="right_title">用户登录</div>
            <form action="#" method="post" onsubmit="return false">
                <span style="color: red;margin-left: 50px;font-size: 14px"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></span>
                <div class="officeName">
                    <input id="officeName" type="text" placeholder="请输入职员名">
                </div>
                <div class="password">
                    <input id="password" type="password" placeholder="请输入密码">
                </div>
                <div class="code">
                    <input type="text" id="code" placeholder="请输入验证码">
                    <div class="code_img">
                        <img id="imgObj" alt="验证码" src="${pageContext.request.contextPath}/getCode"><a
                            href="" onclick="changeImg()">换一张</a><br/>
                    </div>
                </div>
                <input class="yes_login" type="button" id="login" value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
            </form>
        </div>
    </div>

</div>
<script type="text/javascript">
    $(function () {

    });

    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
</script>

<script>
    $('#login').click(function () {
        var officeName = $('#officeName').val();
        var password = $('#password').val();
        var code = $('#code').val();
        $.ajax({
            type: "POST",//方法类型
            url: "<%=request.getContextPath()%>/OfficeServlet",//url
            data: {
                action: "findOfficeByOfficeName",
                officeName: officeName,
                password: password,
                code: code
            },
            success: function (result) {

                if (result == 200) {
                    alert("SUCCESS");
                    window.location.href = "/background/Start.jsp";
                  // request.getSession().setAttribute("officeName",officeName);
                } else if (result == 201) {
                    alert("密码错误");
                    window.location.reload()
                } else if (result == 202) {
                    alert("用户名不存在");
                    window.location.reload()
                } else if (result == 203) {
                    alert("验证码错误");
                    window.location.reload()
                } else if (result == 204) {
                    alert("请输入验证码");
                    window.location.reload()
                }
            },
            error: function () {
                alert("异常！");
                window.location.reload()
            }
        })
    });
</script>
</body>
</html>