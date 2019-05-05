<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- css和js的引用封装在info.jsp -->
<%@ include file="/common/info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改职员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

</head>
<body>
<div class="x-body">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red"></span>编号
            </label>
            <div class="layui-input-inline">
                <input type="text" name="officeId" class="layui-input" readonly="readonly" value="${office.officeId}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>职员名
            </label>
            <div class="layui-input-block">
                <input type="text" name="officeName" class="layui-input" lay-verify="required"  value="${office.officeName}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>性别
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="sex" lay-verify="required" value="${office.sex}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>联系电话
            </label>
            <div class="layui-input-block">
                <input type="number" class="layui-input" name="phone" lay-verify="required" value="${office.phone}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>邮箱
            </label>
            <div class="layui-input-block">
                <input type="email" class="layui-input" name="email" lay-verify="required" value="${office.email}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>详细住址
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="address" lay-verify="required" value="${office.address}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>学历
            </label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="degree" lay-verify="required" value="${office.degree}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>入职时间
            </label>
            <div class="layui-input-block">
                <input type="date" class="layui-input" name="officeTime" lay-verify="required" value="${office.officeTime}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-block">
                <input type="text" name="password" class="layui-input" lay-verify="required"  value="${office.password}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="update" lay-submit="">
                保存
            </button>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layer'], function () {
        $ = layui.jquery;
        var form = layui.form
            , layer = layui.layer;
        //监听提交
        form.on('submit(update)', function (data) {
            //发异步，把数据提交给Servlet
            $.ajax({
                type: "post",
                url: "<%=request.getContextPath()%>/OfficeServlet",
                data: {
                    //       private int officeId;//职员编号
// private String officeName;//职员姓名
// private String roleName;//角色名（超级管理员/普通管理员）
// private String sex;//性别
// private int phone;//联系电话
// private String email;//邮箱
// private String address;//详细住址
// private String degree;//学历
// private Date officeTime;//入职时间
// private String password;//登陆密码
                    action: "updateOffice",
                    officeId: data.field. officeId,
                    officeName: data.field. officeName,
                    sex: data.field. sex,
                    phone: data.field. phone,
                    email: data.field. email,
                    address: data.field. address,
                    degree: data.field. degree,
                    officeTime: data.field. officeTime,
                    password: data.field.password
                },
                success: function (msg) {
                    if (msg == 1) {
                        layer.alert("修改成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            // 关闭当前frame
                            parent.layer.close(index);
                            // 刷新父frame
                            window.parent.location.reload();
                        });
                    } else {
                        layer.msg("修改失败")
                    }
                },
                error: function () {
                    layer.msg("修改异常")
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
