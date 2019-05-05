<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/info.jsp" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>会员管理表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="#">首页</a>
        <a>
          <cite>会员管理</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <%--<div class="layui-btn-container">--%>
            <%--<button class="layui-btn" lay-event="add">--%>
                <%--<i class="layui-icon"></i>添加--%>
            <%--</button>--%>
        <%--</div>--%>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
    </script>
    <script>
        layui.use('table', function () {
            var table = layui.table;
            table.render({
                elem: '#test'
                , url: '<%=request.getContextPath()%>/UserServlet?action=query'
                , toolbar: '#toolbarDemo'
                , title: '会员管理表'
                , cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    , {field: 'u_id', title: '编号', fixed: 'left', sort: true}
                    , {field: 'username', title: '账号'}
                    , {field: 'password', title: '密码'}
                    , {field: 'name', title: '姓名'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
                ]]
                , page: true
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
                            url: "<%=request.getContextPath()%>/UserServlet",
                            data: {
                                action: "delete",
                                u_id: data.u_id
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
                        type: 2,
                        title: "详情信息",
                        closeBtn: 1, //不显示关闭按钮
                        shade: [0],
                        area: ['620px', '540px'],
                        offset: 'auto', //右下角弹出
                        anim: 2,
                        content: ['<%=request.getContextPath()%>/UserServlet?action=queryOne&u_id='+data.u_id, 'no'], //iframe的url，no代表不显示滚动条
                        end: function(){ //此处用于演示 关闭之后执行
                        }
                    });
                }
            });
        });
    </script>
</div>

</body>
</html>