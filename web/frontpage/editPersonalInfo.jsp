<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/25
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/info.jsp" %>
<%@ include file="../common/tanchuceng.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑个人资料</title>
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
</head>
<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label for="linkId" class="layui-form-label">
                <span class="x-red"></span>
            </label>
            <div class="layui-input-inline">
                <input value="" type="hidden" id="linkId" name="linkId" required="" lay-verify=""
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input readonly="readonly" value="" type="text" id="name" name="name"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="password" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="password" name="password"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="phone" class="layui-form-label">
                <span class="x-red">*</span>手机号
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="phone" name="phone"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="addr" class="layui-form-label">
                <span class="x-red">*</span>收货地址
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="addr" name="addr"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="">
                更新
            </button>
        </div>
    </form>
</div>
<script>
    var username;
    var phone;
    var password;
    var addr;
    function child(user) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        id = user.id;
        username = user.username;
        phone = user.phone;
        password = user.password;
        addr = user.addr;
        $("#name").attr("value", username);
        $("#phone").attr("value", phone);
        $("#password").attr("value", password);
        $("#addr").attr("value", addr);
    }
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(update)', function(){
            password=document.getElementById("password").value;
            phone=document.getElementById("phone").value;
            addr=document.getElementById("addr").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/UserServlet",
                data:{
                    "action":"update",
                    "username":username,
                    "password":password,
                    "phone":phone,
                    "addr":addr,
                },
                success:function (msg) {
                    if(msg==="更新资料成功!"){
                        $.sendSuccessToTop(msg, 3000, function() {
                            console.log('sendSuccessToTop closed');
                        });
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        window.setTimeout("parent.layer.close(index);",3000);
                        window.setTimeout("window.parent.location.reload();",3000);
                    }else{
                        $.sendWarning(msg, 3000, function() {
                            console.log('sendWarning closed');
                        });
                    }
                },
                error:function () {
                    layer.msg("修改异常!");
                }
            });
            return false;
        });
    });
</script>
</body>
</html>