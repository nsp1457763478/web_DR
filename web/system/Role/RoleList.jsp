<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>系统角色管理表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>系统角色管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn" lay-event="add">
                <i class="layui-icon"></i>添加
            </button>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="grant">赋予权限</a>
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;
            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/RoleServlet?action=getAllRoleByPage'
                , toolbar: '#toolbarDemo'
                , width: 1200
                , title: '角色管理表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'roleId', title: '编号', fixed: 'left', sort: true}
                    , {field: 'roleName', title: '角色名'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
            });

            //头工具栏事件
            table.on('toolbar(test)', function (obj) {
                if (obj.event === 'add') {
                    layer.open({
                        title: '添加角色',
                        type: 2,
                        closeBtn: 1,
                        skin: 'layui-layer-rim', // 加上边框
                        area: ['451px', '405px'], // 宽高
                        content: '<%=request.getContextPath()%>/system/Role/AddRole.jsp'
                    });
                }
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                var data = obj.data;
                if (obj.event === 'del') {
                    layer.confirm('真的要删除吗？', function (index) {
                        layer.close(index);
                        //发异步 删除数据
                        $.ajax({
                            type: "post",
                            url: "<%=request.getContextPath()%>/RoleServlet",
                            data: {
                                action: "deleteRole",
                                roleId: data.roleId
                            },
                            success: function (msg) {
                                if (msg == 1) {
                                    layer.alert("删除成功", {icon: 6});
                                } else {
                                    layer.msg("已被删除或不存在", {icon: 2, time: 2000});
                                }
                                obj.del();
                            },
                            error: function () {
                                layer.msg("删除异常")
                            }
                        });
                    });
                } else if (obj.event === 'edit') {
                    layer.open({
                        title: '角色修改',
                        type: 2,
                        skin: 'layui-layer-rim', // 加上边框
                        area: ['451px', '405px'], // 宽高
                        content: '<%=request.getContextPath()%>/RoleServlet?action=editRole&roleId=' + data.roleId
                    });
                } else if (obj.event === 'grant') {
                    layer.open({
                        title: '赋予权限',
                        type: 2,
                        skin: 'layui-layer-rim', // 加上边框
                        area: [$(window).width() * 0.9 + 'px', $(window).height() * 0.9 + '620px'], // 宽高
                        content: '<%=request.getContextPath()%>/RoleServlet?action=toGrant&roleId=' + data.roleId
                    });
                }
            });
        });
    </script>
</div>

</body>
</html>