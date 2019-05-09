<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/3/27
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/info.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">网站管理</a>
        <a>
          <cite>会员详情</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="x-body">
        <table class="layui-hide" id="tab" lay-filter="test"></table>

        <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        </div>
        </script>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });
            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });

        });

        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#tab'
                //返回一个json字符串
                ,url:'<%=request.getContextPath()%>/CommentServlet?action=findAll'
                ,toolbar: '#toolbarDemo'
                ,title: '被举报留言'
                ,cols: [[
                    {type: 'checkbox', fixed: 'left'}
                    ,{field:'id', title:'留言ID', fixed: 'left', sort: true}
                    ,{field:'wupinId', title:'留言所属物品ID',sort: true}
                    ,{field:'user', title:'留言用户'}
                    ,{field:'comment', title:'内容'}
                    ,{field:'date', title:'日期',sort: true}
                    ,{field:'right', title:'操作',toolbar:'#barDemo'}
                ]]
                ,page: true
                ,limit:10
            });

            //头工具栏事件
            table.on('toolbar(test)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                switch(obj.event){
                    case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：'+ data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选': '未全选');
                        break;
                };
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                //console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        layer.close(index);
                        $.ajax({
                            type:"post",
                            url:"<%=request.getContextPath()%>/CommentServlet",
                            data:{
                                "action":"deleteOne",
                                "id":data.id
                            },
                            success:function (msg) {
                                layer.msg(msg,{icon:1,time:1000});
                            }
                        });
                    });
                }
                // else if(obj.event === 'edit'){
                //     layer.open({
                //         title: this.text,
                //         type: 2,
                //         skin: 'layui-layer-rim', //加上边框
                //         area: [window.screen.width / 2 + 'px', window.screen.height / 2 + 'px'], //宽高
                //         maxmin: true, //开启最大化最小化按钮
                //         content: "typeUpdate.jsp",
                //         success: function (layero, index) {
                //             // 获取子页面的iframe
                //             var iframe = window['layui-layer-iframe' + index];
                //             // 向子页面的全局函数child传参
                //             iframe.child(data);
                //         }
                //     })
                // }
                else{
                    layer.msg("请至少选择一行",{icon:1,time:1000});
                }
            });
        });
    </script>
</body>
</html>
