<%--
  Created by IntelliJ IDEA.
  User: wzh82
  Date: 2019/5/2
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/info.jsp" %>
<%@ include file="../common/tanchuceng.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改上架物品信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
</head>
<body>
<div class="x-body">
        <input hidden="hidden" id="hiddenId" value="">
        <div class="layui-form-item">
            <label for="title" class="layui-form-label">
                <span class="x-red">*</span>物品名称
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="title" name="title" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="type" class="layui-form-label">
                <span class="x-red">*</span>物品类型
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="type" name="type"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="image" class="layui-form-label">
                <span class="x-red">*</span>物品图片
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="image" name="image"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
                <span class="x-red">*</span>物品价格
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="price" name="price"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="stock" class="layui-form-label">
                <span class="x-red">*</span>库存
            </label>
            <div class="layui-input-inline">
                <input value="" type="number" id="stock" name="stock"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="introduce" class="layui-form-label">
                <span class="x-red">*</span>商品简介
            </label>
            <div class="layui-input-inline">
                <input value="" type="text" id="introduce" name="introduce"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label  class="layui-form-label">
            </label>
            <button  onclick="update()"  class="layui-btn">
                更新
            </button>
        </div>
</div>
<script>
    function update() {
        $.ajax({
            type: "post",
            url: "<%=request.getContextPath()%>/ershouServlet",
            data: {
                "action": "update",
                "id": $("#hiddenId").val(),
                "title": $("#title").val(),
                "type": $("#type").val(),
                "image": $("#image").val(),
                "price": $("#price").val(),
                "stock": $("#stock").val(),
                "introduce": $("#introduce").val()
            },
            dateType: "text",
            success: function (msg) {
                if (msg === "更新成功!") {
                    alert(msg);
                } else if(msg === "更新失败!") {
                    alert(msg);
                }
            }
        });
    }

    function child(object1) {
        //在这里你可以写你的jquery $(function(){ })   等等操作
        var id = object1.id;
        var title = object1.title;
        var type = object1.type;
        var image = object1.image;
        var price = object1.price;
        var stock = object1.stock;
        var introduce = object1.introduce;
        $("#hiddenId").val(id);
        $("#title").val(title);
        $("#type").val(type);
        $("#image").val(image);
        $("#price").val(price);
        $("#stock").val(stock);
        $("#introduce").val(introduce);
    }
</script>
</body>