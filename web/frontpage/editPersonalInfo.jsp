<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/4/25
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/info.jsp"%>
<%@include file="../common/tanchuceng.jsp"%>
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
            <label for="u_id" class="layui-form-label">
                <span class="x-red">*</span>用户id
            </label>
            <div class="layui-input-inline">
                <input readonly="readonly" value="" type="text" id="u_id" name="u_id"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>用户名
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="username" name="username"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="name" class="layui-form-label">
                <span class="x-red">*</span>真实姓名
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="name" name="name"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="id" class="layui-form-label">
                <span class="x-red">*</span>身份证号
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="id" name="id"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="sex" class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="sex" name="sex"
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
            <label for="email" class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="email" name="email"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="address" class="layui-form-label">
                <span class="x-red">*</span>收货地址
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="address" name="address"
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
            <label  class="layui-form-label">
            </label>
            <button  class="layui-btn" lay-filter="update" lay-submit="" style="margin-left: 50px">
                更新
            </button>
        </div>
    </form>
</div>
<script>
    var u_id;
    var username;
    var name;
    var id;
    var sex;
    var phone;
    var email;
    var address;
    var password;
    function child(user) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        u_id=user.u_id;
        username = user.username;
        name=user.name;
        id = user.id;
        sex = user.sex;
        phone = user.phone;
        email = user.email;
        address = user.address;
        password = user.password;
        $("#u_id").attr("value", u_id);
        $("#username").attr("value", username);
        $("#name").attr("value", name);
        $("#id").attr("value", id);
        $("#sex").attr("value", sex);
        $("#phone").attr("value", phone);
        $("#email").attr("value", email);
        $("#address").attr("value", address);
        $("#password").attr("value", password);
    }
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //监听提交
        form.on('submit(update)', function(){
            username=document.getElementById("username").value;
            name=document.getElementById("name").value;
            id=document.getElementById("id").value;
            sex=document.getElementById("sex").value;
            phone=document.getElementById("phone").value;
            email=document.getElementById("email").value;
            address=document.getElementById("address").value;
            password=document.getElementById("password").value;
            $.ajax({
                type:"post",
                url:"<%=request.getContextPath()%>/UserServlet",
                data:{
                    "action":"update",
                    "u_id":u_id,
                    "username":username,
                    "name":name,
                    "id":id,
                    "sex":sex,
                    "phone":phone,
                    "email":email,
                    "address":address,
                    "password":password,
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
