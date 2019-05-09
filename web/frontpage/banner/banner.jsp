<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/7
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jQuery</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/shutter.css">

</head>
<body>

<div class="shutter">
    <div class="shutter-img">
        <a href="#" data-shutter-title="'宠' 就一个字，爱就一个人"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel.jpg" alt="#"></a>
        <a href="#" data-shutter-title="唐嫣倾情代言"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel02.jpg" alt="#"></a>
        <a href="#" data-shutter-title="幸福摩天轮系列"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel08.jpg" alt="#"></a>
        <a href="#" data-shutter-title="浪漫钻戒 为爱定制"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel04.jpg" alt="#"></a>
        <a href="#" data-shutter-title="此生真爱 唯你一人"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel05.jpg" alt="#"></a>
        <a href="#" data-shutter-title="让每一次出游变成一种期待"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel06.jpg" alt="#"></a>
        <a href="#" data-shutter-title="下半身的惊喜，是你"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel07.jpg" alt="#"></a>
        <a href="#" data-shutter-title="浪漫婚礼 深情对戒"><img src="<%=request.getContextPath()%>/static/tesiro/carousel/carousel09.jpg" alt="#"></a>
    </div>
    <ul class="shutter-btn">
        <li class="prev"></li>
        <li class="next"></li>
    </ul>
</div>

<script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/velocity.js"></script>
<script src="<%=request.getContextPath()%>/static/js/shutter.js"></script>
<script>
    $(function () {
        $('.shutter').shutter({
            shutterW: 1226, // 容器宽度
            shutterH: 440, // 容器高度
            isAutoPlay: true, // 是否自动播放
            playInterval: 4000, // 自动播放时间
            curDisplay: 1, // 当前显示页
            fullPage: false // 是否全屏展示
        });
    });
</script>
</body>
</html>