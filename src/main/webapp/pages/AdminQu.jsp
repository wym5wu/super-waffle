<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <script src="/js/jquery-3.5.1.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<br>
<div align="center">

</div>
<div class="demoTable" align="center">

    <div class="layui-inline">
        <label class="layui-form-label">注册日期：</label>
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" id="beginTime" placeholder="yyyy-MM-dd">
        </div>
       至
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" id="endTime" placeholder="yyyy-MM-dd">
        </div>
    </div>

</div>
</br>
<div class="demoTable" align="center">
    用户名：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


<script src="/layui/layui.js" charset="utf-8"></script>

<script>
    var countNum;
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#beginTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            ,url: '/backstageServlet?whatName=adminInfo'
            ,cellMinWidth:80
            ,cols: [[
                {field:'id', title: 'id',hide:true}
                ,{field:'adminName', title: '用户名'}
                ,{field:'updateTime', title: '注册时间', sort: true}
                ,{field:'experience', title: '积分', sort: true}
                ,{field:'experience', title: '上传文档数', sort: true}
                ,{field:'experience', title: '下载文档数', sort: true}
                ,{field:'state', title: '用户状态', sort: true}
            ]],
            done : function(res, curr, count){
                // do something...
                console.log(res)
                console.log(curr)
                console.log(count)
                countNum =count;

            }
            ,id: 'testReload'
            ,page: {
                limit:5,
                limits:[3,5,7]
            }
            ,height: 310

        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');
                var endTime =$('#endTime');
                var beginTime =$('#beginTime ');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        name: demoReload.val(),
                        endTime: endTime.val(),
                        beginTime: beginTime.val()
                    }
                }, 'data');
            }

        };



        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>

</body>
</html>